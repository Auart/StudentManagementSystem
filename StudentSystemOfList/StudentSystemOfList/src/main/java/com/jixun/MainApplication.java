package com.jixun;
import com.jixun.controller.LoginController;
/**
 * Ownership of copyright:
 * @author zhangjinxin
 * Contact information:2770496921
 * @version jdk1.8.0
 * Final modification time：2022/01/21
 */

public class MainApplication {
    public static void main(String[] args) {
        run();
    }
    /**
     * 学生管理系统运行入口
     */
    public static void run() {
        try {
            LoginController.class.newInstance().login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
