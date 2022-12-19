package com.huaxiti.kafka;

import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
//        runTest(new Cat());
        runTest(new Dog());
    }

    public static void runTest(Animal animal){
        animal.running();
        if (animal instanceof Cat) {
            Cat c = (Cat) animal;
            c.running();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        List<String> strings = list.subList(0, 3);
        System.out.println(strings);
        double f = 6.11;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
        String round = String.valueOf(Math.round(3.00 * 100) / 100);
        System.out.println(round);



    }

}
