package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkCategory;

import java.util.List;

/**
 * 产品系列Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkCategoryMapper
{
    /**
     * 查询产品系列
     *
     * @param id 产品系列ID
     * @return 产品系列
     */
    public ZkCategory selectZkCategoryById(Long id);

    /**
     * 查询产品系列列表
     *
     * @param zkCategory 产品系列
     * @return 产品系列集合
     */
    public List<ZkCategory> selectZkCategoryList(ZkCategory zkCategory);

    /**
     * 新增产品系列
     *
     * @param zkCategory 产品系列
     * @return 结果
     */
    public int insertZkCategory(ZkCategory zkCategory);

    /**
     * 修改产品系列
     *
     * @param zkCategory 产品系列
     * @return 结果
     */
    public int updateZkCategory(ZkCategory zkCategory);

    /**
     * 删除产品系列
     *
     * @param id 产品系列ID
     * @return 结果
     */
    public int deleteZkCategoryById(Long id);

    /**
     * 批量删除产品系列
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkCategoryByIds(String[] ids);
}
