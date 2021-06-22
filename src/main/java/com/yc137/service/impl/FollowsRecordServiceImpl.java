package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.mapper.FollowsRecordMapper;
import com.yc137.domain.FollowsRecord;
import com.yc137.service.FollowsRecordService;

import java.util.List;
import java.util.Map;

@Service
public class FollowsRecordServiceImpl implements FollowsRecordService{

    @Resource
    private FollowsRecordMapper followsRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return followsRecordMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(FollowsRecord record) {
        return followsRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(FollowsRecord record) {
        return followsRecordMapper.insertSelective(record);
    }

    @Override
    public List<Map<String,Object>> selectByPrimaryKey(Integer rid) {
        return followsRecordMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(FollowsRecord record) {
        return followsRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FollowsRecord record) {
        return followsRecordMapper.updateByPrimaryKey(record);
    }

}
