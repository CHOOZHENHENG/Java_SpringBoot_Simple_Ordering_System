package com.example.order.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class GenderTest {
    @Test
    void GenderTest(){
        Assertions.assertEquals("MALE", Gender.MALE.name());
    }
}