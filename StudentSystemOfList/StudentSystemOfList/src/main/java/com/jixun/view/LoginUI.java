package com.jixun.view;
import com.jixun.utils.Tool;
import java.util.List;


public class LoginUI implements SystemUI {
    @Override
    public List< String > printInfo() {
        for (String s : LOGIN) {
            System.out.print(s + "\n");
            tempData.add(Tool.sc.nextLine());
        }
        return tempData;
    }
}
