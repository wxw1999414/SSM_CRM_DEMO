package com.yc137.mapper;

import com.yc137.domain.TUserRole;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}