package com.jixun.service;


import com.jixun.controller.controller.Menu;
import com.jixun.controller.view.LoginUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Login extends LoginUI {


    /**
     * 用户登录
     */
    public void login() {
        printInfo();
        boolean flag = loginJudge();
        //判断用户输入的账号和密码
        Tool.judge(flag, "登录成功！",
                () -> {
                    //防止退出登录bug
                    tempData.clear();
                    Menu.mainMenu();
                },
                "用户名或密码输入错误！，请重新输入",
                () -> {
                    tempData.clear();
                    this.login();
                }).run();
    }

    //判断用户输入的账号与密码是否正确
    public boolean loginJudge() {

        Properties adminProp = new Properties();
        try {
            adminProp.load(new FileInputStream("src\\main\\resources\\admin.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminProp.getProperty("id").equals(tempData.get(0)) & adminProp.getProperty("password").equals(tempData.get(1));
    }
}
