package com.yc137.mapper;

import com.yc137.domain.PotentialCustomer;
import com.yc137.domain.TUser;

import java.util.List;
import java.util.Map;

public interface PotentialCustomerMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(PotentialCustomer record);

    int insertSelective(PotentialCustomer record);

    PotentialCustomer selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(PotentialCustomer record);

    int updateByPrimaryKey(PotentialCustomer record);

    List<Map<String,Object>> selectAll();

    List<Map<String,Object>> selectPeople();

    Map<String,Object> selectInfoById(int id);

    List<Map<String,Object>> selectCondition();

    int updatePerson(Integer followPersonId,Integer rid);

}