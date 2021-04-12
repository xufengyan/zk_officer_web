package com.xf.project.db.domain;



/**
 * 解决方案对象 zk_scheme
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 解决方案 */
    private Long id;

    /** 方案名称 */
    private String sName;

    /** 方案宣传图 */
    private String sImagePath;

    /** 方案内容 */
    private String sContent;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setsName(String sName)
    {
        this.sName = sName;
    }

    public String getsName()
    {
        return sName;
    }
    public void setsImagePath(String sImagePath)
    {
        this.sImagePath = sImagePath;
    }

    public String getsImagePath()
    {
        return sImagePath;
    }
    public void setsContent(String sContent)
    {
        this.sContent = sContent;
    }

    public String getsContent()
    {
        return sContent;
    }

}
