package com.example.order.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class NotNullValidatorTest {

    @Mock
    NotNullValidator notNullValidator;

    @BeforeEach
    public void setUp(){
        this.notNullValidator = new NotNullValidator();
    }

    @Test
    public void testNotNull() {
        Assertions.assertFalse(this.notNullValidator.isValid((Object) null));
        Assertions.assertTrue(this.notNullValidator.isValid("Test"));
    }
}