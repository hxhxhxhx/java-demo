package com.huaxiti.exception;

public class FatherDemo {

    private String name;

    public void method(){
        System.out.println("father method ...");
        throw new ArrayIndexOutOfBoundsException();
    }
}
