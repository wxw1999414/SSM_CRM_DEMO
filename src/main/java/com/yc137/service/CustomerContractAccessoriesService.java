package com.yc137.service;

import com.yc137.domain.CustomerContractAccessories;
public interface CustomerContractAccessoriesService{


    int deleteByPrimaryKey(Integer rid);

    int insert(CustomerContractAccessories record);

    int insertSelective(CustomerContractAccessories record);

    CustomerContractAccessories selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(CustomerContractAccessories record);

    int updateByPrimaryKey(CustomerContractAccessories record);

}
