package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkImageManagement;

import java.util.List;

/**
 * 轮播，荣誉等管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkImageManagementMapper
{
    /**
     * 查询轮播，荣誉等管理
     *
     * @param id 轮播，荣誉等管理ID
     * @return 轮播，荣誉等管理
     */
    public ZkImageManagement selectZkImageManagementById(Long id);

    /**
     * 查询轮播，荣誉等管理列表
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 轮播，荣誉等管理集合
     */
    public List<ZkImageManagement> selectZkImageManagementList(ZkImageManagement zkImageManagement);

    /**
     * 新增轮播，荣誉等管理
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 结果
     */
    public int insertZkImageManagement(ZkImageManagement zkImageManagement);

    /**
     * 修改轮播，荣誉等管理
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 结果
     */
    public int updateZkImageManagement(ZkImageManagement zkImageManagement);

    /**
     * 删除轮播，荣誉等管理
     *
     * @param id 轮播，荣誉等管理ID
     * @return 结果
     */
    public int deleteZkImageManagementById(Long id);

    /**
     * 批量删除轮播，荣誉等管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkImageManagementByIds(String[] ids);
}
