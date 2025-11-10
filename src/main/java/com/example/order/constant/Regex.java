package com.example.order.constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean EmailValid(Object email) {
        pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,}$");
        matcher = pattern.matcher(email.toString());
        return matcher.matches();
    }

    public static boolean DateValid(Object date) {
        pattern = Pattern.compile("^(19|20)\\d{2}/(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])$");
        matcher = pattern.matcher(date.toString());
        return matcher.matches();
    }
}
