package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.TRoleAuthorityMapper;
import com.yc137.domain.TRoleAuthority;
import com.yc137.service.TRoleAuthorityService;
@Service
public class TRoleAuthorityServiceImpl implements TRoleAuthorityService{

    @Resource
    private TRoleAuthorityMapper tRoleAuthorityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tRoleAuthorityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TRoleAuthority record) {
        return tRoleAuthorityMapper.insert(record);
    }

    @Override
    public int insertSelective(TRoleAuthority record) {
        return tRoleAuthorityMapper.insertSelective(record);
    }

    @Override
    public TRoleAuthority selectByPrimaryKey(Long id) {
        return tRoleAuthorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRoleAuthority record) {
        return tRoleAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRoleAuthority record) {
        return tRoleAuthorityMapper.updateByPrimaryKey(record);
    }

}
