package com.yc137.mapper;

import com.yc137.domain.TUser;import java.util.List;
import java.util.Map;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectByUser(TUser record);

    /*   @Select("select * from t_user")
        @ResultMap("BaseResultMap")*/
    List<TUser> findAll();
    List<Map<String,Object>> selectALL();
}