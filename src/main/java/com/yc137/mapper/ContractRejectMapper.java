package com.yc137.mapper;

import com.yc137.domain.ContractReject;

import java.util.List;

public interface ContractRejectMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(ContractReject record);

    int insertSelective(ContractReject record);

    ContractReject selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(ContractReject record);

    int updateByPrimaryKey(ContractReject record);

    ContractReject selectNumber(String id);

    List<ContractReject> selectAll();
}