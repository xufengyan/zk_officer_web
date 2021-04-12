package com.xf.project.db.domain;

/**
 * 产品对象 zk_product
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 产品类型 */
    private Integer pType;

    /** 产品名称 */
    private String pName;

    /** 产品图片地址 */
    private String pImagePath;

    /** 产品型号 */
    private String pModel;

    /** 产品介绍 */
    private String pIntroduce;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setpType(Integer pType)
    {
        this.pType = pType;
    }

    public Integer getpType()
    {
        return pType;
    }
    public void setpName(String pName)
    {
        this.pName = pName;
    }

    public String getpName()
    {
        return pName;
    }
    public void setpImagePath(String pImagePath)
    {
        this.pImagePath = pImagePath;
    }

    public String getpImagePath()
    {
        return pImagePath;
    }
    public void setpModel(String pModel)
    {
        this.pModel = pModel;
    }

    public String getpModel()
    {
        return pModel;
    }
    public void setpIntroduce(String pIntroduce)
    {
        this.pIntroduce = pIntroduce;
    }

    public String getpIntroduce()
    {
        return pIntroduce;
    }

}
