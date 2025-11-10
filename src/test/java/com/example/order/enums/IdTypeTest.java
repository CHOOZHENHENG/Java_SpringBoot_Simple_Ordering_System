package com.example.order.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class IdTypeTest {

    @Test
    void IdTypeTest(){
        Assertions.assertEquals("NEWNRIC", IdType.NEWNRIC.name());
        Assertions.assertEquals("PASSPORT", IdType.PASSPORT.name());
    }
}