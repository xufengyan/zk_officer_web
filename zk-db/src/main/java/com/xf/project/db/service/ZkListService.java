package com.xf.project.db.service;


import com.xf.project.db.dao.ZkListMapper;
import com.xf.project.db.domain.ZkList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 技术领域和优势段落Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkListService
{
    @Autowired
    private ZkListMapper zkListMapper;

    /**
     * 查询技术领域和优势段落
     *
     * @param id 技术领域和优势段落ID
     * @return 技术领域和优势段落
     */
    //@Override
    public ZkList selectZkListById(Long id)
    {
        return zkListMapper.selectZkListById(id);
    }

    /**
     * 查询技术领域和优势段落列表
     *
     * @param zkList 技术领域和优势段落
     * @return 技术领域和优势段落
     */
    //@Override
    public List<ZkList> selectZkListList(ZkList zkList)
    {
        return zkListMapper.selectZkListList(zkList);
    }

    /**
     * 新增技术领域和优势段落
     *
     * @param zkList 技术领域和优势段落
     * @return 结果
     */
    //@Override
    public int insertZkList(ZkList zkList)
    {
        return zkListMapper.insertZkList(zkList);
    }

    /**
     * 修改技术领域和优势段落
     *
     * @param zkList 技术领域和优势段落
     * @return 结果
     */
    //@Override
    public int updateZkList(ZkList zkList)
    {
        zkList.setUpdateTime(LocalDateTime.now());
        return zkListMapper.updateZkList(zkList);
    }

    /**
     * 删除技术领域和优势段落对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkListByIds(String ids)
    {
//        return zkListMapper.deleteZkListByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除技术领域和优势段落信息
     *
     * @param id 技术领域和优势段落ID
     * @return 结果
     */
    //@Override
    public int deleteZkListById(Long id)
    {
        return zkListMapper.deleteZkListById(id);
    }
}
