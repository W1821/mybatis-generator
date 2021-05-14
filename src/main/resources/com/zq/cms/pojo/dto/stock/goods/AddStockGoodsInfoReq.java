package com.zq.cms.pojo.dto.stock.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "库存管理-商品表 增加 请求")
public class AddStockGoodsInfoReq extends SaveStockGoodsInfoReq {

}