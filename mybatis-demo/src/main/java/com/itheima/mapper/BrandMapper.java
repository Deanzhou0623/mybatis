package com.itheima.mapper;/*
 *ClassName:BrandMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-17 15:40
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
     * query all brand
     * */
    public List<Brand> selectAll();

    /*
     * query by id
     * */
    public Brand selectById(int id);

    /**
     * select by condition
     */
//    List<Brand> selectByConditions(@Param("status") int status,
//                                   @Param("companyName") String companyName,
//                                   @Param("brandName") String brandName);

//        List<Brand> selectByConditions(Brand brand);
    List<Brand> selectByConditions(Map map);

    List<Brand> selectBySingleCondition(Brand brand);

    /*add brand
    * */
    void add(Brand brand);

    /*
    * update brand
    * */
    void update(Brand brand);

    /*
    * delete brand
    * */
    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}


