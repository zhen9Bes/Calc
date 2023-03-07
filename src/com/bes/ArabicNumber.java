package com.bes;

class ArabicNumber extends Number {
    int value;

    public ArabicNumber(String number) throws Exception{
        value = parse(number);
    }

    public ArabicNumber(int number) {
        value = number;
    }

    private int parse(String number) throws Exception {
        int value = Integer.parseInt(number);
        if(value < 1 || value > 10){
            throw new Exception("Incorrect input. Value out of range.");
        }
        return value;
    }

    public static boolean validate(String number){
        try{
            Integer.parseInt(number);
        }catch (Exception exception){
            return false;
        }
        return true;
    }

    @Override
    public Number add(Number number) {
        return new ArabicNumber(value + ((ArabicNumber)number).value);
    }

    @Override
    public Number sub(Number number) {
        return new ArabicNumber(value - ((ArabicNumber)number).value);
    }

    @Override
    public Number multi(Number number) {
        return new ArabicNumber(value * ((ArabicNumber)number).value);
    }

    @Override
    public Number div(Number number) {
        return new ArabicNumber(value / ((ArabicNumber)number).value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
