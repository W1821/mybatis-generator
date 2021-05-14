package ${package};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "${moduleTag} 列表查询 响应")
public class Query${tableName}ListRes {

<#list fields as field>
    ${field.apiModelProperty}
    <#if field.jsonFormat?? && field.jsonFormat != ''>
    ${field.jsonFormat}
    </#if>
    private ${field.fieldType} ${field.fieldName};

</#list>
}