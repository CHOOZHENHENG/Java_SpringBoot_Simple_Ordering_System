package com.example.order.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StatusTest {

    @Test
    void OrderCodeTest(){
        Assertions.assertEquals("SUBMITTED", Status.SUBMITTED.name());
        Assertions.assertEquals("IN_PROGRESS", Status.IN_PROGRESS.name());
        Assertions.assertEquals("CANCELLED", Status.CANCELLED.name());
        Assertions.assertEquals("EXCEPTION", Status.EXCEPTION.name());
        Assertions.assertEquals("COMPLETED", Status.COMPLETED.name());
    }
}