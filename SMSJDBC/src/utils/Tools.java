package utils;
import dao.pojo.Student;
import view.MainView;
import java.lang.reflect.Field;
import java.util.List;
public class Tools {
    /**
     * 功能：返回
     * 参数1：返回现在
     * 参数2：返回上一级
     * 按1继续，按2返回上一级，按3返回主菜单
     */

    public static void returned(Runnable kept, Runnable previous) {
        System.out.println("按1继续\t按2返回上一级\t按3返回主菜单");
        //初始化界面，提示用户输入
        Runnable[] runnable = {kept, previous, new MainView()::mainMenu};
        int order = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
        executeRunnable(runnable, order, () -> returned(kept, previous));
    }
    public static void returnTo(Runnable kept, Runnable previous) {
        System.out.println("按1继续\t按2返回主菜单");
        //初始化界面，提示用户输入
        Runnable[] runnable = {kept, previous};
        int order = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
        executeRunnable(runnable, order, () -> returned(kept, previous));
    }

    public static void executeRunnable(Runnable[] runMethods, int order, Runnable again) {
        try {
            runMethods[order - 1].run();
        } catch (Exception e) {
            System.err.println("您输入的命令有误，请重新输入！");
            again.run();
        }
    }

    public static void quit() {
        //初始化界面，提示用户输入
        System.out.println("是否退出系统\n1.是\t2.否");
        Runnable[] runnable = {Tools::exit, Tools::quit};
        int order = Integer.parseInt(KeyboardInputContainer.sc.nextLine());
        executeRunnable(runnable, order, Tools::quit);
    }

    private static void exit() {
        System.out.println(" 谢谢使用！");
        System.exit(0);
    }

    public static void judge(boolean flag, Runnable tureRun, Runnable falseRun) {
        (flag ? tureRun : falseRun).run();
    }

    public Student typeConversion(List<String> inputList,Type addORUpdate) {
        if (inputList.size() != 0) {
            try {
                Field[] fields = Student.class.getDeclaredFields();
                Student student = Student.class.newInstance();
                if(addORUpdate.equals(Type.ADD)){
                    for (int i = 1;i < fields.length; i++) {
                        Field field = Student.class.getDeclaredField(fields[i].getName());
                        field.setAccessible(true);
                        //判断字段名类型进行赋值
                        if (field.getGenericType().toString().equals(
                                "class java.lang.Integer")) {
                            field.set(student,Integer.valueOf(inputList.get(i-1)));
                        } else if(field.getGenericType().toString().equals(
                                "class java.lang.String")){
                            field.set(student, inputList.get(i-1));
                        }
                    }
                }else if(Type.UPDATE.equals(addORUpdate)){
                    for (int i = 0; i < fields.length; i++) {
                        Field field = Student.class.getDeclaredField(fields[i].getName());
                        field.setAccessible(true);
                        //判断字段名类型进行赋值
                        if (field.getGenericType().toString().equals(
                                "class java.lang.Integer")) {
                            field.set(student, Integer.valueOf(inputList.get(i)));
                        } else {
                            field.set(student, inputList.get(i));
                        }
                    }
                }
                return student;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
