package com.xf.project.db.service;


import com.xf.project.db.dao.ZkImageManagementMapper;
import com.xf.project.db.domain.ZkImageManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 轮播，荣誉等管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkImageManagementService
{
    @Autowired
    private ZkImageManagementMapper zkImageManagementMapper;

    /**
     * 查询轮播，荣誉等管理
     *
     * @param id 轮播，荣誉等管理ID
     * @return 轮播，荣誉等管理
     */
   //@Override
    public ZkImageManagement selectZkImageManagementById(Long id)
    {
        return zkImageManagementMapper.selectZkImageManagementById(id);
    }

    /**
     * 查询轮播，荣誉等管理列表
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 轮播，荣誉等管理
     */
   //@Override
    public List<ZkImageManagement> selectZkImageManagementList(ZkImageManagement zkImageManagement)
    {
        return zkImageManagementMapper.selectZkImageManagementList(zkImageManagement);
    }

    /**
     * 新增轮播，荣誉等管理
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 结果
     */
   //@Override
    public int insertZkImageManagement(ZkImageManagement zkImageManagement)
    {
        return zkImageManagementMapper.insertZkImageManagement(zkImageManagement);
    }

    /**
     * 修改轮播，荣誉等管理
     *
     * @param zkImageManagement 轮播，荣誉等管理
     * @return 结果
     */
   //@Override
    public int updateZkImageManagement(ZkImageManagement zkImageManagement)
    {
        zkImageManagement.setUpdateTime(LocalDateTime.now());
        return zkImageManagementMapper.updateZkImageManagement(zkImageManagement);
    }

    /**
     * 删除轮播，荣誉等管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
   //@Override
    public int deleteZkImageManagementByIds(String ids)
    {
//        return zkImageManagementMapper.deleteZkImageManagementByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除轮播，荣誉等管理信息
     *
     * @param id 轮播，荣誉等管理ID
     * @return 结果
     */
   //@Override
    public int deleteZkImageManagementById(Long id)
    {
        return zkImageManagementMapper.deleteZkImageManagementById(id);
    }
}
