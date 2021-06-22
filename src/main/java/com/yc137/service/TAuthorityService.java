package com.yc137.service;

import com.yc137.domain.TAuthority;

import java.util.List;
import java.util.Map;

public interface TAuthorityService {
    int deleteByPrimaryKey(Long id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    List<TAuthority> selectByParentId(Long parentId);

    List<Map<String,Object>> selectAuthorities(Long parentId);

    List<TAuthority> selectById(Long id);

    List<TAuthority> selectConditonById(Long id);


}
