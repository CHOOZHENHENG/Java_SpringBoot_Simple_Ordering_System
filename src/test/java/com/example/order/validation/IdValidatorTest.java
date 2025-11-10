package com.example.order.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class IdValidatorTest {

    @Mock
    IdValidator IdValidator;

    @BeforeEach
    public void setUp(){
        this.IdValidator = new IdValidator();
    }

    @Test
    public void testValidLength(){
        Assertions.assertTrue(this.IdValidator.isValid("123456789"));
        Assertions.assertTrue(this.IdValidator.isValid("123456789012"));
    }

    @Test
    public void testInvalidLength() {
        Assertions.assertFalse(this.IdValidator.isValid("123"));
        Assertions.assertFalse(this.IdValidator.isValid("12345678"));
        Assertions.assertFalse(this.IdValidator.isValid("1234567890123"));
    }

}