package com.yc137.mapper;

import com.yc137.domain.CompanyCustomerAccessories;

public interface CompanyCustomerAccessoriesMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(CompanyCustomerAccessories record);

    int insertSelective(CompanyCustomerAccessories record);

    CompanyCustomerAccessories selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(CompanyCustomerAccessories record);

    int updateByPrimaryKey(CompanyCustomerAccessories record);

    int deleteByCustomerID(Integer rid);

}