package com.example.order.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderCodeTest {

    @Test
    void OrderCodeTest(){
        Assertions.assertEquals("A1", OrderCode.A1.name());
        Assertions.assertEquals("A2", OrderCode.A2.name());
        Assertions.assertEquals("A3", OrderCode.A3.name());
    }
}