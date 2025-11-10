package com.example.order.validation;

public class IdValidator implements Validator {

    @Override
    public boolean isValid(Object id){
        String idnumber = (String)id;
        int length = idnumber.length();
        return length == 9 || length == 12;
    }
}
