package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.ContractMapper;
import com.yc137.domain.Contract;
import com.yc137.service.ContractService;

import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService{

    @Resource
    private ContractMapper contractMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return contractMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(Contract record) {
        return contractMapper.insert(record);
    }

    @Override
    public int insertSelective(Contract record) {
        return contractMapper.insertSelective(record);
    }

    @Override
    public Contract selectByPrimaryKey(Integer rid) {
        return contractMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return contractMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        return contractMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>>selectAll(Contract contract) {
        return contractMapper.selectAll(contract);
    }

    @Override
    public List<Map<String, Object>> checkcontractById(Integer id) {
        return contractMapper.selectById(id);
    }

    @Override
    public int updateById(Integer id, String state, String remake) {
        return contractMapper.updateById(id,state,remake);
    }


}
