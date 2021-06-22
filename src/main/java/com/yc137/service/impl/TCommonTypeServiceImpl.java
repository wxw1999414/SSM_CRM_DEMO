package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.TCommonType;
import com.yc137.mapper.TCommonTypeMapper;
import com.yc137.service.TCommonTypeService;
@Service
public class TCommonTypeServiceImpl implements TCommonTypeService{

    @Resource
    private TCommonTypeMapper tCommonTypeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tCommonTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TCommonType record) {
        return tCommonTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(TCommonType record) {
        return tCommonTypeMapper.insertSelective(record);
    }

    @Override
    public TCommonType selectByPrimaryKey(Long id) {
        return tCommonTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TCommonType record) {
        return tCommonTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TCommonType record) {
        return tCommonTypeMapper.updateByPrimaryKey(record);
    }

}
