package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.CustomerContractAccessories;
import com.yc137.mapper.CustomerContractAccessoriesMapper;
import com.yc137.service.CustomerContractAccessoriesService;
@Service
public class CustomerContractAccessoriesServiceImpl implements CustomerContractAccessoriesService{

    @Resource
    private CustomerContractAccessoriesMapper customerContractAccessoriesMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return customerContractAccessoriesMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(CustomerContractAccessories record) {
        return customerContractAccessoriesMapper.insert(record);
    }

    @Override
    public int insertSelective(CustomerContractAccessories record) {
        return customerContractAccessoriesMapper.insertSelective(record);
    }

    @Override
    public CustomerContractAccessories selectByPrimaryKey(Integer rid) {
        return customerContractAccessoriesMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerContractAccessories record) {
        return customerContractAccessoriesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CustomerContractAccessories record) {
        return customerContractAccessoriesMapper.updateByPrimaryKey(record);
    }

}
