package com.yc137.mapper;

import com.yc137.domain.CustomerContractAccessories;

public interface CustomerContractAccessoriesMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(CustomerContractAccessories record);

    int insertSelective(CustomerContractAccessories record);

    CustomerContractAccessories selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(CustomerContractAccessories record);

    int updateByPrimaryKey(CustomerContractAccessories record);
}