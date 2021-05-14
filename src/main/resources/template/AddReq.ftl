package ${package};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "${moduleTag} 增加 请求")
public class Add${tableName}Req extends Save${tableName}Req {

}