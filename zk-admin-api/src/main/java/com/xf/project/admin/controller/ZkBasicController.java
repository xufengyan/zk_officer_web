package com.xf.project.admin.controller;

import java.util.List;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkBasic;
import com.xf.project.db.domain.ZkList;
import com.xf.project.db.service.ZkBasicService;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 官网基本信息Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/basic")
public class ZkBasicController
{
    private String prefix = "admin/basic";

    @Autowired
    private ZkBasicService zkBasicService;

    /**
     * 查询官网基本信息列表
     */
    @RequiresPermissions("admin:basic:list")
    @RequiresPermissionsDesc(menu = {"官网管理", "网站基本信息"}, button = "查询")
    @GetMapping("/list")
    public Object list(ZkBasic zkBasic)
    {
        PageHelper.startPage(zkBasic.getPage(), zkBasic.getLimit());
        List<ZkBasic> list = zkBasicService.selectZkBasicList(zkBasic);
        return ResponseUtil.okList(list);
    }

    /**
     * 修改官网基本信息
     */
    @RequiresPermissions("admin:list:read")
    @RequiresPermissionsDesc(menu = {"官网管理","网站基本信息"},button = "详情")
    @GetMapping("/read/{id}")
    public Object edit(@PathVariable("id") Long id)
    {
        if (id == null){
            return ResponseUtil.badArgumentValue();
        }
        ZkBasic zkBasic = zkBasicService.selectZkBasicById(id);
        return ResponseUtil.ok(zkBasic);
    }
    /**
     * 修改保存官网基本信息
     */
    @RequiresPermissions("admin:basic:edit")
    @RequiresPermissionsDesc(menu = {"官网管理", "网站基本信息"}, button = "修改")
    @PostMapping("/edit")
    public Object editSave(@RequestBody ZkBasic zkBasic)
    {
        if (zkBasicService.updateZkBasic(zkBasic) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok();
    }

}
