package com.example.order.constant;

import java.time.format.DateTimeFormatter;

public class Inventory {
    public final static String  CUSTOMER_JSON = "data/customer.json";
    public final static String  TRANSACTION_JSON = "data/transactions.json";
    public final static String  DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
}
