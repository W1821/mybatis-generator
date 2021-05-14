package com.humki.mbg.handler;

import com.google.common.base.CaseFormat;
import com.humki.mbg.field.XmlColumn;
import com.humki.mbg.field.XmlTemplateElement;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
public class XmlTemplateHandler extends TemplateHandler {

    public static void generateXmlFile(Properties properties, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String packageXml = properties.getProperty("xml");
        String tableName = topLevelClass.getType().getShortName();

        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("packageMapper", introspectedTable.getContext().getJavaClientGeneratorConfiguration().getTargetPackage());
        dataMap.put("tableName", tableName);

        List<XmlColumn> columns = introspectedTable.getAllColumns().stream()
                .map(column -> XmlColumn.builder()
                        .column(column.getActualColumnName())
                        .property(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getActualColumnName()))
                        .remark(column.getRemarks())
                        .build())
                .collect(Collectors.toList());
        Integer max = columns.stream().mapToInt(column -> column.getColumn().length() + column.getProperty().length()).max().orElse(0);
        columns.forEach(column -> column.setSpace(getSpace(max, column)));

        XmlTemplateElement queryList = XmlTemplateElement.builder().resultType(properties.getProperty("dto") + "Query" + tableName + "ListRes").columns(columns).build();
        dataMap.put("queryList", queryList);

        XmlTemplateElement queryById = XmlTemplateElement.builder().resultType(properties.getProperty("dto") + "Query" + tableName + "Res").columns(columns).build();
        dataMap.put("queryById", queryById);

        dataMap.put("actualTableName", introspectedTable.getFullyQualifiedTableNameAtRuntime());

        String parentPath = introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetProject() + "/" + packageXml.replaceAll("\\.", "/");
        mkdirs(parentPath);

        String filePath = parentPath + '/' + tableName + "Mapper.xml";
        templateProcess("Xml.ftl", filePath, dataMap);
    }

    private static String getSpace(Integer max, XmlColumn column) {
        StringBuilder sb = new StringBuilder();
        int length = max + 8 - column.getColumn().length() - column.getProperty().length();
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
