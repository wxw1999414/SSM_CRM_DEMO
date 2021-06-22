package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.CompanyCustomerAccessories;
import com.yc137.mapper.CompanyCustomerAccessoriesMapper;
import com.yc137.service.CompanyCustomerAccessoriesService;
@Service
public class CompanyCustomerAccessoriesServiceImpl implements CompanyCustomerAccessoriesService{

    @Resource
    private CompanyCustomerAccessoriesMapper companyCustomerAccessoriesMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return companyCustomerAccessoriesMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(CompanyCustomerAccessories record) {
        return companyCustomerAccessoriesMapper.insert(record);
    }

    @Override
    public int insertSelective(CompanyCustomerAccessories record) {
        return companyCustomerAccessoriesMapper.insertSelective(record);
    }

    @Override
    public CompanyCustomerAccessories selectByPrimaryKey(Integer rid) {
        return companyCustomerAccessoriesMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyCustomerAccessories record) {
        return companyCustomerAccessoriesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CompanyCustomerAccessories record) {
        return companyCustomerAccessoriesMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteCustomerID(Integer rid) {
        return companyCustomerAccessoriesMapper.deleteByCustomerID(rid);
    }

}
