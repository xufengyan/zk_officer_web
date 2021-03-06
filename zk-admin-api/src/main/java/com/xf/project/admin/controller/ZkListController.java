package com.xf.project.admin.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkList;
import com.xf.project.db.service.ZkListService;
import com.xf.project.framework.util.ResponseUtil;
import com.xf.project.framework.util.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 技术领域和优势段落Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/paragraph")
public class ZkListController
{
    private String prefix = "admin/paragraph";

    @Autowired
    private ZkListService zkListService;

    /**
     * 查询技术领域和优势段落列表
     */
    @RequiresPermissions("admin:list:list")
    @RequiresPermissionsDesc(menu = {"官网管理","技术和领域管理"},button = "查询")
    @GetMapping(value = "/list")
    public Object list(ZkList zkList)
    {
        PageHelper.startPage(zkList.getPage(), zkList.getLimit());
        List<ZkList> list = zkListService.selectZkListList(zkList);
        return ResponseUtil.okList(list);
    }

    /**
     * 新增保存技术领域和优势段落
     */
    @RequiresPermissions("admin:list:add")
    @RequiresPermissionsDesc(menu = {"官网管理","技术和领域管理"},button = "添加")
    @PostMapping(value = "/add")
    public Object addSave(@RequestBody ZkList zkList)
    {
        zkListService.insertZkList(zkList);
        return ResponseUtil.ok(zkList);
    }

    /**
     * 修改技术领域和优势段落
     */
    @RequiresPermissions("admin:list:read")
    @RequiresPermissionsDesc(menu = {"官网管理","技术和领域管理"},button = "详情")
    @GetMapping(value = "/read/{id}")
    public Object edit(@PathVariable("id") Long id)
    {
        if (id == null){
            return ResponseUtil.badArgumentValue();
        }
        ZkList zkList = zkListService.selectZkListById(id);
        return ResponseUtil.ok(zkList);
    }

    /**
     * 修改保存技术领域和优势段落
     */
    @RequiresPermissions("admin:list:edit")
    @RequiresPermissionsDesc(menu = {"官网管理","技术和领域管理"},button = "编辑")
    @PostMapping(value = "/edit")
    public Object editSave(@RequestBody ZkList zkList)
    {
        if (zkListService.updateZkList(zkList) == 0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkList);
    }

    /**
     * 删除技术领域和优势段落
     */
    @RequiresPermissions("admin:list:remove")
    @RequiresPermissionsDesc(menu = {"官网管理","技术和领域管理"},button = "删除")
    @PostMapping(value = "/remove")
    public Object remove(@RequestBody Long id)
    {
        if(id == null){
            return ResponseUtil.badArgumentValue();
        }
        zkListService.deleteZkListById(id);
        return ResponseUtil.ok();
    }
}
