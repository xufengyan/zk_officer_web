package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkList;

import java.util.List;

/**
 * 技术领域和优势段落Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkListMapper
{
    /**
     * 查询技术领域和优势段落
     *
     * @param id 技术领域和优势段落ID
     * @return 技术领域和优势段落
     */
    public ZkList selectZkListById(Long id);

    /**
     * 查询技术领域和优势段落列表
     *
     * @param zkList 技术领域和优势段落
     * @return 技术领域和优势段落集合
     */
    public List<ZkList> selectZkListList(ZkList zkList);

    /**
     * 新增技术领域和优势段落
     *
     * @param zkList 技术领域和优势段落
     * @return 结果
     */
    public int insertZkList(ZkList zkList);

    /**
     * 修改技术领域和优势段落
     *
     * @param zkList 技术领域和优势段落
     * @return 结果
     */
    public int updateZkList(ZkList zkList);

    /**
     * 删除技术领域和优势段落
     *
     * @param id 技术领域和优势段落ID
     * @return 结果
     */
    public int deleteZkListById(Long id);

    /**
     * 批量删除技术领域和优势段落
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkListByIds(String[] ids);
}
