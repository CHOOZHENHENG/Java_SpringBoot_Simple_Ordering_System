package com.example.order.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class NotBlankValidatorTest {

    @Mock
    NotBlankValidator notBlankValidator;

    @BeforeEach
    public void setUp(){
        this.notBlankValidator = new NotBlankValidator();
    }

    @Test
    public void testNotNull() {
        Assertions.assertFalse(this.notBlankValidator.isValid(""));
        Assertions.assertFalse(this.notBlankValidator.isValid(" "));
        Assertions.assertTrue(this.notBlankValidator.isValid("Valid"));
    }
}