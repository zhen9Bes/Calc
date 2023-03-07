package com.bes;

class StringParser {
    String input;
    String[] words;
    Number[] numbers;
    Operation operation;

    public StringParser(String input) throws Exception {
        this.input = input;
        words = getWords(input);
        operation = getOperation();
        numbers = getNumbers();
    }

    private String[] getWords(String str) throws Exception {
        String[] result = str.split(" ");
        if(result.length != 3){
            throw new Exception("Incorrect input:" + str + ". Invalid number of operands.");
        }
        return result;
    }

    private Number[] getNumbers() throws Exception {
        Number[] result = new Number[2];
        String leftNumber = words[0];
        String rightNumber = words[2];
        if(RomanNumber.validate(leftNumber) && RomanNumber.validate(rightNumber)){
            result[0] = new RomanNumber(leftNumber);
            result[1] = new RomanNumber(rightNumber);
        }else if(ArabicNumber.validate(leftNumber) && ArabicNumber.validate(rightNumber)){
            result[0] = new ArabicNumber(leftNumber);
            result[1] = new ArabicNumber(rightNumber);
        }else{
            throw new Exception("Incorrect input: " + leftNumber + " " + rightNumber +". Different number systems.");
        }
        return result;
    }

    private Operation getOperation() throws Exception {
        if(words[1].length() != 1){
            throw new Exception("Incorrect input: " + words[1] + ". Unknown operation.");
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
