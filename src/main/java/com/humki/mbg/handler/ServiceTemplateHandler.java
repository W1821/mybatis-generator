package com.humki.mbg.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class ServiceTemplateHandler extends TemplateHandler {


    public static void generateServiceFile(Properties properties, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String packageService = properties.getProperty("service");
        String tableName = topLevelClass.getType().getShortName();

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("package", packageService);
        dataMap.put("tableName", tableName);

        dataMap.put("packageDto", properties.getProperty("dto"));
        dataMap.put("packageMapper", introspectedTable.getContext().getJavaClientGeneratorConfiguration().getTargetPackage());

        // req转entity
        StringBuilder sb = new StringBuilder();
        List<Field> fields = topLevelClass.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (StringUtils.equals("updateUser", fieldName) || StringUtils.equals("updateTime", fieldName) || StringUtils.equals("deleted", fieldName)) {
                continue;
            }
            sb.append("\t\t\t\t.").append(fieldName).append("(").append("req.get").append(fieldName).append("())\r\n");
        }
        sb.insert(0, "\r\n");
        dataMap.put("build", sb.toString());

        String parentPath = introspectedTable.getContext().getJavaModelGeneratorConfiguration().getTargetProject() + "/" + packageService.replaceAll("\\.", "/");
        mkdirs(parentPath);

        String filePath = parentPath + '/' + tableName + "Service.java";
        templateProcess("Service.ftl", filePath, dataMap);
    }


}
