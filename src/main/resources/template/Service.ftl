package ${package};

import com.zq.cms.common.enums.LogEnum;
import com.github.pagehelper.PageInfo;
import com.zq.cms.cache.LoginUserTokenCache;
import ${packageMapper}.${tableName}Mapper;
import ${packageDto}.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zq.cms.pojo.dto.basic.Id;

@Service
@Slf4j
public class ${tableName}Service {

    @Autowired
    private LoginUserTokenCache loginUserTokenCache;

    @Autowired
    private ${tableName}Mapper ${tableName?uncap_first}Mapper;

    /**
     * 列表
     */
    public ServiceResult queryList(Query${tableName}ListReq req) {
        // 分页排序处理
        PageHelperUtil.orderByAndStartPage(req, "");

        List<Query${tableName}ListRes> list = ${tableName?uncap_first}Mapper.queryList(req);
        list.forEach(this::setEnumValue);
        PageInfo<Query${tableName}ListRes> pageInfo = new PageInfo<>(list);
        return ServiceResult.ok(new PageResult<>(list, pageInfo.getTotal()));
    }

    private void setEnumValue(Query${tableName}ListRes res) {
    }

    /**
     * 根据主键查询
     */
    public ServiceResult queryById(Id id) {
        Query${tableName}Res ${tableName?uncap_first}Res = ${tableName?uncap_first}Mapper.queryById(id.getId());
        if (${tableName?uncap_first}Res == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }
        return ServiceResult.ok(${tableName?uncap_first}Res);
    }

    /**
     * 增加
     */
    public ServiceResult add(Add${tableName}Req req) {
        ${tableName} ${tableName?uncap_first} = build${tableName?uncap_first}(req);
        ${tableName?uncap_first}.setId(UUIDUtils.getUUID32());
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        storehouseInfo.setCreateUser(user.getUserId());
        storehouseInfo.setCreateTime(new Date());

        log(LogEnum.OperationType.ADD, "新增：" + ${tableName?uncap_first}.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    /**
     * 修改
     */
    @KeyLock(lockKeyParts = "id")
    public ServiceResult update(Update${tableName}Req req) {
        ${tableName} ${tableName?uncap_first} = ${tableName?uncap_first}Mapper.selectByPrimaryKey(req.getId());
        if (storehouseInfo == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        ${tableName} update${tableName} = build${tableName?uncap_first}(req);
        update${tableName}.setId(${tableName?uncap_first}.getId());
        ${tableName?uncap_first}Mapper.updateByPrimaryKeySelective(update${tableName});

        log(LogEnum.OperationType.UPDATE, "修改：" + ${tableName?uncap_first}.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    /**
     * 修改
     */
    @KeyLock(lockKeyParts = "id")
    public ServiceResult delete(Update${tableName}Req req) {
        ${tableName} ${tableName?uncap_first} = ${tableName?uncap_first}Mapper.selectByPrimaryKey(req.getId());
        if (storehouseInfo == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        ${tableName} update${tableName} = build${tableName?uncap_first}(req);
        update${tableName}.setId(${tableName?uncap_first}.getId());
        ${tableName?uncap_first}Mapper.updateByPrimaryKeySelective(update${tableName});

        log(LogEnum.OperationType.UPDATE, "修改：" + ${tableName?uncap_first}.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }

    private ${tableName?uncap_first} build${tableName?uncap_first}(Save${tableName}Req req) {
        // 当前用户
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        Date now = new Date();
        return ${tableName?uncap_first}.builder()${build}
                .updateUser(user.getUserId())
                .updateTime(now)
                .deleted(SystemEnum.YES_NO.NO.getKey())
                .build();
    }

    /**
    * 删除
    */
    public ServiceResult delete(Id id) {
        ${tableName} ${tableName?uncap_first} = ${tableName?uncap_first}Mapper.selectByPrimaryKey(id.getId());
        if (${tableName?uncap_first} == null) {
            return ServiceResult.fail(ErrorCodes.PARAM_ERROR);
        }

        // 物理删除
        ${tableName?uncap_first}Mapper.delete(${tableName?uncap_first});

        // 逻辑删除
        ${tableName} delete${tableName} = new ${tableName}();
        delete${tableName}.setDeleted(SystemEnum.YES_NO.NO.getKey());
        elderlyContractFileMapper.delete(elderlyContractFile);

        log(LogEnum.OperationType.DELETE, "删除：" + ${tableName?uncap_first}.getId());
        return ServiceResult.ok(ErrorCodes.SUCCESS);
    }


    private void log(LogEnum.OperationType operationType, String operationLog) {
        UserTokenInfoVo user = loginUserTokenCache.getCurrentLoginUserInfoDTO();
        saveUserOperationLog(user, operationType, LogEnum.OperationModule.CKGL, operationLog);
    }
}
