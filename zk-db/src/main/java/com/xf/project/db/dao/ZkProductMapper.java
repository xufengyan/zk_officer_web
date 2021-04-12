package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkProduct;

import java.util.List;

/**
 * 产品Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkProductMapper
{
    /**
     * 查询产品
     *
     * @param id 产品ID
     * @return 产品
     */
    public ZkProduct selectZkProductById(Long id);

    /**
     * 查询产品列表
     *
     * @param zkProduct 产品
     * @return 产品集合
     */
    public List<ZkProduct> selectZkProductList(ZkProduct zkProduct);

    /**
     * 新增产品
     *
     * @param zkProduct 产品
     * @return 结果
     */
    public int insertZkProduct(ZkProduct zkProduct);

    /**
     * 修改产品
     *
     * @param zkProduct 产品
     * @return 结果
     */
    public int updateZkProduct(ZkProduct zkProduct);

    /**
     * 删除产品
     *
     * @param id 产品ID
     * @return 结果
     */
    public int deleteZkProductById(Long id);

    /**
     * 批量删除产品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkProductByIds(String[] ids);
}
