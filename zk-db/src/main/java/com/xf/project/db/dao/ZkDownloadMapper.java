package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkDownload;

import java.util.List;

/**
 * 说明文件下载Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-12
 */
public interface ZkDownloadMapper
{
    /**
     * 查询说明文件下载
     *
     * @param id 说明文件下载ID
     * @return 说明文件下载
     */
    public ZkDownload selectZkDownloadById(Long id);

    /**
     * 查询说明文件下载列表
     *
     * @param zkDownload 说明文件下载
     * @return 说明文件下载集合
     */
    public List<ZkDownload> selectZkDownloadList(ZkDownload zkDownload);

    /**
     * 新增说明文件下载
     *
     * @param zkDownload 说明文件下载
     * @return 结果
     */
    public int insertZkDownload(ZkDownload zkDownload);

    /**
     * 修改说明文件下载
     *
     * @param zkDownload 说明文件下载
     * @return 结果
     */
    public int updateZkDownload(ZkDownload zkDownload);

    /**
     * 删除说明文件下载
     *
     * @param id 说明文件下载ID
     * @return 结果
     */
    public int deleteZkDownloadById(Long id);

    /**
     * 批量删除说明文件下载
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkDownloadByIds(String[] ids);
}
