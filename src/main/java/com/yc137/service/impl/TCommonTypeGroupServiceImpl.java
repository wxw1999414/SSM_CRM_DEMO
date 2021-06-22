package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.TCommonTypeGroup;
import com.yc137.mapper.TCommonTypeGroupMapper;
import com.yc137.service.TCommonTypeGroupService;
@Service
public class TCommonTypeGroupServiceImpl implements TCommonTypeGroupService{

    @Resource
    private TCommonTypeGroupMapper tCommonTypeGroupMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tCommonTypeGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TCommonTypeGroup record) {
        return tCommonTypeGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(TCommonTypeGroup record) {
        return tCommonTypeGroupMapper.insertSelective(record);
    }

    @Override
    public TCommonTypeGroup selectByPrimaryKey(Long id) {
        return tCommonTypeGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TCommonTypeGroup record) {
        return tCommonTypeGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TCommonTypeGroup record) {
        return tCommonTypeGroupMapper.updateByPrimaryKey(record);
    }

}
