package com.example.order.controller;

import com.example.order.form.customerInfo.Customer;
import com.example.order.form.transaction.Order;
import com.example.order.form.transaction.RequestStatus;
import com.example.order.service.CustomerService;
import com.example.order.service.TransactionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestfulController {
    @Resource
    private TransactionService transactionService;

    @Resource
    private CustomerService customerService;

    //Customer
    @GetMapping(path = "/allUser")
    protected Object getAllCustomer() {
        return customerService.getAllCust();
    }

    @GetMapping(path = "{customerId}/user")
    private Object getCustomerById(@PathVariable String customerId) {
        return customerService.getCustById(customerId);
    }

    @PostMapping(path = "/register")
    private Object createCustomer(@RequestBody Customer customer) {
        return customerService.createCust(customer);
    }

    @DeleteMapping(path = "/delete/{customerId}/user")
    private Object deleteCustomerById(@PathVariable String customerId) {
        return customerService.deleteCustById(customerId);
    }

    //Transaction
    @GetMapping(path = "/allTrans")
    private List<?> getAllTransaction(){
        return transactionService.getAllTran();
    }

    @PostMapping(path = "/order")
    public Object createAnOrder(@RequestBody Order order) {
        return transactionService.createOrder(order);
    }

    @PutMapping(path = "/order/{trxRefId}/status")
    public Object updateAnOrderStatus(@PathVariable String trxRefId, @RequestBody RequestStatus requestStatus) {
        return transactionService.updateOrderStatus(trxRefId, requestStatus);
    }
}
