package com.huaxiti.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;

public class StreamDemo {

    @Data
    @AllArgsConstructor
    public static class Calender1{
        private LocalDate date;
        private boolean today;
        private boolean signed;
    }

    public static void main(String[] args) {
        List<Boolean> booleanList = Arrays.asList(true, false, true);
        boolean b = booleanList.stream().anyMatch(t -> t);
        boolean c = booleanList.stream().noneMatch(t -> t);
        boolean d = booleanList.stream().allMatch(t -> t);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        List<Integer> IntegerList = Arrays.asList(3, 4, 5);
        boolean b1 = IntegerList.stream().anyMatch(t -> t > 1);
        System.out.println(b1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Thread.sleep(2000);
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });

        }
        executorService.shutdown();

    }
}
