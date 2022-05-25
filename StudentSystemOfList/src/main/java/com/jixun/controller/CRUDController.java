package com.jixun.controller;
import com.jixun.dao.StudentDao;
import com.jixun.dao.Student;
import com.jixun.service.StudentService;
import com.jixun.service.StudentServiceImpl;
import com.jixun.utils.Tool;
import com.jixun.view.AddModifyUI;
import com.jixun.view.SystemUI;
import java.util.List;


public class CRUDController {

    public static final StudentService info = new StudentServiceImpl();

    public static void add() {
        //1.初始化界面
        AddModifyUI addUI = new StudentServiceImpl();
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
        Tool.backMainMenu(CRUDController::add);
    }


    public static void update() {
        Runnable[] runnable = {StudentDao::upDataById, StudentDao::upDataByName, MenuController::mainMenu};
        data(SystemUI.UPDATE, runnable, CRUDController::update);

    }

    public static void query() {
        Runnable[] runnable = {CRUDController::queryAll, StudentDao::queryById, StudentDao::queryByName, info::orderByIdAsc, info::orderByIdDesc, info::groupBySex, info::groupByMajor, MenuController::mainMenu};
        data(SystemUI.QUERY, runnable, CRUDController::query);
    }

    public static void delete() {
        Runnable[] runnable = {StudentDao::deleteById, StudentDao::deleteByName, CRUDController::deleteAll, MenuController::mainMenu};
        data(SystemUI.DELETE, runnable, CRUDController::delete);
    }

    public static void queryAll() {
        System.out.println(new Student().printInfo());
        //查询结束提示用户返回
        Tool.returnToPrevious(CRUDController::queryAll, CRUDController::query);
    }

    public static void deleteAll() {
        Runnable[] runnable = {() -> StudentServiceImpl.students.clear()};
        String[] ui = {"确定删除所有学生信息吗？"};
        data(ui, runnable, CRUDController::delete);
        System.out.println("删除成功！");
        //查询结束提示用户返回
        Tool.returnToPrevious(CRUDController::deleteAll, CRUDController::delete);
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
