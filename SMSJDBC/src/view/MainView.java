package view;

import dao.pojo.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import utils.KeyboardInputContainer;
import utils.Tools;
import utils.Type;

public class MainView extends BaseView implements KeyboardInputContainer {
    StudentService studentService = new StudentServiceImpl();

    @Override
    public void mainMenu() {
        createUI("\t\t\t\t\t欢迎进入学生学籍管理系统", MAIN_MENU);
        Runnable[] runMethods = {this::addMenu, this::updateMenu, this::deleteMenu, this::queryMenu, Tools::quit};
        int order = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
        Tools.executeRunnable(runMethods, order, this::mainMenu);
    }

    @Override
    public void addMenu() {
        System.out.println("添加学生信息");
        for (String addMenu : ADD_MENU) {
            System.out.println("请输入学生" + addMenu);
            inputStatements.add(sc.nextLine());
        }
        Student student = new Tools().typeConversion(inputStatements, Type.ADD);
        Boolean flag = studentService.addStudent(student);
        System.out.println(flag ? "添加成功" : "添加失败");
        studentService.getAllStudent().forEach(System.out::println);
        inputStatements.clear();
        Tools.returnTo(this::addMenu, this::mainMenu);
    }

    @Override
    public void updateMenu() {
        System.out.println("按ID修改学生信息");
        for (String updateMenu : UPDATE_MENU) {
            System.out.println("请输入学生" + updateMenu);
            inputStatements.add(sc.nextLine());
        }
        Student student = new Tools().typeConversion(inputStatements, Type.UPDATE);
        boolean flag = studentService.updateStudent(student);
        System.out.println(flag ? "修改成功" : "修改失败");
        studentService.getAllStudent().forEach(System.out::println);
        inputStatements.clear();
        Tools.returnTo(this::updateMenu, this::mainMenu);
    }

    @Override
    public void deleteMenu() {
        System.out.println("请输入学生ID进行删除");
        String inputData = KeyboardInputContainer.sc.nextLine();
        boolean flag = studentService.deleteStudent(Integer.parseInt(inputData));
        System.out.println(flag ? "删除成功" : "删除失败");
        studentService.getAllStudent().forEach(System.out::println);
        Tools.returnTo(this::deleteMenu, this::mainMenu);
    }

    @Override
    public void queryMenu() {
        createUI("查询学生信息", QUERY_MENU, "\t");
        int order = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
        Runnable[] run = {() -> {
            System.out.println("请输入学生ID进行查询");
            int inputData = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
            studentService.getStudent(inputData).forEach(System.out::println);
        }, () -> studentService.getAllStudent().forEach(System.out::println), this::mainMenu};
        Tools.executeRunnable(run, order, this::queryMenu);
        Tools.returnTo(this::queryMenu, this::mainMenu);
    }
}
