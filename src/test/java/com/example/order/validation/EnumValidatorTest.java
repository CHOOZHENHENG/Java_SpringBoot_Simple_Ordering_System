package com.example.order.validation;

import com.example.order.annotation.EnumValid;
import com.example.order.cache.TransactionCache;
import com.example.order.enums.IdType;
import com.example.order.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class EnumValidatorTest {

    @InjectMocks
    EnumValidator enumValidator;

    @Mock
    EnumValid annotation;

    @Test
    void initialize() {
        Assertions.assertDoesNotThrow(()->{
            this.enumValidator.initialize(this.annotation);
        });
    }

    @Test
    void ValidEnumTest() {
        Class targetEnum = IdType.class;
        Mockito.when(this.annotation.target()).thenReturn(targetEnum);
        boolean result = this.enumValidator.isValid("PASSPORT");
        Assertions.assertTrue(result);
    }

    @Test
    void InvalidEnumTest() {
        Class targetEnum = IdType.class;
        Mockito.when(this.annotation.target()).thenReturn(targetEnum);
        boolean result = this.enumValidator.isValid("NEWNRICa");
        Assertions.assertFalse(result);
    }

    @Test
    void NonEnumClassTest() {
        Class targetEnum = String.class;
        Mockito.when(this.annotation.target()).thenReturn(targetEnum);
        boolean result = this.enumValidator.isValid("NonEnum");
        Assertions.assertFalse(result);
    }
}