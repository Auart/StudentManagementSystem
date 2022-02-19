package com.jixun.dao;

import com.jixun.Student;
import com.jixun.controller.controller.Manage;
import com.jixun.controller.view.AddModifyUI;
import com.jixun.controller.view.SystemUI;
import com.jixun.service.Tool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数据访问层
 */
public class InfoImpl extends AddModifyUI implements Information {

    public static List< Student > students = new ArrayList<>();

    // 按学号升序显示学生信息
    @Override
    public void orderByIdAsc() {
        Stream< Student > sortByIdAsc = students.stream().sorted(Comparator.comparing(Student::getId));
        System.out.println(sortByIdAsc);
    }

    //按学号降序显示学生信息
    @Override
    public void orderByIdDesc() {
        Stream< Student > sortByIdDesc = students.stream().sorted(Comparator.comparing(Student::getId).reversed());
        System.out.println(sortByIdDesc);
    }

    //按性别分组显示学生信息
    @Override
    public void groupBySex() {
        Map< String, List< Student > > groupBySex = students.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println(groupBySex);
    }

    //默认排序
    @Override
    public void groupByMajor() {
        Map< String, List< Student > > groupByMajor = students.stream().collect(Collectors.groupingBy(Student::getMajor));
        System.out.println(groupByMajor);
    }


    /**
     * 添加学生数据信息
     *
     * @param
     * @return
     */
    @Override
    public Student addData(List< String > inputData) {
        for (Student student : students) {
            Tool.judge(student.getId() != Integer.parseInt(inputData.get(0)),
                    "", () -> Manage.info.addData(inputData),
                    "学号不能重复！", SystemUI.tempData::clear).run();
        }

        return Tool.typeConversion(inputData, true);
    }

    /**
     * 通过学号修改学生信息
     *
     * @param id
     * @return
     */
    @Override
    public boolean upDataById(Integer id) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (int i = 0; i < students.size(); i++) {
                flag = (students.get(i).getId() == id);
                if (flag) {
                    Student student = Tool.typeConversion(printInfo(), false);
                    students.set(i, student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        SystemUI.tempData.clear();
        return flag;
    }

    /**
     * 通过姓名修改学生信息
     *
     * @param name
     * @return
     */
    @Override
    public boolean upDataByName(String name) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (int i = 0; i < students.size(); i++) {
                flag = (Objects.equals(students.get(i).getName(), name));
                if (flag) {
                    List< String > update = printInfo();
                    Student student = Tool.typeConversion(update, false);
                    students.set(i, student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        SystemUI.tempData.clear();
        return flag;
    }

    /**
     * 通过学号查询学生信息
     *
     * @param id
     * @return
     */
    @Override
    public boolean queryById(Integer id) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (Student student : students) {
                flag = (student.getId() == id);
                if (flag) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        return flag;
    }

    /**
     * 通过姓名查询学生信息
     *
     * @param name
     * @return
     */
    @Override
    public boolean queryByName(String name) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (Student student : students) {
                flag = (Objects.equals(student.getName(), name));
                if (flag) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        return flag;
    }

    /**
     * 通过学号删除学生信息
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Integer id) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (Student student : students) {
                flag = (student.getId() == id);
                if (flag) {
                    students.remove(student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        return flag;
    }

    /**
     * 通过姓名删除学生信息
     *
     * @param name
     * @return
     */
    @Override
    public boolean deleteByName(String name) {
        boolean flag = false;
        if (!students.isEmpty()) {
            for (Student student : students) {
                flag = (Objects.equals(student.getName(), name));
                if (flag) {
                    students.remove(student);
                }
            }
        } else {
            System.out.println("暂无学生信息");
        }
        return flag;
    }

}
