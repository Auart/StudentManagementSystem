package com.jixun.view;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface SystemUI<E> {

    List< String > tempData = new ArrayList<>();
    String[] LOGIN = {
            "请输入管理员账号：",
            "请输入管理员密码："};
    String[] MAIN_MENU = {
            "添加学生学籍信息",
            "修改学生学籍信息",
            "查询学生学籍信息",
            "删除学生学籍信息",
            "退出学生管理系统"
    };
    String[] DELETE = {
            "按学号删除学生信息",
            "按姓名删除学生信息",
            "删除所有学生信息",
            "返回主菜单"
    };
    String[] UPDATE = {
            "按学号修改学生信息",
            "按姓名修改学生信息",
            "返回主菜单"
    };
    String[] QUERY = {
            "查询所有学生信息",
            "按学号查询学生信息",
            "按姓名查询学生信息",
            "按学号进行升序排序",
            "按学号进行降序排序",
            "按性别进行分组",
            "按专业进行分组",
            "返回主菜单"
    };
    String[] FIELD = {
            "学号",
            "姓名",
            "性别",
            "年龄",
            "籍贯",
            "系部",
            "专业",
            "电话",
    };
    String[] RETURN = {
            "继续",
            "返回上一级",
            "返回主菜单"

    };
    String[] RETURN_MAIN = {
            "继续",
            "返回主菜单"
    };
    String[] QUIT_MAIN = {
            "退出系统",
            "退出登录",
            "返回主菜单"
    };
    String TITLE = "学生学籍管理系统";
    String BASE_NAME = "请输入学生姓名";
    String BASE_ID = "请输入学生学号";

    static void UI(String title, String[] field) {
        UI(title, field, "", ".", "\n");
    }


    static void UI(String[] field) {
        UI("\r", field);
    }

    static void UI(String title, String[] field, String head, String middle, String end) {
        System.out.println(title);
        for (int i = 0; i < field.length; i++) {
            System.out.printf(head + "%d" + middle + "%s" + end, i + 1, field[i]);
        }
    }

    List<E> printInfo();
}
