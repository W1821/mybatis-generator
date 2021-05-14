package com.zq.cms.controller;

import com.zq.cms.common.result.PageResult;
import com.zq.cms.common.result.ServiceResult;
import com.zq.cms.pojo.dto.basic.Id;
import com.zq.cms.service.StockGoodsInfoService;
import com.zq.cms.pojo.dto.stock.goods.*;
import com.zq.cms.spring.config.constant.ApiPathConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = ApiPathConstants.ADMIN_PATH + "/StockGoodsInfo/")
@Api(tags = "库存管理-商品表")
@Slf4j
public class StockGoodsInfoController {

    @Autowired
    public StockGoodsInfoService stockGoodsInfoService;


    @SuppressWarnings("unchecked")
    @ApiOperation(value = "分页查询")
    @PostMapping(value = "queryList")
    public ServiceResult<PageResult<List<QueryStockGoodsInfoListRes>>> queryList(@Valid @RequestBody @ApiParam(value = "分页查询参数") QueryStockGoodsInfoListReq req) {
        return stockGoodsInfoService.queryList(req);
    }

    @SuppressWarnings("unchecked")
    @ApiOperation(value = "根据id查询")
    @PostMapping(value = "queryById")
    public ServiceResult<QueryStockGoodsInfoRes> queryById(@Valid @RequestBody @ApiParam(value = "id信息") Id id) {
        return stockGoodsInfoService.queryById(id);
    }

    @ApiOperation(value = "增加 库存管理-商品表 信息")
    @PostMapping(value = "add")
    public ServiceResult add(@Valid @RequestBody @ApiParam(value = "保存 库存管理-商品表 入参") AddStockGoodsInfoReq req) {
        return stockGoodsInfoService.add(req);
    }

    @ApiOperation(value = "修改 库存管理-商品表 信息")
    @PostMapping(value = "update")
    public ServiceResult update(@Valid @RequestBody @ApiParam(value = "修改 库存管理-商品表 入参") UpdateStockGoodsInfoReq req) {
        return stockGoodsInfoService.update(req);
    }

    @ApiOperation(value = "删除 库存管理-商品表 信息")
    @PostMapping(value = "delete")
    public ServiceResult delete(@Valid @RequestBody @ApiParam(value = "id信息") Id id) {
        return stockGoodsInfoService.delete(id);
    }


}