package com.huaxiti.保留n位小数;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {

        double f = 6;

        //四舍五入，返回值为String，如果为结果整数也能返回两位小数，例：6 -> 6.00
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));

        //四舍五入，返回值为String，如果为结果整数也能返回两位小数，例：6 -> 6.00
        String format = String.format("%.2f", f);
        String format1 = String.format("%.0f", f);
        System.out.println(format);
        System.out.println(format1);

        //四舍五入，返回值为double，如果结果为整数只能返回一位小数，例：6 -> 6.0
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
        ArrayList<Object> objects = new ArrayList<>();
    }
}
