package com.example.order.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class EmailValidatorTest {

    @Mock
    private EmailValidator emailValidator;

    @BeforeEach
    public void setUp(){
        this.emailValidator = new EmailValidator();
    }

    @Test
    public void testInvalidEmail() {
        Assertions.assertTrue(this.emailValidator.isValid("Test.9_%+-@gmail.com"));
        Assertions.assertFalse(this.emailValidator.isValid("test.test@gmailcom"));
        Assertions.assertFalse(this.emailValidator.isValid("test@.com"));
        Assertions.assertFalse(this.emailValidator.isValid("test@example"));
        Assertions.assertFalse(this.emailValidator.isValid("example.com"));
    }
}