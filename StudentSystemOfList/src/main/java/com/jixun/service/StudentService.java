package com.jixun.service;

import com.jixun.dao.Student;

import java.util.List;


public interface StudentService {


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
