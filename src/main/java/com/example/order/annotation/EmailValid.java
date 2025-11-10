package com.example.order.annotation;

import com.example.order.validation.EmailValidator;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = EmailValidator.class)
public @interface EmailValid {
    String message() default "";
}
