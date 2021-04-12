package com.xf.project.admin.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkCategory;
import com.xf.project.db.service.ZkCategoryService;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 产品系列Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/category")
public class ZkCategoryController
{
    private String prefix = "admin/category";

    @Autowired
    private ZkCategoryService zkCategoryService;

    /**
     * 查询产品系列列表
     */
    @RequiresPermissions("admin:category:list")
    @RequiresPermissionsDesc(menu = {"官网管理","产品系列管理"}, button = "查询")
    @GetMapping("/list")
    public Object list(ZkCategory zkCategory)
    {
        PageHelper.startPage(zkCategory.getPage(), zkCategory.getLimit());
        List<ZkCategory> list = zkCategoryService.selectZkCategoryList(zkCategory);
        return ResponseUtil.okList(list);
    }

    /**
     * 新增产品系列
     */
    @RequiresPermissions("admin:category:add")
    @RequiresPermissionsDesc(menu = {"官网管理","产品系列管理"}, button = "添加")
    @PostMapping("/add")
    public Object addSave(@RequestBody ZkCategory zkCategory)
    {
        if (zkCategoryService.insertZkCategory(zkCategory) == 0){
            return ResponseUtil.badArgumentValue();
        }
        zkCategory.setValue(Math.toIntExact(zkCategory.getId()));
        zkCategoryService.updateZkCategory(zkCategory);
        return ResponseUtil.ok(zkCategory);
    }


    /**
     * 修改保存产品系列
     */
    @RequiresPermissions("admin:category:edit")
    @RequiresPermissionsDesc(menu = {"官网管理","产品系列管理"}, button = "修改")
    @PostMapping("/edit")
    public Object editSave(@RequestBody ZkCategory zkCategory)
    {
        if (zkCategoryService.updateZkCategory(zkCategory) ==0 ){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkCategory);
    }

    /**
     * 删除产品系列
     */
    @RequiresPermissions("admin:category:remove")
    @RequiresPermissionsDesc(menu = {"官网管理","产品系列管理"}, button = "删除")
    @PostMapping( "/remove")
    public Object remove(@RequestBody Long id)
    {
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        zkCategoryService.deleteZkCategoryById(id);
        return ResponseUtil.ok();
    }
}
