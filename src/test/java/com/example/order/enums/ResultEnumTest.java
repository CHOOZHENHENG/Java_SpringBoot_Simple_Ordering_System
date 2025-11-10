package com.example.order.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultEnumTest {

    @Test
    void testSuccessEnumValues() {
        assertEquals(200, ResultEnum.SUCCESS.getCode());
        assertEquals("", ResultEnum.SUCCESS.getMessage());
        assertEquals(500, ResultEnum.ERROR_500.getCode());
        assertEquals("Internal server error", ResultEnum.ERROR_500.getMessage());
        assertEquals(501, ResultEnum.ERROR_501.getCode());
        assertEquals("Error in loading data to JSON File", ResultEnum.ERROR_501.getMessage());
    }
}