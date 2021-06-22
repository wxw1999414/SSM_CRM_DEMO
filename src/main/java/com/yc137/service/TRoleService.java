package com.yc137.service;

import com.yc137.domain.TAuthority;
import com.yc137.domain.TRole;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TRoleService {
    int deleteByPrimaryKey(Long id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    TRole selectByRole(TRole record);

    List<TRole> findAll();

    List<TAuthority> selectRoleAuthById(Long id);
}

