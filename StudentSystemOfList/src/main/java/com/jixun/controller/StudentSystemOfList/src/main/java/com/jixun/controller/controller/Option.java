package com.jixun.controller.controller;


import com.jixun.service.Operation;

public abstract class Option extends Operation {


    public static void upDataById() {
        setInfo(BASE_ID, "upDataById", "修改");
    }

    public static void upDataByName() {
        setInfo(BASE_NAME, "upDataByName", "修改");
    }

    public static void queryById() {
        setInfo(BASE_ID, "queryById", "查询");
    }

    public static void queryByName() {
        setInfo(BASE_NAME, "queryByName", "查询");
    }

    public static void deleteById() {
        setInfo(BASE_ID, "deleteById", "删除");
    }

    public static void deleteByName() {
        setInfo(BASE_NAME, "deleteByName", "删除");
    }



}