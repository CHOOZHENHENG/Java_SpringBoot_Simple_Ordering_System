package com.example.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(200, ""),
    ERROR_500(500, "Internal server error"),
    ERROR_501(501, "Error in loading data to JSON File");

    private final int code;
    private final String message;
}
