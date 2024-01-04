package com.itheima;/*
 *ClassName:MybatisDemo
 *Description: 加载核心配置文件
 *@Author:deanzhou
 *@Date:2023-12-16 18:13
 */

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //1. 加载mysql核心配置文件，获取sqlSessionFacotry
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSessionFactory object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.execute sql statement

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        //4.print the users
        System.out.println(users);
        //5. release the resource
        sqlSession.close();
    }
}
