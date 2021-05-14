package ${package};

import com.zq.cms.common.bean.PageHead;
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
@ApiModel(value = "${moduleTag} 列表查询 请求")
public class Query${tableName}ListReq extends PageHead {

<#list fields as field>
    ${field.apiModelProperty}
    <#if field.length?? && field.length != ''>
    ${field.length}
    </#if>
    <#if field.notBlank?? && field.notBlank != ''>
    ${field.notBlank}
    </#if>
    <#if field.notNull?? && field.notNull != ''>
    ${field.notNull}
    </#if>
    private ${field.fieldType} ${field.fieldName};

</#list>
}