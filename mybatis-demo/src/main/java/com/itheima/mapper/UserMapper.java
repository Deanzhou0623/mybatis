package com.itheima.mapper;/*
 *ClassName:UserMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-17 13:51
 */

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

    //query all users
    List<User> selectAll();

    //query by user id
    User selectById(int id);
}
