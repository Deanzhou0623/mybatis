package com.itheima.test;/*
 *ClassName:MybatisTest
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-17 14:27
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        Assert.assertNotNull(brands);
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        int id=1;
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        Brand brands = brandMapper.selectById(id);
        System.out.println(brands);
        //5. release resource
        sqlSession.close();
    }


    @Test
    public void testSelectByConditions() throws IOException {
        int status=1;
        String companyName ="小米";
        String brandName ="小米";

        companyName = "%" + companyName+"%";
        brandName="%"+brandName+"%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        List<Brand> brands = brandMapper.selectByConditions(map);
        System.out.println(brands);
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testSelectBySingleCondition() throws IOException {
        int status=1;
        String companyName ="小米";
        String brandName ="小米";

        companyName = "%" + companyName+"%";
        brandName="%"+brandName+"%";

        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);

//        Map map = new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        List<Brand> brands = brandMapper.selectBySingleCondition(brand);
        System.out.println(brands);
        //5. release resource
        sqlSession.close();
    }


    @Test
    public void testAdd() throws IOException {
        int status=1;
        String companyName ="小米gg";
        String brandName ="小米gga";
        String description = "aaaaa";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setStatus(status);
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
//        sqlSession.commit();
        //5. release resource
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {
        int status=0;
        String companyName ="小米ggfff";
        String brandName ="小米ggaggg";
        String description = "aaaaadgfag";
        int ordered = 200;
        int id=6;

        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
        brand.setStatus(status);
        brand.setId(id);
        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        brandMapper.update(brand);
        System.out.println(brand.getId());
//        sqlSession.commit();
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        int id=6;

        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        brandMapper.deleteById(id);
//        sqlSession.commit();
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        int[] ids={2,3,4};

        //1. get sqlSession factory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. get mapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.
        brandMapper.deleteByIds(ids );
//        sqlSession.commit();
        //5. release resource
        sqlSession.close();
    }
}
