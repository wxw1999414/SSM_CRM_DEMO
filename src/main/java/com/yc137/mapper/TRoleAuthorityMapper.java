package com.yc137.mapper;

import com.yc137.domain.TAuthority;import com.yc137.domain.TRoleAuthority;import java.util.List;

public interface TRoleAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TRoleAuthority record);

    int insertSelective(TRoleAuthority record);

    TRoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRoleAuthority record);

    int updateByPrimaryKey(TRoleAuthority record);

    List<TAuthority> selectRoleAuthById(Long id);
}