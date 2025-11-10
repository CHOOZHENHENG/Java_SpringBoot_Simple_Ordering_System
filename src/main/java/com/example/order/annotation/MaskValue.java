package com.example.order.annotation;

import com.example.order.security.MaskValueSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.annotation.*;

@JacksonAnnotationsInside
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = MaskValueSerializer.class)
public @interface MaskValue {
    String message() default "";
}
