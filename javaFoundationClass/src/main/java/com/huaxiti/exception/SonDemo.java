package com.huaxiti.exception;

public class SonDemo extends FatherDemo{

    @Override
    public void method() throws NullPointerException{
        System.out.println("son method ...");
        throw new NullPointerException();

    }
}
