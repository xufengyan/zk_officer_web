package com.xf.project.admin.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkImageManagement;
import com.xf.project.db.service.ZkImageManagementService;
import com.xf.project.framework.util.ResponseUtil;
import com.xf.project.framework.util.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 轮播，荣誉等管理Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/management")
public class ZkImageManagementController
{
    private String prefix = "admin/management";

    @Autowired
    private ZkImageManagementService zkImageManagementService;

    /**
     * 查询轮播，荣誉等管理列表
     */
    @RequiresPermissions("admin:management:list")
    @RequiresPermissionsDesc(menu = {"官网图片管理","图片管理"} , button = "查询")
    @GetMapping(value = "/list")
    public Object list(ZkImageManagement zkImageManagement)
    {
        PageHelper.startPage(zkImageManagement.getPage(), zkImageManagement.getLimit());
        List<ZkImageManagement> list = zkImageManagementService.selectZkImageManagementList(zkImageManagement);
        return ResponseUtil.okList(list);
    }


    /**
     * 新增保存轮播，荣誉等管理
     */
    @RequiresPermissions("admin:management:add")
    @RequiresPermissionsDesc(menu = {"官网图片管理","图片管理"} , button = "添加")
    @PostMapping(value = "/add")
    public Object addSave(@RequestBody ZkImageManagement zkImageManagement)
    {
        zkImageManagementService.insertZkImageManagement(zkImageManagement);
        return ResponseUtil.ok(zkImageManagement);
    }

    /**
     * 修改轮播，荣誉等管理
     */
    @RequiresPermissions("admin:management:read")
    @RequiresPermissionsDesc(menu = {"官网图片管理","图片管理"} , button = "详情")
    @GetMapping(value = "/read/{id}")
    public Object edit(@PathVariable("id") Long id)
    {
        ZkImageManagement zkImageManagement = zkImageManagementService.selectZkImageManagementById(id);
        return ResponseUtil.ok(zkImageManagement);
    }

    /**
     * 修改保存轮播，荣誉等管理
     */
    @RequiresPermissions("admin:management:edit")
    @RequiresPermissionsDesc(menu = {"官网图片管理","图片管理"} , button = "编辑")
    @PostMapping(value = "/edit")
    public Object editSave(@RequestBody ZkImageManagement zkImageManagement)
    {
        if (zkImageManagementService.updateZkImageManagement(zkImageManagement) == 0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkImageManagement);
    }

    /**
     * 删除轮播，荣誉等管理
     * 逻辑删除
     */
    @RequiresPermissions("admin:management:remove")
    @RequiresPermissionsDesc(menu = {"官网图片管理","图片管理"} , button = "删除")
    @GetMapping(value = "/remove/{id}")
    public Object remove(@PathVariable("id") Long id)
    {
        if (id == null) {
        return ResponseUtil.badArgument();
        }
        ZkImageManagement zkImageManagement = new ZkImageManagement();
        zkImageManagement.setId(id);
        zkImageManagement.setDelType(1L);
        zkImageManagementService.updateZkImageManagement(zkImageManagement);
        return ResponseUtil.ok();
    }
}
