package com.jixun.exception;

public class MyException extends Exception {
    public MyException() {
    }
    public MyException(String message) {
        super(message);
    }
    public static void MyOrderException(String message) {
        System.out.println(message);
    }
    public static Runnable arrayOutOfRun(Runnable[] runnable, int index, Runnable error) {
        if ((index > runnable.length) || (index < 1)) {
            System.err.println("输入有误，请重新输入！");
            //输入的数组下标越界提示输入错误并引用重新执行的命令操作方法
            return error;
        }
        // 返回输入的对应下标的方法引用
        return runnable[index - 1];
    }
}
