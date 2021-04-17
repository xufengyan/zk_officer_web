package com.xf.project.db.domain;


/**
 * 产品系列对象 zk_category
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public class ZkCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** key */
    private Integer value;

    /** 类型名称 */
    private String label;

    private Integer type;
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setValue(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }
    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
