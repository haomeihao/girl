package com.imooc.girl.core.java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by hmh on 2017/8/1.
 */
public class Java8Test5 {
    public static void main(String args[]) {
        Java8Test5 java8tester = new Java8Test5();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime() {

        // Get the current date and time
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
    }
}
