package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkBasic;

import java.util.List;

/**
 * 官网基本信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkBasicMapper
{
    /**
     * 查询官网基本信息
     *
     * @param id 官网基本信息ID
     * @return 官网基本信息
     */
    public ZkBasic selectZkBasicById(Long id);

    /**
     * 查询官网基本信息列表
     *
     * @param zkBasic 官网基本信息
     * @return 官网基本信息集合
     */
    public List<ZkBasic> selectZkBasicList(ZkBasic zkBasic);

    /**
     * 新增官网基本信息
     *
     * @param zkBasic 官网基本信息
     * @return 结果
     */
    public int insertZkBasic(ZkBasic zkBasic);

    /**
     * 修改官网基本信息
     *
     * @param zkBasic 官网基本信息
     * @return 结果
     */
    public int updateZkBasic(ZkBasic zkBasic);

    /**
     * 删除官网基本信息
     *
     * @param id 官网基本信息ID
     * @return 结果
     */
    public int deleteZkBasicById(Long id);

    /**
     * 批量删除官网基本信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkBasicByIds(String[] ids);
}
