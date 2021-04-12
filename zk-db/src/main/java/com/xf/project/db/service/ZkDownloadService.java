package com.xf.project.db.service;

import java.time.LocalDateTime;
import java.util.List;
import com.xf.project.db.dao.ZkDownloadMapper;
import com.xf.project.db.domain.ZkDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 说明文件下载Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class ZkDownloadService
{
    @Autowired
    private ZkDownloadMapper zkDownloadMapper;

    /**
     * 查询说明文件下载
     *
     * @param id 说明文件下载ID
     * @return 说明文件下载
     */
    //@Override
    public ZkDownload selectZkDownloadById(Long id)
    {
        return zkDownloadMapper.selectZkDownloadById(id);
    }

    /**
     * 查询说明文件下载列表
     *
     * @param zkDownload 说明文件下载
     * @return 说明文件下载
     */
    //@Override
    public List<ZkDownload> selectZkDownloadList(ZkDownload zkDownload)
    {
        return zkDownloadMapper.selectZkDownloadList(zkDownload);
    }

    /**
     * 新增说明文件下载
     *
     * @param zkDownload 说明文件下载
     * @return 结果
     */
    //@Override
    public int insertZkDownload(ZkDownload zkDownload)
    {
        zkDownload.setAddTime(LocalDateTime.now());
        return zkDownloadMapper.insertZkDownload(zkDownload);
    }

    /**
     * 修改说明文件下载
     *
     * @param zkDownload 说明文件下载
     * @return 结果
     */
    //@Override
    public int updateZkDownload(ZkDownload zkDownload)
    {
        zkDownload.setUpdateTime(LocalDateTime.now());
        return zkDownloadMapper.updateZkDownload(zkDownload);
    }

    /**
     * 删除说明文件下载对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    //@Override
    public int deleteZkDownloadByIds(String ids)
    {
//        return zkDownloadMapper.deleteZkDownloadByIds(Convert.toStrArray(ids));
        return 0;
    }

    /**
     * 删除说明文件下载信息
     *
     * @param id 说明文件下载ID
     * @return 结果
     */
    //@Override
    public int deleteZkDownloadById(Long id)
    {
        return zkDownloadMapper.deleteZkDownloadById(id);
    }
}
