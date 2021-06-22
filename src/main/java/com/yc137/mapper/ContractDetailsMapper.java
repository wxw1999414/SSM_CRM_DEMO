package com.yc137.mapper;

import com.yc137.domain.ContractDetails;

public interface ContractDetailsMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(ContractDetails record);

    int insertSelective(ContractDetails record);

    ContractDetails selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(ContractDetails record);

    int updateByPrimaryKey(ContractDetails record);
}