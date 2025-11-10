package com.example.order.controller;

import com.example.order.service.CustomerService;
import com.example.order.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class RestfulControllerTest {

    @InjectMocks
    RestfulController restfulController;

    @Mock
    TransactionService transactionService;

    @Mock
    CustomerService customerService;

    RestfulControllerTest(){}

    @BeforeEach
    void setup(){
        this.restfulController = new RestfulController();
    }
    
    @Test
    void testGetAllCustomer(){
        Assertions.assertNotNull(this.restfulController.getAllCustomer());
    }
}