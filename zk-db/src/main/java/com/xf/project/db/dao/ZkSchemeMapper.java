package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkScheme;

import java.util.List;

/**
 * 解决方案Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkSchemeMapper
{
    /**
     * 查询解决方案
     *
     * @param id 解决方案ID
     * @return 解决方案
     */
    public ZkScheme selectZkSchemeById(Long id);

    /**
     * 查询解决方案列表
     *
     * @param zkScheme 解决方案
     * @return 解决方案集合
     */
    public List<ZkScheme> selectZkSchemeList(ZkScheme zkScheme);

    /**
     * 新增解决方案
     *
     * @param zkScheme 解决方案
     * @return 结果
     */
    public int insertZkScheme(ZkScheme zkScheme);

    /**
     * 修改解决方案
     *
     * @param zkScheme 解决方案
     * @return 结果
     */
    public int updateZkScheme(ZkScheme zkScheme);

    /**
     * 删除解决方案
     *
     * @param id 解决方案ID
     * @return 结果
     */
    public int deleteZkSchemeById(Long id);

    /**
     * 批量删除解决方案
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkSchemeByIds(String[] ids);
}
