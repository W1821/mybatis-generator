package com.humki.mbg.field;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResDtoTemplateField {

    private String apiModelProperty;

    private String jsonFormat;

    private String fieldType;

    private String fieldName;

}
