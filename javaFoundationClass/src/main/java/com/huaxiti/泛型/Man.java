package com.huaxiti.泛型;

import org.junit.Test;

public class Man extends People<Dog>{

    @Test
    public void test(){
        System.out.println(this.getType());
    }
}
