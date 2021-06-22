package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.ContractDetails;
import com.yc137.mapper.ContractDetailsMapper;
import com.yc137.service.ContractDetailsService;
@Service
public class ContractDetailsServiceImpl implements ContractDetailsService{

    @Resource
    private ContractDetailsMapper contractDetailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return contractDetailsMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(ContractDetails record) {
        return contractDetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(ContractDetails record) {
        return contractDetailsMapper.insertSelective(record);
    }

    @Override
    public ContractDetails selectByPrimaryKey(Integer rid) {
        return contractDetailsMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractDetails record) {
        return contractDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContractDetails record) {
        return contractDetailsMapper.updateByPrimaryKey(record);
    }

}
