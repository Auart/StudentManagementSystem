package com.jixun.controller.controller;

import com.jixun.controller.view.SystemUI;
import com.jixun.service.Tool;

public class Menu implements Runnable {
    /**
     * 主菜单
     */
    public static void mainMenu() {
        SystemUI.UI("\r " + SystemUI.TITLE, SystemUI.MAIN_MENU);
        //存放界面对应的方法
        Runnable[] runnable = {
                Manage::add,
                Manage::update,
                Manage::query,
                Manage::delete,
                Tool::quit};
        //等待用户输入命令执行对应的方法
        int order = Integer.parseInt(Tool.sc.nextLine());
        //处理用户输入命令有误操作
        Tool.arrayOutOfRun(runnable, order, Menu::mainMenu).run();

    }

    @Override
    public void run() {
    }
}
