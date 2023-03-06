package com.bes;

class StringParser {
    String input;
    String[] words;
    Number[] numbers;
    Operation operation;

    public StringParser(String str) throws Exception {
        input = str;
        words = getWords(str);
        operation = getOperation();
        numbers = getNumbers();
    }

    private String[] getWords(String str) throws Exception {
        String[] result = str.split(" ");
        if(result.length != 3){
            throw new Exception("Incorrect input. Invalid number of arguments.");
        }
        return result;
    }

    private Number[] getNumbers() throws Exception {
        //TODO Add notation selection!
        Number[] result = new Number[2];
        result[0] = new RomanNumber(words[0]);
        result[1] = new RomanNumber(words[2]);
        return result;
    }

    private Operation getOperation() throws Exception {
        if(words[1].length() != 1){
            throw new Exception("Incorrect input. Unknown operation.");
        }
        return switch (words[1].charAt(0)) {
                case '+' -> Operation.ADD;
                case '-' -> Operation.SUB;
                case '*' -> Operation.MULTI;
                case '/' -> Operation.DIV;
                default -> Operation.UNKNOWN;
        };
    }
}
