package com.humki.mbg.handler;

import com.humki.mbg.field.ReqDtoTemplateField;
import com.humki.mbg.field.ResDtoTemplateField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.*;

@Slf4j
public class DtoTemplateHandler extends TemplateHandler {


    public static void generateDtoFile(Properties properties, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String packageDto = properties.getProperty("dto");
        String parentPath = introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetProject() + "/" + packageDto.replaceAll("\\.", "/");
        mkdirs(parentPath);

        // 实体类中的所有属性，去除几个不用的
        List<Field> fields = getFields(topLevelClass);
        // 表字段信息Map
        Map<String, IntrospectedColumn> columnMap = getColumnMap(introspectedTable);

        String tableName = topLevelClass.getType().getShortName();
        Map<String, Object> dataMap = getDataMap(introspectedTable, packageDto, tableName);

        reqDataMap(dataMap, fields, columnMap);
        // 生成 列表查询 请求对象
        templateProcess("QueryListReq.ftl", parentPath + "/Query" + tableName + "ListReq.java", dataMap);

        resDataMap(dataMap, fields, columnMap);
        // 生成 列表查询 响应对象
        templateProcess("QueryListRes.ftl", parentPath + "/Query" + tableName + "ListRes.java", dataMap);
        // 生成 详细查询 响应对象
        templateProcess("QueryRes.ftl", parentPath + "/Query" + tableName + "Res.java", dataMap);

        reqSaveDataMap(dataMap, fields, columnMap);
        // 生成 保存 对象
        templateProcess("SaveReq.ftl", parentPath + "/Save" + tableName + "Req.java", dataMap);
        // 生成 新增 对象
        templateProcess("AddReq.ftl", parentPath + "/Add" + tableName + "Req.java", dataMap);
        // 生成 修改 对象
        templateProcess("UpdateReq.ftl", parentPath + "/Update" + tableName + "Req.java", dataMap);

    }


    private static Map<String, Object> getDataMap(IntrospectedTable introspectedTable, String packageDto, String tableName) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("package", packageDto);
        dataMap.put("moduleTag", introspectedTable.getRemarks());
        dataMap.put("tableName", tableName);
        return dataMap;
    }

    private static void reqDataMap(Map<String, Object> dataMap, List<Field> fields, Map<String, IntrospectedColumn> columnMap) {
        List<ReqDtoTemplateField> list = new ArrayList<>();
        for (Field field : fields) {
            // 属性类型
            String fieldType = field.getType().getShortName();
            // 表字段
            IntrospectedColumn column = columnMap.get(field.getName());
            ReqDtoTemplateField dtoTemplateField = buildReqDtoTemplateField(field, column);
            list.add(dtoTemplateField);

            String remarks = getRemarks(column.getRemarks());
            switch (fieldType) {
                case "String":
                    dtoTemplateField.setLength(getLengthAnnotation(column, remarks));
                    dtoTemplateField.setNotBlank(getNotBlankAnnotation(remarks));
                    break;
                case "Long":
                case "Integer":
                    dtoTemplateField.setRange(getRangeAnnotation(remarks));
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
                case "BigDecimal":
                    dtoTemplateField.setDecimalMin(getDecimalMinAnnotation(remarks));
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
                case "Date":
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
            }
        }
        dataMap.put("fields", list);
    }

    private static void reqSaveDataMap(Map<String, Object> dataMap, List<Field> fields, Map<String, IntrospectedColumn> columnMap) {
        List<ReqDtoTemplateField> list = new ArrayList<>();
        for (Field field : fields) {
            // 属性类型
            String fieldType = field.getType().getShortName();
            // 表字段
            IntrospectedColumn column = columnMap.get(field.getName());
            ReqDtoTemplateField dtoTemplateField = buildReqSaveDtoTemplateField(field, column);
            list.add(dtoTemplateField);

            String remarks = getRemarks(column.getRemarks());
            switch (fieldType) {
                case "String":
                    dtoTemplateField.setLength(getLengthAnnotation(column, remarks));
                    dtoTemplateField.setNotBlank(getNotBlankAnnotation(remarks));
                    break;
                case "Long":
                case "Integer":
                    dtoTemplateField.setRange(getRangeAnnotation(remarks));
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
                case "BigDecimal":
                    dtoTemplateField.setDecimalMin(getDecimalMinAnnotation(remarks));
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
                case "Date":
                    dtoTemplateField.setNotNull(getNotNullAnnotation(remarks));
                    break;
            }
        }
        dataMap.put("fields", list);
    }

    private static void resDataMap(Map<String, Object> dataMap, List<Field> fields, Map<String, IntrospectedColumn> columnMap) {
        List<ResDtoTemplateField> list = new ArrayList<>();
        for (Field field : fields) {
            // 属性类型
            String fieldType = field.getType().getShortName();
            // 表字段
            IntrospectedColumn column = columnMap.get(field.getName());
            ResDtoTemplateField dtoTemplateField = buildResDtoTemplateField(field, column);
            list.add(dtoTemplateField);
            if (StringUtils.equals("Date", fieldType)) {
                dtoTemplateField.setJsonFormat(getJsonFormatAnnotation());
            }
            // 字段是数据字典
            handleDictionary(field, column, list);
        }
        dataMap.put("fields", list);
    }

    private static ReqDtoTemplateField buildReqDtoTemplateField(Field field, IntrospectedColumn column) {
        return ReqDtoTemplateField.builder()
                .apiModelProperty(getApiModelPropertyAnnotation(column))
                .fieldType(field.getType().getShortName())
                .fieldName(field.getName())
                .build();
    }

    private static ReqDtoTemplateField buildReqSaveDtoTemplateField(Field field, IntrospectedColumn column) {
        return ReqDtoTemplateField.builder()
                .apiModelProperty(getApiModelPropertyAnnotationRequired(column))
                .fieldType(field.getType().getShortName())
                .fieldName(field.getName())
                .build();
    }

    private static ResDtoTemplateField buildResDtoTemplateField(Field field, IntrospectedColumn column) {
        return ResDtoTemplateField.builder()
                .apiModelProperty(getApiModelPropertyAnnotationRes(column))
                .fieldType(field.getType().getShortName())
                .fieldName(field.getName())
                .build();
    }

    private static void handleDictionary(Field field, IntrospectedColumn column, List<ResDtoTemplateField> list) {
        String fieldName = field.getName();
        if (fieldName.endsWith("Code")) {
            ResDtoTemplateField fieldValue = buildDictionaryFieldValue(column);
            fieldValue.setFieldName(fieldName.replaceAll("Code", "Value"));
            list.add(fieldValue);
        }
        if (fieldName.endsWith("Codes")) {
            ResDtoTemplateField fieldValue = buildDictionaryFieldValue(column);
            fieldValue.setFieldName(fieldName.replaceAll("Codes", "Value"));
            list.add(fieldValue);
        }
    }

    private static ResDtoTemplateField buildDictionaryFieldValue(IntrospectedColumn column) {
        return ResDtoTemplateField.builder()
                .apiModelProperty(getApiModelPropertyAnnotationRes(column))
                .fieldType("String")
                .build();
    }


}
