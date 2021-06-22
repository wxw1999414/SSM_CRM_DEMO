package com.yc137.service;

import com.yc137.domain.CompanyCustomerAccessories;
public interface CompanyCustomerAccessoriesService{


    int deleteByPrimaryKey(Integer rid);

    int insert(CompanyCustomerAccessories record);

    int insertSelective(CompanyCustomerAccessories record);

    CompanyCustomerAccessories selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(CompanyCustomerAccessories record);

    int updateByPrimaryKey(CompanyCustomerAccessories record);

    int deleteCustomerID(Integer rid);

}
