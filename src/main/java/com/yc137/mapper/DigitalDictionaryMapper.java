package com.yc137.mapper;

import com.yc137.domain.DigitalDictionary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DigitalDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DigitalDictionary record);

    int insertSelective(DigitalDictionary record);

    DigitalDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DigitalDictionary record);

    int updateByPrimaryKey(DigitalDictionary record);
}