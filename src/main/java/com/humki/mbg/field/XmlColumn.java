package com.humki.mbg.field;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class XmlColumn {

    private String column;

    private String property;

    private String remark;

    private String space;

}
