package com.yc137.mapper;

import com.yc137.domain.TAuthority;import org.apache.ibatis.annotations.ResultMap;import org.apache.ibatis.annotations.Select;import java.util.List;

public interface TAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TAuthority record);

    int insertSelective(TAuthority record);

    TAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TAuthority record);

    int updateByPrimaryKey(TAuthority record);

    @Select("select * from t_authority where PARENT_ID=#{parentId} ")
    @ResultMap("BaseResultMap")
    List<TAuthority> selectByParentId(Long parentId);


    List<TAuthority> selectConditionById(Long id);
}