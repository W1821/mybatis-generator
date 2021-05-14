package com.humki.mbg.util;

import com.google.common.base.CaseFormat;

/**
 * 列处理工具类
 */
public class ColumnUtil {

    private static final String COMMON = ",";
    private static final String NEWLINE = "\r\n";
    private static final String FOUR_SPACE = "    ";
    private static final String EIGHT_SPACE = "        ";


    public static void main(String[] args) {
        String columnStr = "         id, organization_name, establish_time, floor_area, telephone, address, logo_url, \n" +
                "    show_url, website_url, organization_describe, create_user, create_time, update_user, update_time,\n" +
                "    deleted   ";
        System.out.println(outSelectSql(columnStr, "xxx"));

        System.out.println();

        System.out.println(outBatchInsertSql(columnStr));
    }


    public static String outSelectSql(String columnStr, String tableName) {
        columnStr = columnStr.replaceAll(" ", "").replaceAll("\\n", "");
        String[] columns = columnStr.split(COMMON);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT").append(NEWLINE);
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            sb.append(FOUR_SPACE).append("t.").append(column).append(" AS ").append(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column));
            if (i < columns.length - 1) {
                sb.append(COMMON);
            }
            sb.append(NEWLINE);
        }
        sb.append("FROM ").append(tableName).append(" t");
        return sb.toString();
    }

    public static String outBatchInsertSql(String columnStr) {
        columnStr = columnStr.replaceAll(" ", "").replaceAll("\\n", "");
        String[] columns = columnStr.split(",");
        StringBuilder sb = new StringBuilder();

        sb.append("<insert id=\"batchInsertList\" useGeneratedKeys=\"true\" parameterType=\"java.util.List\">").append(NEWLINE);
        sb.append(FOUR_SPACE).append("INSERT INTO xxx (").append(NEWLINE);
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            sb.append(EIGHT_SPACE).append(FOUR_SPACE).append(column);
            if (i < columns.length - 1) {
                sb.append(",");
            }
            sb.append(NEWLINE);
        }
        sb.append(FOUR_SPACE).append(")").append(NEWLINE);
        sb.append(FOUR_SPACE).append("VALUES").append(NEWLINE);
        sb.append(FOUR_SPACE).append("<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">").append(NEWLINE);
        sb.append(EIGHT_SPACE).append("(").append(NEWLINE);
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            sb.append(EIGHT_SPACE).append(column);
            sb.append("#{item.").append(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column)).append("}");
            if (i < columns.length - 1) {
                sb.append(",");
            }
            sb.append(NEWLINE);
        }
        sb.append(EIGHT_SPACE).append(")").append(NEWLINE);
        sb.append(FOUR_SPACE).append("</foreach>").append(NEWLINE);
        sb.append("</insert>");
        return sb.toString();
    }


}
