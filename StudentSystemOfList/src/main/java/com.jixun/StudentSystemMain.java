package com.jixun;


/**
 * Ownership of copyright:
 * @author 张金鑫
 * Contact information:13386644091
 * @version jdk1.8.0
 * Final modification time：2022/01/21
 *
 */

public class StudentSystemMain {
    public static void main(String[] args) {
        run();
    }
    /**
     * 学生管理系统运行入口
     */
    public static void run()  {
        try {
            Login.class.newInstance().login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
