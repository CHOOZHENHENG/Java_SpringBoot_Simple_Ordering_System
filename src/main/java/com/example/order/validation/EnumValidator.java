package com.example.order.validation;

import com.example.order.annotation.EnumValid;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j
public class EnumValidator implements Validator {

    private EnumValid annotation;

    @Override
    public void initialize(Annotation annotation){
        this.annotation = (EnumValid) annotation;
    }

    @Override
    public boolean isValid(Object var1){
        Class<?> target = annotation.target();

        if(target.isEnum()){
            Object[] enumConstans = target.getEnumConstants();

            try{
                Method method = target.getMethod("name");
                for(Object obj: enumConstans){
                    Object code = method.invoke(obj);
                    if(var1.toString().equals(code.toString())){
                        return true;
                    }
                }
            }catch (Exception e){
                log.warn("input data error, data value is {}", var1);
            }
        }
        return false;
    }
}
