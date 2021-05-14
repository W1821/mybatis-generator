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
@ApiModel(value = "库存管理-商品表 详细查询 响应")
public class QueryStockGoodsInfoRes {

    @ApiModelProperty(value = "主键)
    private String id;

    @ApiModelProperty(value = "分类类型，1：商品，2：礼品)
    private Integer classificationType;

    @ApiModelProperty(value = "商品分类id)
    private String goodsClassificationId;

    @ApiModelProperty(value = "商品状态 0：上架，1：下架)
    private Integer goodsStatus;

    @ApiModelProperty(value = "商品名称)
    private String goodsName;

    @ApiModelProperty(value = "商品编码)
    private String goodsCode;

    @ApiModelProperty(value = "商品编码)
    private String goodsValue;

    @ApiModelProperty(value = "商品产地)
    private String originPlace;

    @ApiModelProperty(value = "保质期（天))
    private Integer shelfLife;

    @ApiModelProperty(value = "计量单位)
    private String goodsUnit;

    @ApiModelProperty(value = "售价（元）)
    private BigDecimal price;

    @ApiModelProperty(value = "商品规格)
    private String goodsStandard;

    @ApiModelProperty(value = "库存上限)
    private Integer maxStock;

    @ApiModelProperty(value = "库存下限)
    private Integer minStock;

    @ApiModelProperty(value = "商品图片)
    private String goodsPictureUrl;

    @ApiModelProperty(value = "仓库id)
    private String storehouseId;

    @ApiModelProperty(value = "总库存数量)
    private BigDecimal stockQuantity;

    @ApiModelProperty(value = "入库量)
    private BigDecimal putInStockQuantity;

    @ApiModelProperty(value = "出库量)
    private BigDecimal putOutStockQuantity;

    @ApiModelProperty(value = "销售量)
    private BigDecimal salesVolume;

    @ApiModelProperty(value = "退货量)
    private BigDecimal returnVolume;

    @ApiModelProperty(value = "库存版本号)
    private Integer version;

    @ApiModelProperty(value = "人气点击量)
    private Integer hits;

    @ApiModelProperty(value = "商品说明)
    private String description;

}