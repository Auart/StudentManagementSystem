package com.jixun.service;

import com.jixun.controller.controller.Manage;
import com.jixun.controller.controller.Option;
import com.jixun.controller.view.SystemUI;
import com.jixun.dao.InfoImpl;
import java.util.Objects;

public abstract class Operation implements SystemUI {

    /**
     * 输入界面提示信息
     *
     * @param base:提示用户输入信息
     * @param methodName：用户输入后的处理信息方法
     */
    public static void setInfo(String base, String methodName, String afterState) {
        //提示用户输入
        System.out.println(base);
        //分析传入参数运行输入后处理的合适（增删改除）方法
        Tool.judge(base.equals(SystemUI.BASE_ID),
                () -> {
                    //用户输入id后执行反射调用对应合适方法
                    int input = Integer.parseInt(Tool.sc.nextLine());
                    getInformation(methodName, afterState, input);

                },
                () -> {
                    //用户输入name后执行反射调用对应合适方法
                    String input = Tool.sc.nextLine();
                    getInformation(methodName, afterState, input);
                }
        ).run();
        //用户操作完数据提示返回主菜单
        Tool.backMainMenu(() -> {
            try {
                //重新运行方法(继续)
                Option.class.getDeclaredMethod(methodName).invoke(Option.class.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 通过反射执行获取用户输入的信息后方法
     *
     * @param methodName ：获取用户输入的信息后方法name
     * @param args       :获取用户输入的信息后方法的形参数据
     * @return
     */
    static void getInformation(String methodName, String afterState, Object... args) {
        boolean[] flag = {false};
        try {
            //通过传入方法的name得到该方法的参数类型
            String str = methodName.substring(methodName.length() - 2);
            //根据传入方法的name形参判断方法的形参类型后执行获取输入的信息后方法
            Tool.judge(Objects.equals(str, "Id"), () -> {
                try {
                    flag[0] = (Boolean) InfoImpl.class.getDeclaredMethod(methodName, Integer.class).invoke(Manage.info, args);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }, () -> {
                try {
                    flag[0] = (Boolean) InfoImpl.class.getDeclaredMethod(methodName, String.class).invoke(Manage.info, args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).run();
            //判断操作是否执行成功
            Tool.judge(flag[0], afterState + "成功！", afterState + "失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
