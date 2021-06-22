package com.yc137.service;

import com.yc137.domain.CompanyCustomer;

import java.util.List;
import java.util.Map;

public interface CompanyCustomerService{


    int deleteByPrimaryKey(Integer rid);

    int insert(CompanyCustomer record);

    int insertSelective(CompanyCustomer record);

    CompanyCustomer selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(CompanyCustomer record);

    int updateByPrimaryKey(CompanyCustomer record);

    List<Map<String,Object>> selectAll();

}
