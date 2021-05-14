package com.zq.cms.pojo.dto.stock.goods;

import com.zq.cms.common.bean.PageHead;
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
@ApiModel(value = "库存管理-商品表 列表查询 请求")
public class QueryStockGoodsInfoListReq extends PageHead {

    @ApiModelProperty(value = "主键", required = true)
    @Length(max = 32, message = "主键不能超过{max}位字符")
    @NotBlank(message = "主键不能为空")
    private String id;

    @ApiModelProperty(value = "分类类型，1：商品，2：礼品", required = false)
    @NotNull(message = "分类类型不能为空")
    private Integer classificationType;

    @ApiModelProperty(value = "商品分类id", required = false)
    @Length(max = 32, message = "商品分类id不能超过{max}位字符")
    @NotBlank(message = "商品分类id不能为空")
    private String goodsClassificationId;

    @ApiModelProperty(value = "商品状态 0：上架，1：下架", required = false)
    @NotNull(message = "商品状态 0：上架不能为空")
    private Integer goodsStatus;

    @ApiModelProperty(value = "商品名称", required = false)
    @Length(max = 255, message = "商品名称不能超过{max}位字符")
    @NotBlank(message = "商品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "商品编码", required = false)
    @Length(max = 255, message = "商品编码不能超过{max}位字符")
    @NotBlank(message = "商品编码不能为空")
    private String goodsCode;

    @ApiModelProperty(value = "商品产地", required = false)
    @Length(max = 255, message = "商品产地不能超过{max}位字符")
    @NotBlank(message = "商品产地不能为空")
    private String originPlace;

    @ApiModelProperty(value = "保质期（天)", required = false)
    @NotNull(message = "保质期（天)不能为空")
    private Integer shelfLife;

    @ApiModelProperty(value = "计量单位", required = false)
    @Length(max = 255, message = "计量单位不能超过{max}位字符")
    @NotBlank(message = "计量单位不能为空")
    private String goodsUnit;

    @ApiModelProperty(value = "售价（元）", required = false)
    @NotNull(message = "售价（元）不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "商品规格", required = false)
    @Length(max = 255, message = "商品规格不能超过{max}位字符")
    @NotBlank(message = "商品规格不能为空")
    private String goodsStandard;

    @ApiModelProperty(value = "库存上限", required = false)
    @NotNull(message = "库存上限不能为空")
    private Integer maxStock;

    @ApiModelProperty(value = "库存下限", required = false)
    @NotNull(message = "库存下限不能为空")
    private Integer minStock;

    @ApiModelProperty(value = "商品图片", required = false)
    @Length(max = 500, message = "商品图片不能超过{max}位字符")
    @NotBlank(message = "商品图片不能为空")
    private String goodsPictureUrl;

    @ApiModelProperty(value = "仓库id", required = false)
    @Length(max = 32, message = "仓库id不能超过{max}位字符")
    @NotBlank(message = "仓库id不能为空")
    private String storehouseId;

    @ApiModelProperty(value = "总库存数量", required = false)
    @NotNull(message = "总库存数量不能为空")
    private BigDecimal stockQuantity;

    @ApiModelProperty(value = "入库量", required = false)
    @NotNull(message = "入库量不能为空")
    private BigDecimal putInStockQuantity;

    @ApiModelProperty(value = "出库量", required = false)
    @NotNull(message = "出库量不能为空")
    private BigDecimal putOutStockQuantity;

    @ApiModelProperty(value = "销售量", required = false)
    @NotNull(message = "销售量不能为空")
    private BigDecimal salesVolume;

    @ApiModelProperty(value = "退货量", required = false)
    @NotNull(message = "退货量不能为空")
    private BigDecimal returnVolume;

    @ApiModelProperty(value = "库存版本号", required = false)
    @NotNull(message = "库存版本号不能为空")
    private Integer version;

    @ApiModelProperty(value = "人气点击量", required = false)
    @NotNull(message = "人气点击量不能为空")
    private Integer hits;

    @ApiModelProperty(value = "商品说明", required = false)
    @Length(max = 65535, message = "商品说明不能超过{max}位字符")
    @NotBlank(message = "商品说明不能为空")
    private String description;

}