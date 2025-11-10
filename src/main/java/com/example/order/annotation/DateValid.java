package com.example.order.annotation;

import com.example.order.validation.DateValidator;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = DateValidator.class)
public @interface DateValid {
    String message() default "";
}
