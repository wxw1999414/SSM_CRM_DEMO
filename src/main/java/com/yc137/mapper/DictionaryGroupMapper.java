package com.yc137.mapper;

import com.yc137.domain.DictionaryGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictionaryGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryGroup record);

    int insertSelective(DictionaryGroup record);

    DictionaryGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryGroup record);

    int updateByPrimaryKey(DictionaryGroup record);
}