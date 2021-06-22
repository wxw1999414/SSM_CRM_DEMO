package com.yc137.mapper;

import com.yc137.domain.TCommonType;

public interface TCommonTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCommonType record);

    int insertSelective(TCommonType record);

    TCommonType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCommonType record);

    int updateByPrimaryKey(TCommonType record);
}