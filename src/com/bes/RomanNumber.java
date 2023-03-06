package com.bes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}

class RomanNumber extends Number{
    int value;

    public RomanNumber(String number) throws Exception {
        value = parse(number);
    }

    public RomanNumber(int number) throws Exception {
        value = number;
    }

    private int parse(String number) throws Exception {
        String romanNumeral = number.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(number + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    private String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    @Override
    public Number add(Number number) throws Exception {
        return new RomanNumber(value + ((RomanNumber)number).value);
    }

    @Override
    public Number sub(Number number) throws Exception {
        return new RomanNumber(value - ((RomanNumber)number).value);
    }

    @Override
    public Number multi(Number number) throws Exception {
        return new RomanNumber(value * ((RomanNumber)number).value);
    }

    @Override
    public Number div(Number number) throws Exception {
        return new RomanNumber(value / ((RomanNumber)number).value);
    }

    @Override
    public String toString() {
        return arabicToRoman(value);
    }
}

