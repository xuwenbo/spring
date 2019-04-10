package com.webb.dao;

import com.webb.dao.SubAccountUser;

public interface SubAccountUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubAccountUser record);

    int insertSelective(SubAccountUser record);

    SubAccountUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubAccountUser record);

    int updateByPrimaryKey(SubAccountUser record);
}