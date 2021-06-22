package com.yc137.mapper;

import com.yc137.domain.OrderProcess;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OrderProcessMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(OrderProcess record);

    int insertSelective(OrderProcess record);

    OrderProcess selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(OrderProcess record);

    int updateByPrimaryKey(OrderProcess record);

    List<Map<String, Object>> selectAll(@Param("rid") String rid);

    Map<String, Object> selectById(Integer id);

    int updateOrder(LocalDateTime orderGoodsTime, LocalDateTime customerGetTime, String state, String remarks,Integer rid);

    List<Map<String,Object>> selectByName(String customerName);

    List<Map<String, Object>> selectAll();
}