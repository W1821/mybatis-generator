package com.zq.cms.mapper;

import com.zq.cms.entity.StockGoodsInfo;
import com.zq.cms.entity.StockGoodsInfoExample;
import com.zq.cms.pojo.dto.stock.goods.QueryStockGoodsInfoMapperListReq;
import com.zq.cms.pojo.dto.stock.goods.QueryStockGoodsInfoMapperListRes;
import com.zq.cms.pojo.dto.stock.goods.QueryStockGoodsInfoMapperRes;
import com.zq.tkmapper.TkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockGoodsInfoMapper extends TkMapper<StockGoodsInfoMapper> {
    /**
     * 列表查询
     */
    List<QueryStockGoodsInfoMapperListRes> queryList(@Param(value = "req") List<QueryStockGoodsInfoMapperListReq> req);

    /**
     * 根据id查询详细
     */
    QueryStockGoodsInfoMapperRes queryById(@Param(value = "id") String id);
}