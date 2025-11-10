package com.example.order.validation;

public class NotBlankValidator implements Validator {

    @Override
    public boolean isValid(Object var1) {
        return var1 != "" && !var1.equals(" ");
    }
}
