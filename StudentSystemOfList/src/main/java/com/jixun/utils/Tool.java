package com.jixun.utils;
import com.jixun.controller.LoginController;
import com.jixun.controller.MenuController;
import com.jixun.dao.Student;
import com.jixun.service.StudentServiceImpl;
import com.jixun.view.SystemUI;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
/**
 * 工具类
 */
public class Tool {
    public static Scanner sc = new Scanner(System.in);
    /**
     * 功能：
     * 处理输入数组下标越界
     * 提示：方法引用必须调用run()才能运行
     */

    public static Runnable arrayOutOfRun(Runnable[] runnable, int index, Runnable inputError) {
        if ((index > runnable.length) || (index < 1)) {
            System.err.println("输入有误，请重新输入！");
            //输入的数组下标越界提示输入错误并引用重新执行的命令操作方法
            return inputError;
        }
        // 返回输入的对应下标的方法引用
        return runnable[index - 1];
    }

    /**
     * 功能：
     * 返回主菜单
     * 按1继续，按2返回主菜单
     */

    public static void backMainMenu(Runnable again) {
        SystemUI.UI("", SystemUI.RETURN_MAIN, "按", "", "\t");
        Runnable[] runnable = {again, MenuController::mainMenu};
        int order = Integer.parseInt(Tool.sc.nextLine());
        arrayOutOfRun(runnable, order, () -> Tool.backMainMenu(again)).run();
    }
    /**
     * 功能：
     * 逻辑数据判断操作
     *
     * @param flag
     * @param inputRight
     * @param returnTrue
     * @param inputError
     * @param returnFalse
     * @return
     */
    public static Runnable judge(boolean flag, String inputRight, Runnable returnTrue, String inputError, Runnable returnFalse) {
        if (flag) {
            //flag条件为真的输出语句
            System.out.println(inputRight);
            //返回flag条件为真的方法引用
            return returnTrue;
        }
        System.err.println(inputError);
        return returnFalse;
    }
    public static Runnable judge(boolean flag, String inputRight, String inputError) {
        return judge(flag, inputRight, () -> {
        }, inputError, () -> {
        });
    }
    public static Runnable judge(boolean flag, Runnable returnTrue, Runnable returnFalse) {
        return judge(flag, "\r", returnTrue, "\r", returnFalse);
    }
    /**
     * 功能：返回
     * 参数1：返回现在
     * 参数2：返回上一级
     * 按1继续，按2返回上一级，按3返回主菜单
     */

    public static void returnToPrevious(Runnable again, Runnable previous) {
        //初始化界面，提示用户输入
        SystemUI.UI("", SystemUI.RETURN, "按", "", "\t");
        Runnable[] runnable = {again, previous, MenuController::mainMenu};
        int order = Integer.parseInt(Tool.sc.nextLine());
        arrayOutOfRun(runnable, order, () -> returnToPrevious(again, previous)).run();
    }

    /**
     * 功能：
     * 退出系统
     */
    public static void quit() {
        //初始化界面，提示用户输入
        SystemUI.UI("", SystemUI.QUIT_MAIN, "按", "", "\t");
        Runnable[] runnable = {Tool::exit, () -> new LoginController().login(), MenuController::mainMenu};
        int order = Integer.parseInt(Tool.sc.nextLine());
        arrayOutOfRun(runnable, order, Tool::quit).run();
    }
    private static void exit() {
        System.out.println(" 谢谢使用！");
        System.exit(0);
    }
    /**
     * 把临时list内容逐个取出来放进Student实体类List集合中
     *
     * @param list
     * @throws Exception
     */

    public static Student typeConversion(List< String > list, boolean add) {
        if (list.size() != 0) {
            try {
                //得到实体类字段
                Field[] fields = Student.class.getDeclaredFields();
                Student student = Student.class.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    //遍历字段名
                    Field field = Student.class.getDeclaredField(fields[i].getName());
                    // 打开权限
                    field.setAccessible(true);
                    //判断字段名类型进行赋值
                    if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                        //为int
                        field.set(student, Integer.parseInt(list.get(i)));
                    } else {
                        //为String
                        field.set(student, list.get(i));
                    }
                }
                //通过上级的判断是否赋值否添加到List<Student>中
                if (add) {
                    StudentServiceImpl.students.add(student);
                }
                return student;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
