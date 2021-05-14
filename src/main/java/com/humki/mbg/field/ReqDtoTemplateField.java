package com.humki.mbg.field;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReqDtoTemplateField {

    private String apiModelProperty;

    private String length;

    private String decimalMin;

    private String range;

    private String notNull;

    private String notBlank;

    private String fieldType;

    private String fieldName;

}
