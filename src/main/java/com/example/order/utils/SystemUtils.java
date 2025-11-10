package com.example.order.utils;

import com.example.order.form.customerInfo.Customer;

import java.util.Random;
import java.util.UUID;

public class SystemUtils {

    public static String generateID(Object data) {
        UUID uuid = UUID.randomUUID();
        Random randomNum = new Random();
        long randNum = (long) (Math.pow(10, 14) + randomNum.nextLong() % (9 * Math.pow(10, 14)));
        if (data instanceof Customer)
            return "cus" + uuid.toString() + randNum;
        else
            return "trans" + uuid.toString() + randNum;
    }
}
