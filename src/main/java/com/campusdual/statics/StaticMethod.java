package com.campusdual.statics;

import java.util.Calendar;
import java.util.Date;

public class StaticMethod {

    public static String countDownToYear(String name, int year){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1, 0, 0, 0);
        Date targetDate = calendar.getTime();
        long millis = targetDate.getTime() - today.getTime();
        long days = millis / (1000 * 60 * 60 * 24);
        if (days > 0) {
            return "Hi " + name + "!, countdown to " + year + ": " + days + " days.";
        } else{
            return "Hi " + name + "!, days from year " + year + ": " + Math.abs(days) + "days.";
        }

    }
}
