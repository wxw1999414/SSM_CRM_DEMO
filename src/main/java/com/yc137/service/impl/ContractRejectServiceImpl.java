package com.yc137.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yc137.domain.ContractReject;
import com.yc137.mapper.ContractRejectMapper;
import com.yc137.service.ContractRejectService;

import java.util.List;

@Service
public class ContractRejectServiceImpl implements ContractRejectService{

    @Resource
    private ContractRejectMapper contractRejectMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return contractRejectMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(ContractReject record) {
        return contractRejectMapper.insert(record);
    }

    @Override
    public int insertSelective(ContractReject record) {
        return contractRejectMapper.insertSelective(record);
    }

    @Override
    public ContractReject selectByPrimaryKey(Integer rid) {
        return contractRejectMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractReject record) {
        return contractRejectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContractReject record) {
        return contractRejectMapper.updateByPrimaryKey(record);
    }

    @Override
    public ContractReject selectNumber(String id) {
        return contractRejectMapper.selectNumber(id);
    }

    @Override
    public List<ContractReject> selectAll() {
        return contractRejectMapper.selectAll();
    }

}
