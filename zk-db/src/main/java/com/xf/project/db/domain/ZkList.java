package com.xf.project.db.domain;

import java.util.Date;

/**
 * 技术领域和优势段落对象 zk_list
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    private String name;

    /** 内容 */
    private String content;

    /** 0:技术领域，1：我们的优势 */
    private Long cType;


    /** 0正常，1删除 */
    private Integer delType;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setcType(Long cType)
    {
        this.cType = cType;
    }

    public Long getcType()
    {
        return cType;
    }

    public void setDelType(Integer delType)
    {
        this.delType = delType;
    }

    public Integer getDelType()
    {
        return delType;
    }

}
