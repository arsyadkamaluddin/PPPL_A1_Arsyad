package org.example;

public class Money {
    private String type;
    private int value;
    public Money(int value) {
        this.value = value;
        if (value < 1000){
            this.type = "koin";
        }else {
            this.type = "kertas";
        }
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
