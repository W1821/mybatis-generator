package com.zq.cms.service;

import com.zq.cms.common.enums.LogEnum;
import com.github.pagehelper.PageInfo;
import com.zq.cms.cache.LoginUserTokenCache;
import com.zq.cms.mapper.StockGoodsInfoMapper;
import com.zq.cms.pojo.dto.stock.goods.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zq.cms.pojo.dto.basic.Id;

@Service
@Slf4j
public class StockGoodsInfoService {

    @Autowired
    private LoginUserTokenCache loginUserTokenCache;

    @Autowired
    private StockGoodsInfoMapper stockGoodsInfoMapper;

    /**
     * 列表
     */
    public ServiceResult queryList(QueryStockGoodsInfoListReq req) {
        // 分页排序处理
        PageHelperUtil.orderByAndStartPage(req, "");

        List<QueryStockGoodsInfoListRes> list = stockGoodsInfoMapper.queryList(req);
        list.forEach(this::setEnumValue);
        PageInfo<QueryStockGoodsInfoListRes> pageInfo = new PageInfo<>(list);
        return ServiceResult.ok(new PageResult<>(list, pageInfo.getTotal()));
    }

    private void setEnumValue(QueryStockGoodsInfoListRes res) {
    }

    /**
     * 根据主键查询
     */
    public ServiceResult queryById(Id id) {
        QueryStockGoodsInfoRes stockGoodsInfoRes = stockGoodsInfoMapper.queryById(id.getId());
        if (stockGoodsInfoRes == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }
        return ServiceResult.ok(stockGoodsInfoRes);
    }

    /**
     * 增加
     */
    public ServiceResult add(AddStockGoodsInfoReq req) {
        StockGoodsInfo stockGoodsInfo = buildstockGoodsInfo(req);
        stockGoodsInfo.setId(UUIDUtils.getUUID32());
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        storehouseInfo.setCreateUser(user.getUserId());
        storehouseInfo.setCreateTime(new Date());

        log(LogEnum.OperationType.ADD, "新增：" + stockGoodsInfo.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    /**
     * 修改
     */
    @KeyLock(lockKeyParts = "id")
    public ServiceResult update(UpdateStockGoodsInfoReq req) {
        StockGoodsInfo stockGoodsInfo = stockGoodsInfoMapper.selectByPrimaryKey(req.getId());
        if (storehouseInfo == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        StockGoodsInfo updateStockGoodsInfo = buildstockGoodsInfo(req);
        updateStockGoodsInfo.setId(stockGoodsInfo.getId());
        stockGoodsInfoMapper.updateByPrimaryKeySelective(updateStockGoodsInfo);

        log(LogEnum.OperationType.UPDATE, "修改：" + stockGoodsInfo.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    /**
     * 修改
     */
    @KeyLock(lockKeyParts = "id")
    public ServiceResult delete(UpdateStockGoodsInfoReq req) {
        StockGoodsInfo stockGoodsInfo = stockGoodsInfoMapper.selectByPrimaryKey(req.getId());
        if (storehouseInfo == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        StockGoodsInfo updateStockGoodsInfo = buildstockGoodsInfo(req);
        updateStockGoodsInfo.setId(stockGoodsInfo.getId());
        stockGoodsInfoMapper.updateByPrimaryKeySelective(updateStockGoodsInfo);

        log(LogEnum.OperationType.UPDATE, "修改：" + stockGoodsInfo.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    private stockGoodsInfo buildstockGoodsInfo(SaveStockGoodsInfoReq req) {
        // 当前用户
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        Date now = new Date();
        return stockGoodsInfo.builder()
				.id(req.getid())
				.classificationType(req.getclassificationType())
				.goodsClassificationId(req.getgoodsClassificationId())
				.goodsStatus(req.getgoodsStatus())
				.goodsName(req.getgoodsName())
				.goodsCode(req.getgoodsCode())
				.originPlace(req.getoriginPlace())
				.shelfLife(req.getshelfLife())
				.goodsUnit(req.getgoodsUnit())
				.price(req.getprice())
				.goodsStandard(req.getgoodsStandard())
				.maxStock(req.getmaxStock())
				.minStock(req.getminStock())
				.goodsPictureUrl(req.getgoodsPictureUrl())
				.storehouseId(req.getstorehouseId())
				.stockQuantity(req.getstockQuantity())
				.putInStockQuantity(req.getputInStockQuantity())
				.putOutStockQuantity(req.getputOutStockQuantity())
				.salesVolume(req.getsalesVolume())
				.returnVolume(req.getreturnVolume())
				.version(req.getversion())
				.createUser(req.getcreateUser())
				.createTime(req.getcreateTime())
				.hits(req.gethits())
				.description(req.getdescription())

                .updateUser(user.getUserId())
                .updateTime(now)
                .deleted(SystemEnum.YES_NO.NO.getKey())
                .build();
    }

    /**
    * 删除
    */
    public ServiceResult delete(Id id) {
        StockGoodsInfo stockGoodsInfo = stockGoodsInfoMapper.selectByPrimaryKey(id.getId());
        if (stockGoodsInfo == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        // 物理删除
        stockGoodsInfoMapper.delete(stockGoodsInfo);

        // 逻辑删除
        StockGoodsInfo deleteStockGoodsInfo = new StockGoodsInfo();
        deleteStockGoodsInfo.setDeleted(SystemEnum.YES_NO.NO.getKey());
        elderlyContractFileMapper.delete(elderlyContractFile);

        log(LogEnum.OperationType.DELETE, "删除：" + stockGoodsInfo.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }


    private void log(LogEnum.OperationType operationType, String operationLog) {
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        saveUserOperationLog(user, operationType, LogEnum.OperationModule.CKGL, operationLog);
    }
}
