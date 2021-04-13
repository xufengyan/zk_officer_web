package com.xf.project.admin.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.ZkDownload;
import com.xf.project.db.service.ZkDownloadService;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 说明文件下载Controller
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/admin/download")
public class ZkDownloadController
{
    private String prefix = "admin/download";

    @Autowired
    private ZkDownloadService zkDownloadService;


    /**
     * 查询说明文件下载列表
     */
    @RequiresPermissions("admin:download:list")
    @RequiresPermissionsDesc(menu = {"官网管理","说明文件下载"} ,button = "查询")
    @GetMapping("/list")
    public Object list(ZkDownload zkDownload)
    {
        PageHelper.startPage(zkDownload.getPage(), zkDownload.getLimit());
        List<ZkDownload> list = zkDownloadService.selectZkDownloadList(zkDownload);
        return ResponseUtil.okList(list);
    }

    /**
     * 新增保存说明文件下载
     */
    @RequiresPermissions("admin:download:add")
    @RequiresPermissionsDesc(menu = {"官网管理","说明文件下载"} ,button = "添加")
    @PostMapping("/add")
    public Object addSave(@RequestBody ZkDownload zkDownload)
    {
        zkDownloadService.insertZkDownload(zkDownload);
        return ResponseUtil.ok(zkDownload);
    }


    /**
     * 修改保存说明文件下载
     */
    @RequiresPermissions("admin:download:edit")
    @RequiresPermissionsDesc(menu = {"官网管理","说明文件下载"} ,button = "编辑")
    @PostMapping("/edit")
    public Object editSave(@RequestBody ZkDownload zkDownload)
    {
        if (zkDownloadService.updateZkDownload(zkDownload) == 0){
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(zkDownload);
    }

    /**
     * 删除说明文件下载
     */
    @RequiresPermissions("admin:download:remove")
    @RequiresPermissionsDesc(menu = {"官网管理","说明文件下载"} ,button = "删除")
    @PostMapping( "/remove")
    public Object remove(@RequestBody Long id)
    {
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        zkDownloadService.deleteZkDownloadById(id);
        return ResponseUtil.ok();
    }
}
