package com.huaxiti.stream流;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class demo {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        IntStream ints = random.ints(1000,0,1000);
        IntStream ints1 = random.ints(1000,0,1000);
//        stream1(ints);
//        Thread.sleep(1000);
//        stream2(ints1);
        long t1 = System.currentTimeMillis();
        ints.peek(m ->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).forEach(System.out::println);
        long t2 = System.currentTimeMillis();

//        Thread.sleep(1000);
        long t3 = System.currentTimeMillis();
        ints1.parallel().peek(m ->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).forEach(System.out::println);
        long t4 = System.currentTimeMillis();
        /**
         * 串行流耗时：107896
         * 并行流耗时：6942
         */
        System.out.println("串行流耗时："+(t2-t1));
        System.out.println("并行流耗时："+(t4-t3));
    }

    public static void stream1(IntStream ints){
        long t1 = System.currentTimeMillis();
        ints.forEach(System.out::println);
        long t2 = System.currentTimeMillis();
        System.out.println("串行流耗时："+(t2-t1));
    }

    public static void stream2(IntStream ints){
        long t3 = System.currentTimeMillis();
        ints.parallel().forEach(System.out::println);
        long t4 = System.currentTimeMillis();
        System.out.println("并行流耗时："+(t4-t3));
    }
}
