package com.yc137.mapper;

import com.yc137.domain.TAuthority;import com.yc137.domain.TRole;import org.apache.ibatis.annotations.ResultMap;import org.apache.ibatis.annotations.Select;import java.util.List;

public interface TRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    TRole selectByRole(TRole record);

    @Select("select * from t_role")
    @ResultMap("BaseResultMap")
    List<TRole> findAll();

    List<TAuthority> selectRoleAuthById(Long id);
}