package com.zq.cms.entity;

import com.zq.cms.common.bean.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ApiModel("库存管理-商品表")
@Column(name = "stock_goods_info")
public class StockGoodsInfo extends BaseBean {
    @ApiModelProperty(value = "主键", required = true)
    @Column(name = "id")
    private String id;

    @ApiModelProperty(value = "分类类型，1：商品，2：礼品", required = false)
    @Column(name = "classification_type")
    private Integer classificationType;

    @ApiModelProperty(value = "商品分类id", required = false)
    @Column(name = "goods_classification_id")
    private String goodsClassificationId;

    @ApiModelProperty(value = "商品状态 0：上架，1：下架", required = false)
    @Column(name = "goods_status")
    private Integer goodsStatus;

    @ApiModelProperty(value = "商品名称", required = false)
    @Column(name = "goods_name")
    private String goodsName;

    @ApiModelProperty(value = "商品编码", required = false)
    @Column(name = "goods_code")
    private String goodsCode;

    @ApiModelProperty(value = "商品产地", required = false)
    @Column(name = "origin_place")
    private String originPlace;

    @ApiModelProperty(value = "保质期（天)", required = false)
    @Column(name = "shelf_life")
    private Integer shelfLife;

    @ApiModelProperty(value = "计量单位", required = false)
    @Column(name = "goods_unit")
    private String goodsUnit;

    @ApiModelProperty(value = "售价（元）", required = false)
    @Column(name = "price")
    private BigDecimal price;

    @ApiModelProperty(value = "商品规格", required = false)
    @Column(name = "goods_standard")
    private String goodsStandard;

    @ApiModelProperty(value = "库存上限", required = false)
    @Column(name = "max_stock")
    private Integer maxStock;

    @ApiModelProperty(value = "库存下限", required = false)
    @Column(name = "min_stock")
    private Integer minStock;

    @ApiModelProperty(value = "商品图片", required = false)
    @Column(name = "goods_picture_url")
    private String goodsPictureUrl;

    @ApiModelProperty(value = "仓库id", required = false)
    @Column(name = "storehouse_id")
    private String storehouseId;

    @ApiModelProperty(value = "总库存数量", required = false)
    @Column(name = "stock_quantity")
    private BigDecimal stockQuantity;

    @ApiModelProperty(value = "入库量", required = false)
    @Column(name = "put_in_stock_quantity")
    private BigDecimal putInStockQuantity;

    @ApiModelProperty(value = "出库量", required = false)
    @Column(name = "put_out_stock_quantity")
    private BigDecimal putOutStockQuantity;

    @ApiModelProperty(value = "销售量", required = false)
    @Column(name = "sales_volume")
    private BigDecimal salesVolume;

    @ApiModelProperty(value = "退货量", required = false)
    @Column(name = "return_volume")
    private BigDecimal returnVolume;

    @ApiModelProperty(value = "库存版本号", required = false)
    @Column(name = "version")
    private Integer version;

    @ApiModelProperty(value = "创建用户", required = false)
    @Column(name = "create_user")
    private String createUser;

    @ApiModelProperty(value = "创建时间", required = false)
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改用户", required = false)
    @Column(name = "update_user")
    private String updateUser;

    @ApiModelProperty(value = "更新时间", required = false)
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除，0：否，1：是", required = false)
    @Column(name = "deleted")
    private Integer deleted;

    @ApiModelProperty(value = "人气点击量", required = false)
    @Column(name = "hits")
    private Integer hits;

    @ApiModelProperty(value = "商品说明", required = false)
    @Column(name = "description")
    private String description;
}