package com.xf.project.admin.controller.html;

import com.github.pagehelper.PageHelper;
import com.xf.project.admin.annotation.RequiresPermissionsDesc;
import com.xf.project.db.domain.*;
import com.xf.project.db.service.*;
import com.xf.project.framework.util.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/**
 * @author xf
 * @version 1.0
 * @date 2021/4/14 14:23
 */
@RestController
@RequestMapping("/html")
public class ZkHtmlController {
    @Autowired
    private ZkBasicService zkBasicService;

    @Autowired
    private ZkCategoryService zkCategoryService;

    @Autowired
    private ZkDownloadService zkDownloadService;

    @Autowired
    private ZkImageManagementService zkImageManagementService;

    @Autowired
    private ZkListService zkListService;

    @Autowired
    private ZkProductService zkProductService;

    @Autowired
    private ZkSchemeService zkSchemeService;


    /**
     * 查询官网信息
     * @param lan 语言类型
     * @return
     */
    @GetMapping("basic/read/{lan}")
    public Object readBasic(@PathVariable("lan") String lan)
    {
        if (lan == null){
            return ResponseUtil.badArgumentValue();
        }
        ZkBasic zkBasic = new ZkBasic();
        zkBasic.setLan(lan);
        ZkBasic basic = zkBasicService.selectZkBasicList(zkBasic).get(0);
        return ResponseUtil.ok(basic);
    }


    /**
     * 查询图片列表
     * @param zkImageManagement
     * @return
     */
    @GetMapping("management/list.html")
    public Object listImageManagement(ZkImageManagement zkImageManagement)
    {
//        PageHelper.startPage(zkImageManagement.getPage(), zkImageManagement.getLimit());
        List<ZkImageManagement> list = zkImageManagementService.selectZkImageManagementList(zkImageManagement);
        return ResponseUtil.ok(list);
    }

    /**
     * 查询商品列表
     * @param zkProduct
     * @return
     */
    @GetMapping("product/list.html")
    public Object listProduct( ZkProduct zkProduct)
    {
        List<ZkProduct> list = zkProductService.selectZkProductList(zkProduct);
        return ResponseUtil.ok(list);
    }

    /**
     * 查询技术领域和优势段落列表
     */
    @GetMapping("paragraph/list.html")
    public Object listParagraph(ZkList zkList)
    {
        List<ZkList> list = zkListService.selectZkListList(zkList);
        return ResponseUtil.ok(list);
    }

    /**
     * 查询产品系列列表
     */
    @GetMapping("category/list.html")
    public Object lisCategoryt(ZkCategory zkCategory)
    {
        List<ZkCategory> list = zkCategoryService.selectZkCategoryList(zkCategory);
        return ResponseUtil.okList(list);
    }


    /**
     * 查询解决方案列表
     */
    @GetMapping("scheme/list.html")
    public Object list(ZkScheme zkScheme)
    {
        List<ZkScheme> list = zkSchemeService.selectZkSchemeList(zkScheme);
        return ResponseUtil.okList(list);
    }

    /**
     * 查询说明文件下载列表
     */

    @GetMapping("download/list.html")
    public Object list(ZkDownload zkDownload)
    {
        List<ZkDownload> list = zkDownloadService.selectZkDownloadList(zkDownload);
        return ResponseUtil.okList(list);
    }
}
