package com.will;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);


    public String getString(String query) {
        System.out.print(query);
        String value = scanner.nextLine();
        return value;
    }

    public int getInt(String query) {
        int value;
        while(true) {
        System.out.print(query);
        value = scanner.nextInt();

        if(value >= 10 && value <= 10000) {
            return value;
        }
            System.out.println("Choose amount between 10 & 10000!");
        }
//        System.out.println(value);


    }


}