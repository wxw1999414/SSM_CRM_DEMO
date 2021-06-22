package com.yc137.service.impl;

import com.yc137.domain.TAuthority;
import com.yc137.mapper.TAuthorityMapper;
import com.yc137.service.TAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TAuthorityServiceImpl implements TAuthorityService {
    @Autowired
    private TAuthorityMapper TAuthorityDao;


    @Override
    public int deleteByPrimaryKey(Long id) {
        int num = TAuthorityDao.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int insert(TAuthority record) {
        int num = TAuthorityDao.insert(record);
        return num;
    }

    @Override
    public int insertSelective(TAuthority record) {
        return 0;
    }

    @Override
    public TAuthority selectByPrimaryKey(Long id) {

        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TAuthority record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TAuthority record) {
        int num = TAuthorityDao.updateByPrimaryKey(record);
        return num;
    }

    @Override
    public List<TAuthority> selectByParentId(Long parentId) {
        List<TAuthority> authorities = TAuthorityDao.selectByParentId(parentId);
        return authorities;
    }

    @Override
    public List<Map<String, Object>> selectAuthorities(Long parentId) {
        if (parentId == null) {
            parentId = 1L;
        }
        //定集合 存放树形数据
        ArrayList<Map<String, Object>> listA = new ArrayList<>();
        //菜单模块
        List<TAuthority> list2 = TAuthorityDao.selectByParentId(parentId);
        //遍历集合
        for (TAuthority trm : list2) {
            //查询数据 存入集合
            Map<String, Object> hmMenu2 = new HashMap<String, Object>();
            //将一级菜单存入集合中
            hmMenu2.put("menu2", trm);
            //得到对应的二级菜单 ：集合
            List<TAuthority> list3 = TAuthorityDao.selectByParentId(trm.getId());

            List<Map<String, Object>> listB = new ArrayList<Map<String, Object>>();
            for (TAuthority my : list3) {
                Map<String, Object> hmMenu3 = new HashMap<String, Object>();
                hmMenu3.put("menu3", my);
                //查询三级菜单
                List<TAuthority> list4 = TAuthorityDao.selectByParentId(my.getId());
                hmMenu3.put("menu3Val", list4);

                listB.add(hmMenu3);
            }
            hmMenu2.put("menu2val", listB);
            listA.add(hmMenu2);
        }

        return listA;
    }

    @Override
    public List<TAuthority> selectById(Long id) {
        return TAuthorityDao.selectByParentId(id);
    }

    @Override
    public List<TAuthority> selectConditonById(Long id) {
        return TAuthorityDao.selectConditionById(id);
    }


}

