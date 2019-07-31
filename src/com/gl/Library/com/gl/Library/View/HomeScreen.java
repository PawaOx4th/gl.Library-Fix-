package com.gl.Library.com.gl.Library.View;

import java.util.Scanner;

public class HomeScreen {
    public static String homeDisplay() {
        System.out.println("================================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your property");
        System.out.println("1 - Login\t2 - register\t3 - Exit");
        return scanner.nextLine();
    }
}

