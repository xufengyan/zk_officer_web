package com.xf.project.admin.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkProduct;
import com.xf.project.db.service.ZkProductService;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 产品Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/product")
public class ZkProductController
{
    private String prefix = "admin/product";

    @Autowired
    private ZkProductService zkProductService;

    /**
     * 查询产品列表
     */
    @RequiresPermissions("admin:product:list")
    @RequiresPermissionsDesc(menu = {"网站管理","展示产品"},button = "查询")
    @GetMapping("/list")
    public Object list( ZkProduct zkProduct,String type)
    {
        PageHelper.startPage(zkProduct.getPage(), zkProduct.getLimit());
//        List<ZkProduct> list = zkProductService.selectZkProductList(zkProduct);
        List<ZkProduct> list = zkProductService.selectZkProductListByType(zkProduct,type);
        return ResponseUtil.okList(list);
    }


    /**
     * 新增保存产品
     */
    @RequiresPermissions("admin:product:add")
    @RequiresPermissionsDesc(menu = {"网站管理","展示产品"},button = "添加")
    @PostMapping("/add")
    public Object addSave(@RequestBody ZkProduct zkProduct)
    {
        zkProductService.insertZkProduct(zkProduct);
        return ResponseUtil.ok(zkProduct);
    }

    /**
     * 修改产品
     */
    @RequiresPermissions("admin:product:read")
    @RequiresPermissionsDesc(menu = {"网站管理","展示产品"},button = "详情")
    @GetMapping("/read/{id}")
    public Object read(@PathVariable("id") Long id)
    {   if (id==null){
        return ResponseUtil.badArgumentValue();
    }
        ZkProduct zkProduct = zkProductService.selectZkProductById(id);
        return ResponseUtil.ok(zkProduct);
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("admin:product:edit")
    @RequiresPermissionsDesc(menu = {"网站管理","展示产品"},button = "修改")
    @PostMapping("/edit")
    public Object editSave(@RequestBody ZkProduct zkProduct)
    {
        if(zkProductService.updateZkProduct(zkProduct) == 0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkProduct);
    }

    /**
     * 删除产品
     */
    @RequiresPermissions("admin:product:remove")
    @RequiresPermissionsDesc(menu = {"网站管理","展示产品"},button = "删除")
    @PostMapping("/remove")
    public Object remove(@RequestBody Long id)
    {
        if (id == null){
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok();
    }
}
