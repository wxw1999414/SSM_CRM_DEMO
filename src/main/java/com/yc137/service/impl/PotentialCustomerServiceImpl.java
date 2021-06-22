package com.yc137.service.impl;

import com.yc137.domain.TUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.PotentialCustomerMapper;
import com.yc137.domain.PotentialCustomer;
import com.yc137.service.PotentialCustomerService;

import java.util.List;
import java.util.Map;

@Service
public class PotentialCustomerServiceImpl implements PotentialCustomerService{

    @Resource
    private PotentialCustomerMapper potentialCustomerMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return potentialCustomerMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(PotentialCustomer record) {
        return potentialCustomerMapper.insert(record);
    }

    @Override
    public int insertSelective(PotentialCustomer record) {
        return potentialCustomerMapper.insertSelective(record);
    }

    @Override
    public PotentialCustomer selectByPrimaryKey(Integer rid) {
        return potentialCustomerMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(PotentialCustomer record) {
        return potentialCustomerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PotentialCustomer record) {
        return potentialCustomerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> selectAll() {
        return potentialCustomerMapper.selectAll();
    }

    @Override
    public List<Map<String,Object>> selectPeople() {
        return potentialCustomerMapper.selectPeople();
    }

    @Override
    public Map<String, Object> selectById(int id) {
        return potentialCustomerMapper.selectInfoById(id);
    }

    @Override
    public List<Map<String,Object>> pc() {
        return potentialCustomerMapper.selectCondition();
    }

    @Override
    public int updatePerson(Integer followPersonId, Integer rid) {
        return potentialCustomerMapper.updatePerson(followPersonId,rid);
    }


}
