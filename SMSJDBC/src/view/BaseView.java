package view;

public abstract class BaseView {
    public static String[] MAIN_MENU = {
            "添加学生信息",
            "修改学生信息",
            "删除学生信息",
            "查询学生信息",
            "退出管理系统"
    };
    public static String[] ADD_MENU = {
            "姓名",
            "性别",
            "年龄",
            "籍贯",
            "系部",
            "专业",
            "电话"
    };


    public static String[] DELETE_MENU = {
            "按ID删除学生信息",
    };
    public static String[] UPDATE_MENU = {
            "ID",
            "姓名",
            "性别",
            "年龄",
            "籍贯",
            "系部",
            "专业",
            "电话"
    };
    public static String[] QUERY_MENU = {
            "按ID查询学生信息",
            "查询所有学生信息",
            "返回主菜单"

    };
   static String [] LOGIN_MENU={
            "请输入管理员账号",
            "请输入管理员密码"
    };

    public abstract void mainMenu();
    public abstract void addMenu();
    public abstract void deleteMenu();
    public abstract void updateMenu();
    public abstract void queryMenu();

    public static void createUI(String title, String[] menu) {
        System.out.println(title);
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d%s%s%s",i+1,".",menu[i],"\t");
        }
        System.out.println("\n请输入对应的序号");
    }
    public static void createUI(String title, String[] menu, String end) {
        System.out.println(title);
        for (int i = 0; i < menu.length; i++) {
            System.out.print(i+1+"."+menu[i]+end);
        }
        System.out.println("\n请输入对应的序号");
    }
}
