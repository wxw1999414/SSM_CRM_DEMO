package com.yc137.service;

import com.yc137.domain.TRoleAuthority;
public interface TRoleAuthorityService{


    int deleteByPrimaryKey(Long id);

    int insert(TRoleAuthority record);

    int insertSelective(TRoleAuthority record);

    TRoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRoleAuthority record);

    int updateByPrimaryKey(TRoleAuthority record);

}
