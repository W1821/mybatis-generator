package ${package};

import com.zq.cms.common.result.PageResult;
import com.zq.cms.common.result.ServiceResult;
import com.zq.cms.pojo.dto.basic.Id;
import ${packageService}.${tableName}Service;
import ${packageDto}.*;
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
@RequestMapping(value = ApiPathConstants.ADMIN_PATH + "/${tableName}/")
@Api(tags = "${moduleTag}")
@Slf4j
public class ${tableName}Controller {

    @Autowired
    public ${tableName}Service ${tableName?uncap_first}Service;


    @SuppressWarnings("unchecked")
    @ApiOperation(value = "分页查询")
    @PostMapping(value = "queryList")
    public ServiceResult<PageResult<List<Query${tableName}ListRes>>> queryList(@Valid @RequestBody @ApiParam(value = "分页查询参数") Query${tableName}ListReq req) {
        return ${tableName?uncap_first}Service.queryList(req);
    }

    @SuppressWarnings("unchecked")
    @ApiOperation(value = "根据id查询")
    @PostMapping(value = "queryById")
    public ServiceResult<Query${tableName}Res> queryById(@Valid @RequestBody @ApiParam(value = "id信息") Id id) {
        return ${tableName?uncap_first}Service.queryById(id);
    }

    @ApiOperation(value = "增加 ${moduleTag} 信息")
    @PostMapping(value = "add")
    public ServiceResult add(@Valid @RequestBody @ApiParam(value = "保存 ${moduleTag} 入参") Add${tableName}Req req) {
        return ${tableName?uncap_first}Service.add(req);
    }

    @ApiOperation(value = "修改 ${moduleTag} 信息")
    @PostMapping(value = "update")
    public ServiceResult update(@Valid @RequestBody @ApiParam(value = "修改 ${moduleTag} 入参") Update${tableName}Req req) {
        return ${tableName?uncap_first}Service.update(req);
    }

    @ApiOperation(value = "删除 ${moduleTag} 信息")
    @PostMapping(value = "delete")
    public ServiceResult delete(@Valid @RequestBody @ApiParam(value = "id信息") Id id) {
        return ${tableName?uncap_first}Service.delete(id);
    }


}