package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.TUserRoleMapper;
import com.yc137.domain.TUserRole;
import com.yc137.service.TUserRoleService;
@Service
public class TUserRoleServiceImpl implements TUserRoleService{

    @Resource
    private TUserRoleMapper tUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUserRole record) {
        return tUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TUserRole record) {
        return tUserRoleMapper.insertSelective(record);
    }

    @Override
    public TUserRole selectByPrimaryKey(Long id) {
        return tUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TUserRole record) {
        return tUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TUserRole record) {
        return tUserRoleMapper.updateByPrimaryKey(record);
    }

}
