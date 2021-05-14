package com.humki.mbg.field;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class XmlTemplateElement {

    private String resultType;

    private List<XmlColumn> columns;

}
