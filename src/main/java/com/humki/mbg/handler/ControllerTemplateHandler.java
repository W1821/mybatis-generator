package com.humki.mbg.handler;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class ControllerTemplateHandler extends TemplateHandler {

    public static void generateControllerFile(Properties properties, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String packageController = properties.getProperty("controller");
        String tableName = topLevelClass.getType().getShortName();

        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("package", packageController);
        dataMap.put("tableName", tableName);
        dataMap.put("moduleTag", introspectedTable.getRemarks());

        dataMap.put("packageService", properties.getProperty("service"));
        dataMap.put("packageDto", properties.getProperty("dto"));

        String parentPath = introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetProject() + "/" + packageController.replaceAll("\\.", "/");
        mkdirs(parentPath);

        String filePath = parentPath + '/' + tableName + "Controller.java";
        templateProcess("Controller.ftl", filePath, dataMap);
    }

}
