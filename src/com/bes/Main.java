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
        Number left = parser.numbers[0];
        Number right = parser.numbers[1];
        result = switch (parser.operation) {
            case ADD -> left.add(right);
            case SUB -> left.sub(right);
            case MULTI -> left.multi(right);
            case DIV -> left.div(right);
            default -> throw new Exception("Unexpected value: " + parser.operation);
        };
        return result.toString();
    }
}
