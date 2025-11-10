package com.example.order.validation;

import com.example.order.constant.Regex;

public class DateValidator implements Validator{

    @Override
    public boolean isValid(Object date){
        return Regex.DateValid(date);
    }
}
