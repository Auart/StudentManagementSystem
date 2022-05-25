package com.jixun.controller;
import com.jixun.utils.Tool;
import com.jixun.view.SystemUI;

public class MenuController implements Runnable {
    /**
     * 主菜单
     */
    public static void mainMenu() {
        SystemUI.UI("\r " + SystemUI.TITLE, SystemUI.MAIN_MENU);
        //存放界面对应的方法
        Runnable[] runnable = {
                CRUDController::add,
                CRUDController::update,
                CRUDController::query,
                CRUDController::delete,
                Tool::quit};
        //等待用户输入命令执行对应的方法
        int order=Integer.parseInt(Tool.sc.nextLine());
        //处理用户输入命令有误操作
        Tool.arrayOutOfRun(runnable, order, MenuController::mainMenu).run();
    }
    @Override
    public void run() {
    }
}
