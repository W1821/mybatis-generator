package com.humki.mbg.annotation;

public enum BaseAnnotation {

    // lombok
    AllArgsConstructor("@AllArgsConstructor", "lombok.AllArgsConstructor"),
    NoArgsConstructor("@NoArgsConstructor", "lombok.NoArgsConstructor"),
    Getter("@Getter", "lombok.Getter"),
    Setter("@Setter", "lombok.Setter"),
    Builder("@Builder", "lombok.Builder"),

    // mapper中的参数
    Param("@Param", "org.apache.ibatis.annotations.Param"),

    // 字段
    Table("@Column", "javax.persistence.Table"),
    Id("@Id", "javax.persistence.Id"),
    Column("@Column", "javax.persistence.Column"),

    // swagger
    ApiModel("@ApiModel", "io.swagger.annotations.ApiModel"),
    ApiModelProperty("@ApiModelProperty", "io.swagger.annotations.ApiModelProperty"),

    // 验证
    NotNull("@NotNull", "javax.validation.constraints.NotNull"),
    NotBlank("@NotBlank", "javax.validation.constraints.NotBlank"),
    DecimalMin("@DecimalMin", "javax.validation.constraints.DecimalMin"),
    Range("@Range", "org.hibernate.validator.constraints.Range"),
    Length("@Length", "org.hibernate.validator.constraints.Length"),

    // TkMapper
    TkMapper("@TkMapper", "com.zq.tkmapper.TkMapper"),

    // 时间格式化
    JsonFormat("@JsonFormat", "com.fasterxml.jackson.annotation.JsonFormat");

    private String annotation;

    private String clazz;

    BaseAnnotation(String annotation, String clazz) {
        this.annotation = annotation;
        this.clazz = clazz;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getClazz() {
        return clazz;
    }
}