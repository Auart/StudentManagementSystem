package com.jixun.data;

import com.jixun.Student;

import java.util.List;


public interface Information {


    Student addData(List< String > tempData);

    boolean upDataById(Integer id);

    boolean upDataByName(String name);

    boolean queryById(Integer id);

    boolean queryByName(String name);

    boolean deleteById(Integer id);

    boolean deleteByName(String name);

    void orderByIdAsc();

    void orderByIdDesc();

    void groupBySex();

    void groupByMajor();


}
