package com.xf.project.db.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.xf.project.db.dao.ZkBasicMapper;
import com.xf.project.db.domain.ZkBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 官网基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkBasicService
{
    @Autowired
    private ZkBasicMapper zkBasicMapper;

    /**
     * 查询官网基本信息
     *
     * @param id 官网基本信息ID
     * @return 官网基本信息
     */
    //@Override
    public ZkBasic selectZkBasicById(Long id)
    {
        return zkBasicMapper.selectZkBasicById(id);
    }

    /**
     * 查询官网基本信息列表
     *
     * @param zkBasic 官网基本信息
     * @return 官网基本信息
     */
    //@Override
    public List<ZkBasic> selectZkBasicList(ZkBasic zkBasic)
    {
        return zkBasicMapper.selectZkBasicList(zkBasic);
    }

    /**
     * 新增官网基本信息
     *
     * @param zkBasic 官网基本信息
     * @return 结果
     */
    //@Override
    public int insertZkBasic(ZkBasic zkBasic)
    {
        zkBasic.setAddTime(LocalDateTime.now());
        return zkBasicMapper.insertZkBasic(zkBasic);
    }

    /**
     * 修改官网基本信息
     *
     * @param zkBasic 官网基本信息
     * @return 结果
     */
    //@Override
    public int updateZkBasic(ZkBasic zkBasic)
    {
        zkBasic.setUpdateTime(LocalDateTime.now());
        return zkBasicMapper.updateZkBasic(zkBasic);
    }

    /**
     * 删除官网基本信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkBasicByIds(String ids)
    {
//        return zkBasicMapper.deleteZkBasicById(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除官网基本信息信息
     *
     * @param id 官网基本信息ID
     * @return 结果
     */
    //@Override
    public int deleteZkBasicById(Long id)
    {
        return zkBasicMapper.deleteZkBasicById(id);
    }
}
