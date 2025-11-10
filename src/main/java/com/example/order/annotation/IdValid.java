package com.example.order.annotation;

import com.example.order.validation.EmailValidator;
import com.example.order.validation.IdValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = IdValidator.class)
public @interface IdValid {
    String message() default "";
}
