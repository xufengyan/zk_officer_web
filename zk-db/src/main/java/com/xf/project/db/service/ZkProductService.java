package com.xf.project.db.service;

import java.util.List;

import com.xf.project.db.dao.ZkProductMapper;
import com.xf.project.db.domain.ZkProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产品Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkProductService
{
    @Autowired
    private ZkProductMapper zkProductMapper;

    /**
     * 查询产品
     *
     * @param id 产品ID
     * @return 产品
     */
    //@Override
    public ZkProduct selectZkProductById(Long id)
    {
        return zkProductMapper.selectZkProductById(id);
    }

    /**
     * 查询产品列表
     *
     * @param zkProduct 产品
     * @return 产品
     */
    //@Override
    public List<ZkProduct> selectZkProductList(ZkProduct zkProduct)
    {
        return zkProductMapper.selectZkProductList(zkProduct);
    }

    /**
     * 新增产品
     *
     * @param zkProduct 产品
     * @return 结果
     */
    //@Override
    public int insertZkProduct(ZkProduct zkProduct)
    {
        return zkProductMapper.insertZkProduct(zkProduct);
    }

    /**
     * 修改产品
     *
     * @param zkProduct 产品
     * @return 结果
     */
    //@Override
    public int updateZkProduct(ZkProduct zkProduct)
    {
        return zkProductMapper.updateZkProduct(zkProduct);
    }

    /**
     * 删除产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkProductByIds(String ids)
    {
//        return zkProductMapper.deleteZkProductByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除产品信息
     *
     * @param id 产品ID
     * @return 结果
     */
    //@Override
    public int deleteZkProductById(Long id)
    {
        return zkProductMapper.deleteZkProductById(id);
    }
}
