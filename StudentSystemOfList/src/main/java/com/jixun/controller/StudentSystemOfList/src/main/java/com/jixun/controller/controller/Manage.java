package com.jixun.controller.controller;
import com.jixun.controller.view.AddModifyUI;
import com.jixun.controller.view.SystemUI;
import com.jixun.dao.InfoImpl;
import com.jixun.Student;
import com.jixun.dao.Information;
import com.jixun.service.Tool;

import java.util.*;


public class Manage {

    public static final Information info = new InfoImpl();

    public static void add() {
        //1.初始化界面
        AddModifyUI addUI = new InfoImpl();
        List< String > tempData = addUI.printInfo();
        //2.添加数据
        Student student = info.addData(tempData);
        //3.判断数据是否添加成功
        Tool.judge(student != null, "添加成功",
                () -> System.out.println(student),
                "添加失败", () -> {
                }).run();
        tempData.clear();
        //4.操作结束提示用户是否返回主菜单
        Tool.backMainMenu(Manage::add);
    }


    public static void update() {
        Runnable[] runnable = {Option::upDataById, Option::upDataByName, Menu::mainMenu};
        data(SystemUI.UPDATE, runnable, Manage::update);

    }

    public static void query() {
        Runnable[] runnable = {Manage::queryAll,Option::queryById, Option::queryByName,info::orderByIdAsc,info::orderByIdDesc,info::groupBySex,info::groupByMajor, Menu::mainMenu};
        data(SystemUI.QUERY, runnable, Manage::query);
    }

    public static void delete() {
        Runnable[] runnable = {Option::deleteById, Option::deleteByName, Manage::deleteAll, Menu::mainMenu};
        data(SystemUI.DELETE, runnable, Manage::delete);
    }
    public static void queryAll() {
        System.out.println(new Student().printInfo());
        //查询结束提示用户返回
        Tool.returnToPrevious(Manage::queryAll, Manage::query);
    }
    public static void deleteAll() {
        Runnable [] runnable={()->InfoImpl.students.clear()};
        String[] ui={"确定删除所有学生信息吗？"};
        data(ui,runnable,Manage::delete);
        System.out.println("删除成功！");
        //查询结束提示用户返回
        Tool.returnToPrevious(Manage::deleteAll, Manage::delete);
    }
    /**
     * @param ui:初始化界面
     * @param runnable:存放界面对应的方法
     * @param again:转入运行完后继续运行的方法
     */
    private static void data(String[] ui, Runnable[] runnable, Runnable again) {
        //初始化界面
        SystemUI.UI(ui);
        //等待用户输入命令执行对应的方法
        int order = Integer.parseInt(Tool.sc.nextLine());
        Tool.arrayOutOfRun(runnable, order, again).run();
    }
}
