package com.xf.project.db.service;

import java.util.List;

import com.xf.project.db.dao.ZkCategoryMapper;
import com.xf.project.db.domain.ZkCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 产品系列Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkCategoryService
{
    @Autowired
    private ZkCategoryMapper zkCategoryMapper;

    /**
     * 查询产品系列
     *
     * @param id 产品系列ID
     * @return 产品系列
     */
    //@Override
    public ZkCategory selectZkCategoryById(Long id)
    {
        return zkCategoryMapper.selectZkCategoryById(id);
    }

    /**
     * 查询产品系列列表
     *
     * @param zkCategory 产品系列
     * @return 产品系列
     */
    //@Override
    public List<ZkCategory> selectZkCategoryList(ZkCategory zkCategory)
    {
        return zkCategoryMapper.selectZkCategoryList(zkCategory);
    }

    /**
     * 新增产品系列
     *
     * @param zkCategory 产品系列
     * @return 结果
     */
    //@Override
    public int insertZkCategory(ZkCategory zkCategory)
    {

        return zkCategoryMapper.insertZkCategory(zkCategory);
    }

    /**
     * 修改产品系列
     *
     * @param zkCategory 产品系列
     * @return 结果
     */
    //@Override
    public int updateZkCategory(ZkCategory zkCategory)
    {
        return zkCategoryMapper.updateZkCategory(zkCategory);
    }

    /**
     * 删除产品系列对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkCategoryByIds(String ids)
    {
//        return zkCategoryMapper.deleteZkCategoryByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除产品系列信息
     *
     * @param id 产品系列ID
     * @return 结果
     */
    //@Override
    public int deleteZkCategoryById(Long id)
    {
        return zkCategoryMapper.deleteZkCategoryById(id);
    }
}
