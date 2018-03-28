package com.example.redismybatisweb.mapper;

import com.example.redismybatisweb.dao.UserBasic;

public interface UserBasicMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserBasic record);

    int insertSelective(UserBasic record);

    UserBasic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserBasic record);

    int updateByPrimaryKey(UserBasic record);
}