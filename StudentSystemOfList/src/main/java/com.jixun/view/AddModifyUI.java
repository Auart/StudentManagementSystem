package com.jixun.view;

import com.jixun.Tool;
import java.util.List;

public class AddModifyUI implements SystemUI{

    @Override
    public List<String> printInfo() {
        for (String s : FIELD) {
            System.out.print("请输入学生" + s);
            tempData.add(Tool.sc.nextLine());
        }
       return tempData;
    }
}
