package ${package};

import com.zq.cms.common.bean.BaseBean;
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
@ApiModel(value = "${moduleTag} 增加、修改 公共部分")
public class Save${tableName}Req extends BaseBean {
<#list fields as field>
    <#if field.fieldName?? && field.fieldName != 'id'>
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
    </#if>

</#list>
}