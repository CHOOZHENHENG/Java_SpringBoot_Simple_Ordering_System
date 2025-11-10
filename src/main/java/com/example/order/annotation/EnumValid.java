package com.example.order.annotation;

import com.example.order.validation.EnumValidator;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = EnumValidator.class)
public @interface EnumValid {
    String message() default "";
    Class<?> target() default Class.class;
}
