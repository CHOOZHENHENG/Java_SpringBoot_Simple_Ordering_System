package com.example.order.service;

import com.example.order.Result;
import com.example.order.cache.CustomerCache;
import com.example.order.exception.ServerErrorException;
import com.example.order.form.customerInfo.Customer;
import com.example.order.utils.SystemUtils;
import com.example.order.validation.BeanValidator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Resource
    private CustomerCache customerCache;

    public Object getAllCust() {
        return Result.success(customerCache.getAllCache());
    }

    public Object getCustById(String customerId) {
        Object oneRecord = customerCache.getCache(customerId);
        if (oneRecord != null) {
            return Result.success(oneRecord);
        }
        else return "[]";
    }

    public Object createCust(Customer customer) {
        String id = SystemUtils.generateID(customer);
        customer.setId(id);
        BeanValidator.validateWithException(customer);
        customerCache.saveCache(customer);
        return Result.success(customerCache.getCache(customer.getId()));
    }

    public Object deleteCustById(String customerId) {
        Object custTobeDeleted = customerCache.getCache(customerId);
        if (custTobeDeleted != null) {
            customerCache.deleteCache(customerId);
            return Result.success();
        }
        else throw new ServerErrorException();
    }
}
