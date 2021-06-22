package com.yc137.mapper;

import com.yc137.domain.Contract;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    List<Map<String,Object>> selectAll(Contract contract);

    List<Map<String,Object>> selectById(Integer id);

    int updateById(Integer id,String state,String remake);

//    List<Map<String,Object>> selectByState();

}