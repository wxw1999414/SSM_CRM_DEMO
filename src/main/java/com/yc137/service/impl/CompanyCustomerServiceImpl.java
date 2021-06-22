package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.CompanyCustomerMapper;
import com.yc137.domain.CompanyCustomer;
import com.yc137.service.CompanyCustomerService;

import java.util.List;
import java.util.Map;

@Service
public class CompanyCustomerServiceImpl implements CompanyCustomerService{

    @Resource
    private CompanyCustomerMapper companyCustomerMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return companyCustomerMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(CompanyCustomer record) {
        return companyCustomerMapper.insert(record);
    }

    @Override
    public int insertSelective(CompanyCustomer record) {
        return companyCustomerMapper.insertSelective(record);
    }

    @Override
    public CompanyCustomer selectByPrimaryKey(Integer rid) {
        return companyCustomerMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyCustomer record) {
        return companyCustomerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CompanyCustomer record) {
        return companyCustomerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> selectAll() {
        return companyCustomerMapper.selectAll();
    }


}
