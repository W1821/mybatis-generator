package com.humki.mbg.plugin;


import com.humki.mbg.annotation.BaseAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
public class MapperXmlPlugin extends BasePlugin {


    public boolean validate(List<String> list) {
        String packageDto = properties.getProperty("dto");
        if (packageDto == null) {
            log.error("配置文件错误！dto不存在！");
            return false;
        }
        return super.validate(list);
    }

    /* ============================================================== mapper.java start ============================================================= */

    /**
     * 修改mapper接口  增加 TkMapper
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String tableName = interfaze.getType().getShortName();

        // 移除默认的方法
        interfaze.getMethods().clear();

        // import
        Set<FullyQualifiedJavaType> set = new HashSet<>();
        set.add(new FullyQualifiedJavaType(BaseAnnotation.TkMapper.getClazz()));
        set.add(new FullyQualifiedJavaType(properties.getProperty("dto") + ".Query" + tableName + "ListRes"));
        set.add(new FullyQualifiedJavaType(properties.getProperty("dto") + ".Query" + tableName + "ListReq"));
        set.add(new FullyQualifiedJavaType(properties.getProperty("dto") + ".Query" + tableName + "Res"));
        interfaze.addImportedTypes(set);


        // 继承 TkMapper
        FullyQualifiedJavaType tkMapper = new FullyQualifiedJavaType("TkMapper<" + tableName + ">");
        interfaze.addSuperInterface(tkMapper);

        // 添加 方法
        addMethod(interfaze, "queryList", "List<Query" + tableName + "ListRes>", "List<Query" + tableName + "ListReq>", "req", "列表查询");
        addMethod(interfaze, "queryById", "Query" + tableName + "Res", "String", "id", "根据id查询详细");

        return true;
    }

    private void addMethod(Interface interfaze, String methodName, String returnType, String paramType, String paramName, String explain) {
        Method method = new Method();
        method.setName(methodName);
        method.setReturnType(new FullyQualifiedJavaType(returnType));

        Parameter parameter = new Parameter(new FullyQualifiedJavaType(paramType), paramName);
        parameter.addAnnotation("@Param(value = \"" + paramName + "\")");
        method.addParameter(parameter);

        // 注释
        methodAnnotation(method, explain);
        interfaze.addMethod(method);
    }

    /**
     * 注释生成
     */
    public static void methodAnnotation(Method method, String explain) {
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(explain);
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
    }

    /* ============================================================== xml start ============================================================= */

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        List<Element> elements = document.getRootElement().getElements();

        Element first = elements.get(0);

        // 清理掉默认生成的代码
        elements.clear();

        // 保留第一个
        elements.add(first);

        return true;
    }


}
