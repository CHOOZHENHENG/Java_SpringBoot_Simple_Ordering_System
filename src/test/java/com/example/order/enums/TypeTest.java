package com.example.order.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class TypeTest {
    @Test
    void TypeTest(){
        Assertions.assertEquals("PHONE", Type.PHONE.name());
        Assertions.assertEquals("EMAIL", Type.EMAIL.name());
    }
}