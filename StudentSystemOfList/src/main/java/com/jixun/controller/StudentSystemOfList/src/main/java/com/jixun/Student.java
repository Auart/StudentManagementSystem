package com.jixun;

import com.jixun.dao.InfoImpl;
import com.jixun.controller.view.SystemUI;

import java.util.List;

/**
 * 学生类
 */
public class Student implements SystemUI {
    private int id;//学号
    private String name ;//姓名
    private String sex;//性别
    private int age;//年龄
    private String nativePlace;//籍贯
    private String department;//系部
    private String major;//专业
    private int phone;//电话

    public Student() {
    }
    public Student(int id, String name, String sex, int age, String nativePlace, String department, String major, int phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nativePlace = nativePlace;
        this.department = department;
        this.major = major;
        this.phone = phone;
    }


    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", nativePlace='" + nativePlace + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public List<Student> printInfo() {
        System.out.println("所有学生信息：\n");
        for (int i = 0; i < InfoImpl.students.size(); i++) {
            System.out.println(("学号" + InfoImpl.students.get(i).getId() + "\n" +
                    "姓名" + InfoImpl.students.get(i).getName() + "\n" +
                    "性别" + InfoImpl.students.get(i).getSex() + "\n" +
                    "年龄" + InfoImpl.students.get(i).getAge() + "\n" +
                    "籍贯" + InfoImpl.students.get(i).getNativePlace() + "\n" +
                    "系部" + InfoImpl.students.get(i).getDepartment() + "\n" +
                    "专业" + InfoImpl.students.get(i).getMajor() + "\n" +
                    "电话" + InfoImpl.students.get(i).getPhone() + "\n"));
        }
        return null;
    }
}
