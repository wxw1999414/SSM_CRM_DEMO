package com.yc137.service;

import com.yc137.domain.TCommonTypeGroup;
public interface TCommonTypeGroupService{


    int deleteByPrimaryKey(Long id);

    int insert(TCommonTypeGroup record);

    int insertSelective(TCommonTypeGroup record);

    TCommonTypeGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCommonTypeGroup record);

    int updateByPrimaryKey(TCommonTypeGroup record);

}
