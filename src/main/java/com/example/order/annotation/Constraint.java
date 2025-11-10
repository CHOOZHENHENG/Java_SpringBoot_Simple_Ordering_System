package com.example.order.annotation;

import com.example.order.validation.Validator;
import java.lang.annotation.*;

@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {
    Class<? extends Validator> validateBy();
}