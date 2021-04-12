package com.xf.project.db.domain;


/**
 * 说明文件下载对象 zk_download
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkDownload extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 展示大图 */
    private String dMaxImageUrl;

    /** 文件名 */
    private String dName;

    /** 文件描述 */
    private String dDescibe;

    /** 展示图片地址 */
    private String dImagePath;

    /** 下载地址 */
    private String dPath;

    /** 语言类型（zh_CN中文说明书，en英文说明书） */
    private String dLanType;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setdMaxImageUrl(String dMaxImageUrl)
    {
        this.dMaxImageUrl = dMaxImageUrl;
    }

    public String getdMaxImageUrl()
    {
        return dMaxImageUrl;
    }
    public void setdName(String dName)
    {
        this.dName = dName;
    }

    public String getdName()
    {
        return dName;
    }
    public void setdDescibe(String dDescibe)
    {
        this.dDescibe = dDescibe;
    }

    public String getdDescibe()
    {
        return dDescibe;
    }
    public void setdImagePath(String dImagePath)
    {
        this.dImagePath = dImagePath;
    }

    public String getdImagePath()
    {
        return dImagePath;
    }
    public void setdPath(String dPath)
    {
        this.dPath = dPath;
    }

    public String getdPath()
    {
        return dPath;
    }
    public void setdLanType(String dLanType)
    {
        this.dLanType = dLanType;
    }

    public String getdLanType()
    {
        return dLanType;
    }

}
