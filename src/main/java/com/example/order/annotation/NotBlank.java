package com.example.order.annotation;

import com.example.order.validation.NotBlankValidator;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = NotBlankValidator.class)
public @interface NotBlank {
    String message() default "BlankTest";
}
