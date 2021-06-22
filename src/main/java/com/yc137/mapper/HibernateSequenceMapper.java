package com.yc137.mapper;

import com.yc137.domain.HibernateSequence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HibernateSequenceMapper {
    int insert(HibernateSequence record);

    int insertSelective(HibernateSequence record);
}