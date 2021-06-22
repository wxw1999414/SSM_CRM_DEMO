package com.yc137.service;

import com.yc137.domain.Goods;

import java.util.List;

public interface GoodsService{


    int deleteByPrimaryKey(Integer rid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectAll();

    Goods selectByKey(String key);

}
