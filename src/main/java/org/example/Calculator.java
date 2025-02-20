package org.example;

public class Calculator {
    int a,b;
    public Calculator(int a,int b){
        this.a = a;
        this.b = b;
    }

    public int add(){
        return a+b;
    }
    public int substract(){
        return a-b;
    }
    public int multiple(){
        return a*b;
    }

    public int divide(){
        return a/b;
    }
}
