package util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner inputUser = new Scanner(System.in);

    public static String input(String info){

        System.out.print(info +" : ");
        String data = inputUser.nextLine();
        return data;
    }
}
