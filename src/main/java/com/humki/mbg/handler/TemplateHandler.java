package com.humki.mbg.handler;

import com.google.common.base.CaseFormat;
import com.humki.mbg.annotation.BaseAnnotation;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class TemplateHandler {

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static {
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(TemplateHandler.class, "/template"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    protected static void templateProcess(String templateName, String filePath, Map<String, Object> dataMap) {
        File file = new File(filePath);
        try (
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                Writer out = new BufferedWriter(osw, 10240)
        ) {
            Template template = getTemplate(templateName);
            template.process(dataMap, out);
        } catch (IOException | TemplateException e) {
            log.error("模板处理失败！", e);
        }
    }

    protected static void mkdirs(String path) {
        File catalog = new File(path);
        if (!catalog.exists() && !catalog.mkdirs()) {
            log.error("创建目录失败");
        }
    }

    protected static List<Field> getFields(TopLevelClass topLevelClass) {
        return topLevelClass.getFields().stream()
                .filter(field -> !StringUtils.equals("createUser", field.getName()))
                .filter(field -> !StringUtils.equals("createTime", field.getName()))
                .filter(field -> !StringUtils.equals("updateUser", field.getName()))
                .filter(field -> !StringUtils.equals("updateTime", field.getName()))
                .filter(field -> !StringUtils.equals("deleted", field.getName()))
                .collect(Collectors.toList());
    }

    protected static Map<String, IntrospectedColumn> getColumnMap(IntrospectedTable introspectedTable) {
        return introspectedTable.getAllColumns().stream()
                .collect(Collectors.toMap(e -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, e.getActualColumnName()), Function.identity(), (k1, k2) -> k2));
    }

    protected static String getRemarks(String remark) {
        if (StringUtils.isEmpty(remark)) {
            return "";
        }
        if (!remark.contains(":") && !remark.contains("：")) {
            return remark;
        }
        int index = remark.indexOf(",");
        index = index > 0 ? index : remark.indexOf("，");
        index = index > 0 ? index : remark.indexOf(" ");
        return index > 0 ? remark.substring(0, index) : remark;
    }

    protected static String getApiModelPropertyAnnotation(IntrospectedColumn column) {
        return BaseAnnotation.ApiModelProperty.getAnnotation() + "(value = \"" + column.getRemarks() + "\", required = " + !column.isNullable() + ")";
    }

    protected static String getApiModelPropertyAnnotationRequired(IntrospectedColumn column) {
        return BaseAnnotation.ApiModelProperty.getAnnotation() + "(value = \"" + column.getRemarks() + "\", required = true)";
    }

    protected static String getApiModelPropertyAnnotationRes(IntrospectedColumn column) {
        return BaseAnnotation.ApiModelProperty.getAnnotation() + "(value = \"" + column.getRemarks() + ")";
    }

    protected static String getLengthAnnotation(IntrospectedColumn column, String remarks) {
        return BaseAnnotation.Length.getAnnotation() + "(max = " + column.getLength() + ", message = \"" + remarks + "不能超过{max}位字符\")";
    }

    protected static String getNotBlankAnnotation(String remarks) {
        return BaseAnnotation.NotBlank.getAnnotation() + "(message = \"" + remarks + "不能为空\")";
    }

    protected static String getNotNullAnnotation(String remarks) {
        return BaseAnnotation.NotNull.getAnnotation() + "(message = \"" + remarks + "不能为空\")";
    }

    protected static String getRangeAnnotation(String remarks) {
        return BaseAnnotation.Range.getAnnotation() + "(min = " + 0 + ", max = " + 100 + ", message = \"" + remarks + "不正确\")";
    }

    protected static String getDecimalMinAnnotation(String remarks) {
        return BaseAnnotation.DecimalMin.getAnnotation() + "(value = " + 0 + ", message = \"" + remarks + "不能小于{max}\")";
    }

    protected static String getJsonFormatAnnotation() {
        return BaseAnnotation.JsonFormat.getAnnotation() + "(pattern = \"yyyy-MM-dd\", timezone = \"GMT+8\")";
    }


    private static Template getTemplate(String templateName) throws IOException {
        return CONFIGURATION.getTemplate(templateName);
    }

}
