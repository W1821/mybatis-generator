<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageMapper}.${tableName}Mapper">

    <!-- 列表查询 -->
    <select id="queryList" resultType="${queryList.resultType}">
        SELECT
        <#list queryList.columns as column>
            t.${column.column} AS ${column.property}<#if column_has_next>,</#if><#if !column_has_next>${" "}</#if>${column.space}-- <#if column.remark??>${column.remark}</#if>
        </#list>
        FROM
            ${actualTableName} t
        <where>
            <#list queryList.columns as column>
            <if test="null != req.${column.property} and req.${column.property} != ''">
                and t.${column.column} = ${r'#{req.'}${column.property}}${column.space}-- <#if column.remark??>${column.remark}</#if>
            </if>
            </#list>
        </where>
    </select>

    <!-- 详细查询 -->
    <select id="queryById" resultType="${queryById.resultType}">
        SELECT
        <#list queryList.columns as column>
            t.${column.column} AS ${column.property}<#if column_has_next>,</#if><#if !column_has_next>${" "}</#if>${column.space}-- <#if column.remark??>${column.remark}</#if>
        </#list>
        FROM
            ${actualTableName} t
        WHERE
            t.id = ${r'#{id}'}
        AND t.deleted = 0
    </select>


</mapper>