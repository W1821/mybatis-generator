package com.zq.cms.pojo.dto.stock.goods;

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
@ApiModel(value = "库存管理-商品表 修改 请求")
public class UpdateStockGoodsInfoReq extends SaveStockGoodsInfoReq {

    @ApiModelProperty(value = "主键", example = "1")
    @NotBlank(message = "主键id 不能为空")
    private String id;

}