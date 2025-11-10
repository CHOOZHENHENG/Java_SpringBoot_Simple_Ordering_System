package com.example.order.utils;

import com.example.order.form.customerInfo.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class SystemUtilsTest {

    SystemUtilsTest() {

    }

    @Test
    public void testGenerateIDForCustomer() {
        SystemUtils systemUtils = new SystemUtils();
        Customer customer = new Customer();
        String id = systemUtils.generateID(customer);
        Assertions.assertTrue(id.startsWith("cus"));
        Assertions.assertEquals(54, id.length());
    }

    @Test
    public void testGenerateIDForNonCustomer() {
        Object nonCustomer = new Object();
        SystemUtils systemUtils = new SystemUtils();
        String id = systemUtils.generateID(nonCustomer);
        Assertions.assertTrue(id.startsWith("trans"));
        Assertions.assertEquals(56, id.length());
    }
}