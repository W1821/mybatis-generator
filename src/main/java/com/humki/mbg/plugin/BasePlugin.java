package com.humki.mbg.plugin;


import com.humki.mbg.util.UUIDUtil;
import com.humki.mbg.annotation.BaseAnnotation;
import com.humki.mbg.handler.ControllerTemplateHandler;
import com.humki.mbg.handler.DtoTemplateHandler;
import com.humki.mbg.handler.ServiceTemplateHandler;
import com.humki.mbg.handler.XmlTemplateHandler;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;


@Slf4j
public class BasePlugin extends PluginAdapter {


    /**
     * 验证参数
     */
    public boolean validate(List<String> list) {
        String superClass = properties.getProperty("entitySuperClass");
        if (superClass == null) {
            log.error("配置文件错误！entitySuperClass不存在！");
            return false;
        }
        String packageController = properties.getProperty("controller");
        if (packageController == null) {
            log.error("配置文件错误！controller不存在！");
            return false;
        }
        String packageService = properties.getProperty("service");
        if (packageService == null) {
            log.error("配置文件错误！service不存在！");
            return false;
        }
        String packageDto = properties.getProperty("dto");
        if (packageDto == null) {
            log.error("配置文件错误！dto不存在！");
            return false;
        }
        String packageXml = properties.getProperty("xml");
        if (packageXml == null) {
            log.error("配置文件错误！xml不存在！");
            return false;
        }
        return true;
    }

    /* ===================================================== 处理实体类 start ======================================================== */

    /**
     * 修改实体类
     */
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // import swagger
        topLevelClass.addImportedType(BaseAnnotation.ApiModel.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.ApiModelProperty.getClazz());
        // import lombok
        topLevelClass.addImportedType(BaseAnnotation.AllArgsConstructor.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.NoArgsConstructor.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.Getter.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.Setter.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.Builder.getClazz());
        // import persistence
        topLevelClass.addImportedType(BaseAnnotation.Table.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.Id.getClazz());
        topLevelClass.addImportedType(BaseAnnotation.Column.getClazz());

        //添加注解
        topLevelClass.addJavaDocLine(BaseAnnotation.AllArgsConstructor.getAnnotation());
        topLevelClass.addJavaDocLine(BaseAnnotation.NoArgsConstructor.getAnnotation());
        topLevelClass.addJavaDocLine(BaseAnnotation.Getter.getAnnotation());
        topLevelClass.addJavaDocLine(BaseAnnotation.Setter.getAnnotation());
        topLevelClass.addJavaDocLine(BaseAnnotation.Builder.getAnnotation());
        topLevelClass.addJavaDocLine(BaseAnnotation.ApiModel.getAnnotation() + "(\"" + introspectedTable.getRemarks() + "\")");
        topLevelClass.addJavaDocLine(BaseAnnotation.Table.getAnnotation() + "(name = \"" + introspectedTable.getFullyQualifiedTableNameAtRuntime() + "\")");

        // 增加父类
        String superClass = properties.getProperty("entitySuperClass");
        topLevelClass.addImportedType(superClass);
        topLevelClass.setSuperClass(superClass.substring(superClass.lastIndexOf(".") + 1));

        // 生成controller文件
        ControllerTemplateHandler.generateControllerFile(properties, topLevelClass, introspectedTable);
        // 生成service文件
        ServiceTemplateHandler.generateServiceFile(properties, topLevelClass, introspectedTable);
        // 生成dto文件
        DtoTemplateHandler.generateDtoFile(properties, topLevelClass, introspectedTable);
        // 生成xml文件
        XmlTemplateHandler.generateXmlFile(properties, topLevelClass, introspectedTable);

        return true;
    }

    /**
     * 实体类字段
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        // 追加ApiModelProperty注解
        topLevelClass.addImportedType(new FullyQualifiedJavaType(BaseAnnotation.ApiModelProperty.getClazz()));
        field.addAnnotation(BaseAnnotation.ApiModelProperty.getAnnotation() + "(value = \"" + introspectedColumn.getRemarks() + "\", required = " + !introspectedColumn.isNullable() + ")");

        // 增加@Column
        field.addAnnotation(BaseAnnotation.Column.getAnnotation() + "(name = \"" + introspectedColumn.getActualColumnName() + "\")");

        // 输出数据字典类型的字段 sql
        printInsertSql(introspectedColumn.getRemarks(), introspectedColumn);

        return true;
    }


    /**
     * get方法 false 不生成
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * get方法 false 不生成
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    private void printInsertSql(String remark, IntrospectedColumn column) {
        String sql = "INSERT INTO `system_dict` VALUES ('id', '-1', '字典名称', '字典编码', '1', '字典值', '', 0);";
        String dictName = column.getActualColumnName().replaceAll(" ", "");
        if (remark.contains(":") || remark.contains("：")) {
            return;
        }
        String regex = dictName.endsWith("code") ? "code" : dictName.endsWith("codes") ? "code" : null;
        if (regex == null) {
            return;
        }
        String code = dictName.replaceAll(regex, "").toUpperCase();
        if (code.length() > 20) {
            code = code.substring(0, code.lastIndexOf("_"));
        }
        sql = sql.replaceAll("id", UUIDUtil.getUUID())
                .replaceAll("字典名称", remark)
                .replaceAll("字典编码", code)
                .replaceAll("字典值", remark);

        System.out.println();
        log.info(sql.replaceAll("数据字典表code", ""));
        System.out.println();
    }

    /* ===================================================== 处理实体类 end ======================================================== */

}
