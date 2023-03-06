package com.bes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            String result = calc(userInput);
            System.out.println(result);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private static String calc(String input) throws Exception {
        StringParser parser = new StringParser(input);
        Number result;
        Number num1 = parser.numbers[0];
        Number num2 = parser.numbers[1];
        switch (parser.operation){
            case ADD:
                result = num1.add(num2);
                break;
            case SUB:
                result = num1.sub(num2);
                break;
            case MULTI:
                result = num1.multi(num2);
                break;
            case DIV:
                result = num1.div(num2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + parser.operation);
        }
        return result.toString();
    }
}
