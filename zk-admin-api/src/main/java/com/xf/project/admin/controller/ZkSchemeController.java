package com.xf.project.admin.controller;

import java.util.List;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkScheme;
import com.xf.project.db.service.ZkSchemeService;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 解决方案Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/scheme")
public class ZkSchemeController
{
    private String prefix = "admin/scheme";

    @Autowired
    private ZkSchemeService zkSchemeService;

    /**
     * 查询解决方案列表
     */
    @RequiresPermissions("admin:scheme:list")
    @RequiresPermissionsDesc(menu = {"官网管理","解决方案"} ,button = "查询")
    @GetMapping("/list")
    public Object list( ZkScheme zkScheme)
    {
        PageHelper.startPage(zkScheme.getPage(), zkScheme.getLimit());
        List<ZkScheme> list = zkSchemeService.selectZkSchemeList(zkScheme);
        return ResponseUtil.okList(list);
    }

    /**
     * 新增保存解决方案
     */
    @RequiresPermissions("admin:scheme:add")
    @RequiresPermissionsDesc(menu = {"官网管理","解决方案"} ,button = "添加")
    @PostMapping("/add")
    public Object addSave(@RequestBody ZkScheme zkScheme)
    {
        zkSchemeService.insertZkScheme(zkScheme);
        return ResponseUtil.ok(zkScheme);
    }

    /**
     * 修改解决方案
     */
    @RequiresPermissions("admin:scheme:read")
    @RequiresPermissionsDesc(menu = {"官网管理","解决方案"} ,button = "详情")
    @GetMapping("/read/{id}")
    public Object read(@PathVariable("id") Long id)
    {
        if (id==null){
            return ResponseUtil.badArgumentValue();
        }
        ZkScheme zkScheme = zkSchemeService.selectZkSchemeById(id);
        return ResponseUtil.ok(zkScheme);
    }

    /**
     * 修改保存解决方案
     */
    @RequiresPermissions("admin:scheme:edit")
    @RequiresPermissionsDesc(menu = {"官网管理","解决方案"} ,button = "编辑")
    @PostMapping("/edit")
    public Object editSave(@RequestBody ZkScheme zkScheme)
    {
        if(zkSchemeService.updateZkScheme(zkScheme) == 0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkScheme);
    }

    /**
     * 删除解决方案
     */
    @RequiresPermissions("admin:scheme:remove")
    @RequiresPermissionsDesc(menu = {"官网管理","解决方案"} ,button = "删除")
    @PostMapping( "/remove")
    public Object remove(@RequestBody Long id)
    {
        if(id == null){
            return ResponseUtil.badArgumentValue();
        }
        zkSchemeService.deleteZkSchemeById(id);
        return ResponseUtil.ok();
    }
}
