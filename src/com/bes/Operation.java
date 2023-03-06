package com.bes;

enum Operation{
    ADD('+'),
    SUB('-'),
    MULTI('*'),
    DIV('/'),
    UNKNOWN(' ');

    private final char value;
    public char getValue(){
        return value;
    }

    Operation(char c) {
        value = c;
    }
}