package com.t4cloud.t.mock.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t4cloud.t.base.annotation.AutoLog;
import com.t4cloud.t.base.controller.T4Controller;
import com.t4cloud.t.base.entity.dto.R;
import com.t4cloud.t.base.query.T4Query;
import com.t4cloud.t.mock.entity.SysMock;
import com.t4cloud.t.mock.service.ISysMockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Mock数据 控制器
 *
 * <p>
 * --------------------
 *
 * @author T4Cloud
 * @since 2020-02-14
 */
@RestController
@AllArgsConstructor
@Slf4j
@Api(value = "Mock数据" , tags = "Mock管理接口" , position = 2)
@RequestMapping("/SysMock")
public class SysMockController extends T4Controller<SysMock, ISysMockService> {

    /**
     * 详情
     */
    @AutoLog(value = "Mock数据-详情" , operateType = 4)
    @GetMapping("/detail")
    @RequiresPermissions("mock:SysMock:VIEW")
    @ApiOperation(position = 1, value = "Mock数据-详情" , notes = "传入sysMock")
    public R<SysMock> detail(SysMock sysMock, HttpServletRequest req) {
        QueryWrapper<SysMock> sysMockQueryWrapper = T4Query.initQuery(sysMock, req.getParameterMap());
        SysMock detail = service.getOne(sysMockQueryWrapper);
        return R.ok("Mock数据-详情查询成功" , detail);
    }

    /**
     * 全部列表 Mock数据
     */
    @AutoLog(value = "Mock数据-全部列表" , operateType = 4)
    @GetMapping("/list")
    @RequiresPermissions("mock:SysMock:VIEW")
    @ApiOperation(position = 2, value = "Mock数据-全部列表" , notes = "传入sysMock")
    public R<List<SysMock>> list(SysMock sysMock, HttpServletRequest req) {
        QueryWrapper<SysMock> sysMockQueryWrapper = T4Query.initQuery(sysMock, req.getParameterMap());
        List<SysMock> list = service.list(sysMockQueryWrapper);
        return R.ok("Mock数据-全部列表查询成功" , list);
    }

    /**
     * 分页查询 Mock数据
     */
    @AutoLog(value = "Mock数据-分页查询" , operateType = 4)
    @GetMapping("/page")
    @RequiresPermissions("mock:SysMock:VIEW")
    @ApiOperation(position = 3, value = "Mock数据-分页查询" , notes = "传入sysMock")
    public R<IPage<SysMock>> page(SysMock sysMock,
                                  @ApiParam(name = "pageNo" , required = false)
                                  @RequestParam(name = "pageNo" , required = false, defaultValue = "1") Integer pageNo,
                                  @ApiParam(name = "pageSize" , required = false)
                                  @RequestParam(name = "pageSize" , required = false, defaultValue = "10") Integer pageSize,
                                  HttpServletRequest req) {
        QueryWrapper<SysMock> sysMockQueryWrapper = T4Query.initQuery(sysMock, req.getParameterMap());
        IPage<SysMock> pages = service.page(new Page<>(pageNo, pageSize), sysMockQueryWrapper);
        return R.ok("Mock数据-分页查询查询成功" , pages);
    }

    /**
     * 新增 Mock数据
     */
    @AutoLog(value = "Mock数据-新增" , operateType = 1)
    @PutMapping("/save")
    @RequiresPermissions("mock:SysMock:ADD")
    @ApiOperation(position = 4, value = "Mock数据-新增" , notes = "传入sysMock")
    public R save(@Valid @RequestBody SysMock sysMock) {
        return R.ok("Mock数据-新增成功" , service.save(sysMock));
    }

    /**
     * 修改 Mock数据
     */
    @AutoLog(value = "Mock数据-修改" , operateType = 3)
    @PostMapping("/update")
    @RequiresPermissions(value = {"mock:SysMock:ADD" , "mock:SysMock:EDIT"}, logical = Logical.OR)
    @ApiOperation(position = 5, value = "Mock数据-修改" , notes = "传入sysMock")
    public R update(@Valid @RequestBody SysMock sysMock) {
        return R.ok("Mock数据-修改成功" , service.updateById(sysMock));
    }


    /**
     * 删除 Mock数据
     */
    @AutoLog(value = "Mock数据-删除" , operateType = 2)
    @DeleteMapping("/delete")
    @RequiresRoles("ADMIN")
    @RequiresPermissions("mock:SysMock:DELETE")
    @ApiOperation(position = 8, value = "Mock数据-删除" , notes = "传入ids")
    public R delete(@ApiParam(value = "主键集合" , required = true) @RequestParam String ids) {
        return R.ok("Mock数据-删除成功" , service.removeByIds(Arrays.asList(ids.split(","))));
    }


}
