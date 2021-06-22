package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.OrderProcess;
import com.yc137.mapper.OrderProcessMapper;
import com.yc137.service.OrderProcessService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderProcessServiceImpl implements OrderProcessService{

    @Resource
    private OrderProcessMapper orderProcessMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return orderProcessMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(OrderProcess record) {
        return orderProcessMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderProcess record) {
        return orderProcessMapper.insertSelective(record);
    }

    @Override
    public OrderProcess selectByPrimaryKey(Integer rid) {
        return orderProcessMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderProcess record) {
        return orderProcessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderProcess record) {
        return orderProcessMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> selectAll() {
        return orderProcessMapper.selectAll();
    }

    @Override
    public Map<String, Object> selectById(Integer id) {
        return orderProcessMapper.selectById(id);
    }

    @Override
    public int updateOrder(LocalDateTime orderGoodsTime, LocalDateTime customerGetTime, String state, String remarks,Integer rid) {
        return orderProcessMapper.updateOrder(orderGoodsTime,customerGetTime,state, remarks,rid);
    }

    @Override
    public List<Map<String, Object>> selectByName(String customerName) {

        return orderProcessMapper.selectByName(customerName);
    }

}
