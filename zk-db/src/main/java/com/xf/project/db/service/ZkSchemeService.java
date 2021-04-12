package com.xf.project.db.service;

import java.util.List;

import com.xf.project.db.dao.ZkSchemeMapper;
import com.xf.project.db.domain.ZkScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 解决方案Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkSchemeService
{
    @Autowired
    private ZkSchemeMapper zkSchemeMapper;

    /**
     * 查询解决方案
     *
     * @param id 解决方案ID
     * @return 解决方案
     */
    //@Override
    public ZkScheme selectZkSchemeById(Long id)
    {
        return zkSchemeMapper.selectZkSchemeById(id);
    }

    /**
     * 查询解决方案列表
     *
     * @param zkScheme 解决方案
     * @return 解决方案
     */
    //@Override
    public List<ZkScheme> selectZkSchemeList(ZkScheme zkScheme)
    {
        return zkSchemeMapper.selectZkSchemeList(zkScheme);
    }

    /**
     * 新增解决方案
     *
     * @param zkScheme 解决方案
     * @return 结果
     */
    //@Override
    public int insertZkScheme(ZkScheme zkScheme)
    {
        return zkSchemeMapper.insertZkScheme(zkScheme);
    }

    /**
     * 修改解决方案
     *
     * @param zkScheme 解决方案
     * @return 结果
     */
    //@Override
    public int updateZkScheme(ZkScheme zkScheme)
    {
        return zkSchemeMapper.updateZkScheme(zkScheme);
    }

    /**
     * 删除解决方案对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkSchemeByIds(String ids)
    {
//        return zkSchemeMapper.deleteZkSchemeByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除解决方案信息
     *
     * @param id 解决方案ID
     * @return 结果
     */
    //@Override
    public int deleteZkSchemeById(Long id)
    {
        return zkSchemeMapper.deleteZkSchemeById(id);
    }
}
