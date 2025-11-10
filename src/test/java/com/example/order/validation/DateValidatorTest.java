package com.example.order.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class DateValidatorTest {
    @Mock
    private DateValidator dateValidator;

    @BeforeEach
    public void setUp() { this.dateValidator = new DateValidator(); }

    @Test
    public void testDateValid(){
        Assertions.assertTrue(this.dateValidator.isValid("2023/01/01"));
        Assertions.assertTrue(this.dateValidator.isValid("2023/12/31"));
    }

    @Test
    public void testInvalidDates() {
        Assertions.assertFalse(this.dateValidator.isValid("2023/08/81"));
        Assertions.assertFalse(this.dateValidator.isValid("2023/13/31"));
        Assertions.assertFalse(this.dateValidator.isValid("2023/01/32"));
        Assertions.assertFalse(this.dateValidator.isValid("2023/13/32"));
    }
}