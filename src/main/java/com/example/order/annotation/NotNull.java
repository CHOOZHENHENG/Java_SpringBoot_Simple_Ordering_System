package com.example.order.annotation;

import com.example.order.validation.NotNullValidator;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = NotNullValidator.class)
public @interface NotNull {
    String message() default "NullTest";
}
