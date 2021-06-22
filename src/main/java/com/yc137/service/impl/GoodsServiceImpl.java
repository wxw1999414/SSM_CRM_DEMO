package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.Goods;
import com.yc137.mapper.GoodsMapper;
import com.yc137.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return goodsMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer rid) {
        return goodsMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.goods();
    }

    @Override
    public Goods selectByKey(String key) {
        return goodsMapper.selectByKey(key);
    }

}
