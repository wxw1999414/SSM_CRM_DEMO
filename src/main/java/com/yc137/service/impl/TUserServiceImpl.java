package com.yc137.service.impl;

import com.yc137.domain.TUser;
import com.yc137.mapper.TUserMapper;
import com.yc137.service.TUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return 0;
    }

    @Override
    public int insert(TUser record) {
        return 0;
    }

    @Override
    public int insertSelective(TUser record) {
        return 0;
    }

    @Override
    public TUser selectByPrimaryKey(Integer rid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return 0;
    }


    /**
     * 根据账号密码查询用用户及其具有的角色
     */
    @Override
    public TUser selectByUser(TUser record) {
        TUser user = tUserMapper.selectByUser(record);
        return user;
    }

    /**
     * 查询所有的用户
     */
    @Override
    public List<TUser> findAll() {
        List<TUser> list = tUserMapper.findAll();
        return list;
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        return tUserMapper.selectALL();
    }
}

