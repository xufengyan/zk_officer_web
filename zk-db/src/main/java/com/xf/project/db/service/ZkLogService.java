package com.xf.project.db.service;

import com.github.pagehelper.PageHelper;

import com.xf.project.db.dao.ZkLogMapper;
import com.xf.project.db.domain.ZkLog;
import com.xf.project.db.domain.ZkLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZkLogService {
    @Resource
    private ZkLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ZkLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<ZkLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        ZkLogExample example = new ZkLogExample();
        ZkLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
