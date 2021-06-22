package com.yc137.service;

import com.yc137.domain.FollowsRecord;

import java.util.List;
import java.util.Map;

public interface FollowsRecordService{


    int deleteByPrimaryKey(Integer rid);

    int insert(FollowsRecord record);

    int insertSelective(FollowsRecord record);

    List<Map<String,Object>> selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(FollowsRecord record);

    int updateByPrimaryKey(FollowsRecord record);

}
