package com.yc137.mapper;

import com.yc137.domain.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    List<Goods> goods();

    Goods selectByKey(String goodsName);
}