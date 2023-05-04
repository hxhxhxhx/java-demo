package com.huaxiti.随机数组;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class demo {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list);
        System.out.println(randomList(list));

    }

    private static List<String> randomList(List<String> originalGroup) {
        List<String> list = new ArrayList<>(originalGroup);
        for (int i = list.size() - 1; i > 0; i--)
        {
            //随机数生成器，范围[0, i]
            int rand = (new Random()).nextInt(i+1);

            String temp = list.get(i);
            list.set(i, list.get(rand));
            list.set(rand, temp);
        }
        return list;
    }

    public static List<String> random(List<String> originalGroup, Integer randomNumber) throws Exception {
        if(originalGroup == null) {
            throw new Exception("随机池不能为空");
        }
        if(randomNumber == null) {
            throw new Exception("随机人数不能为空");
        }
        if (randomNumber < 1) {
            throw new Exception("随机人数不能为非正数");
        }
        if (randomNumber > originalGroup.size()) {
            throw new Exception("随机人数不能大于范围人数");
        }

        List<String> resultGroup = randomList(originalGroup).subList(0,randomNumber);
        if (resultGroup.size() != randomNumber) {
//            log.error("随机结果数量与随机人数不匹配:\noriginalGroup={},randomNumber={},resultGroup={}",originalGroup,randomNumber,resultGroup);
            throw new Exception("随机结果数量与随机人数不匹配");
        }

        return resultGroup;
    }
}
