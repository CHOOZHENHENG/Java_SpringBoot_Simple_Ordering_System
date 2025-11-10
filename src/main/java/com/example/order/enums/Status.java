package com.example.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    SUBMITTED("Order has been submitted"),
    IN_PROGRESS("Order is in progress"),
    CANCELLED("Order has been cancelled"),
    EXCEPTION("Order has been excepted"),
    COMPLETED("Order is completed");

    private final String statusDesc;
}
