package com.imooc.girl.web.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by hmh on 2017/10/10.
 */
public class DateUtil {

    public static void main(String[] args) {
        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date);
    }
}
