package com.example.order.validation;

import com.example.order.constant.Regex;

public class EmailValidator implements Validator {

    @Override
    public boolean isValid(Object email) {
        return Regex.EmailValid(email);
    }
}
