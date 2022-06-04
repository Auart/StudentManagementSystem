package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 键盘输入容器
 */
public interface KeyboardInputContainer{
    public static Scanner sc = new Scanner(System.in);
    public static List<String> inputStatements = new ArrayList<>();

    public static List<String> getInputContainer(String[] inputStatement) {
        Collections.addAll(inputStatements, inputStatement);
        return inputStatements;
    }
}