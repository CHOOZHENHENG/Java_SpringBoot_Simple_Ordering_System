package com.example.order.validation;

import java.lang.annotation.Annotation;

public interface Validator {
    default void initialize(Annotation annotation) {}

    boolean isValid(Object var1);
}
