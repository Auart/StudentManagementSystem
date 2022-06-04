import view.LoginView;
import view.MainView;

/**
 * Ownership of copyright:
 * @author zhangjinxin
 * Contact information:2770496921@qq.com
 * @version jdk1.8.0
 * Final modification time：2022/05/20
 */
public class MainApplication {
    public static void main(String[] args) throws Exception {
       LoginView.class.newInstance().login();
//        MainView.class.newInstance().queryMenu();
    }
}
