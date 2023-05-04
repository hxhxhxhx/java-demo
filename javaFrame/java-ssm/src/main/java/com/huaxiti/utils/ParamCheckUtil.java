package com.huaxiti.utils;

import org.springframework.util.StringUtils;

import java.util.Collection;

public class ParamCheckUtil {

    public static void paramIfEmpty(String param, String message){
        if (StringUtils.isEmpty(param)){
            throw new NullPointerException(message);
        }
    }

    public static void paramIfEmpty(Collection<?> param, String message){
        if (param == null || param.size() == 0){
            throw new NullPointerException(message);
        }
    }

    public static void paramIfEmpty(Object param, String message){
        if (param == null){
            throw new NullPointerException(message);
        }
    }
}
