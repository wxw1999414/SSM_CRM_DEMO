package com.yc137.service;

import com.yc137.domain.PotentialCustomer;
import com.yc137.domain.TUser;

import java.util.List;
import java.util.Map;

/**
 * @author William
 */
public interface PotentialCustomerService{


    int deleteByPrimaryKey(Integer rid);

    int insert(PotentialCustomer record);

    int insertSelective(PotentialCustomer record);

    PotentialCustomer selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(PotentialCustomer record);

    int updateByPrimaryKey(PotentialCustomer record);

    List<Map<String,Object>> selectAll();

    /**
     * 查询跟进人员
     */
   List< Map<String,Object>> selectPeople();

   Map<String, Object> selectById(int id);


  List<Map<String,Object>> pc();
  int updatePerson(Integer followPersonId,Integer rid);


}
