package com.yc137.service.impl;

import com.yc137.domain.TAuthority;
import com.yc137.domain.TRole;
import com.yc137.mapper.TRoleMapper;
import com.yc137.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRoleServiceImpl implements TRoleService {
    @Autowired
    private TRoleMapper tRoleDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tRoleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TRole record) {
        int num=tRoleDao.insert(record);
        return num;
    }

    @Override
    public int insertSelective(TRole record) {
        return 0;
    }

    @Override
    public TRole selectByPrimaryKey(Long id) {
        return tRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TRole record) {
        return tRoleDao.updateByPrimaryKey(record);
    }

    @Override
    public TRole selectByRole(TRole record) {
        TRole tRole = tRoleDao.selectByRole(record);
        return tRole;
    }

    @Override
    public List<TRole> findAll() {
        List<TRole> list = tRoleDao.findAll();
        return list;
    }

    @Override
    public List<TAuthority> selectRoleAuthById(Long id) {
        return tRoleDao.selectRoleAuthById(id);
    }
}

