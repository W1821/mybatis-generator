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
@ApiModel(value = "${moduleTag} 详细查询 响应")
public class Query${tableName}Res {

<#list fields as field>
    ${field.apiModelProperty}
    <#if field.jsonFormat?? && field.jsonFormat != ''>
    ${field.jsonFormat}
    </#if>
    private ${field.fieldType} ${field.fieldName};

</#list>
}