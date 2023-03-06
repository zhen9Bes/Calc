package com.bes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scaner = new Scanner(System.in);
            String userInput = scaner.nextLine();
            String result = calc(userInput);
            System.out.println(result);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    private static String calc(String input){
        //TODO: logic
        return null;
    }
}
