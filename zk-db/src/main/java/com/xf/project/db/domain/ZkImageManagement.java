package com.xf.project.db.domain;

import java.util.Date;

/**
 * 轮播，荣誉等管理对象 zk_image_management
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkImageManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 图片地址 */
    private String imageUrl;

    /** 图片类型（0：轮播图片，1：合作伙伴，2：招聘网站，3：荣誉资质） */
    private Long imageType;

    /** 访问地址 */
    private String visitUrl;

    /** 删除状态0正常,1删除 */
    private Long delType;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    public void setImageType(Long imageType)
    {
        this.imageType = imageType;
    }

    public Long getImageType()
    {
        return imageType;
    }
    public void setVisitUrl(String visitUrl)
    {
        this.visitUrl = visitUrl;
    }

    public String getVisitUrl()
    {
        return visitUrl;
    }
    public void setDelType(Long delType)
    {
        this.delType = delType;
    }

    public Long getDelType()
    {
        return delType;
    }

}
