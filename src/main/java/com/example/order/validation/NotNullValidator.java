package com.example.order.validation;

public class NotNullValidator implements Validator {

    @Override
    public boolean isValid(Object var1) {
        return var1 != null;
    }
}
