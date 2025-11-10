package com.example.order.service;

import com.example.order.Result;
import com.example.order.cache.CustomerCache;
import com.example.order.exception.ServerErrorException;
import com.example.order.form.customerInfo.Customer;
import com.example.order.validation.BeanValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerCache customerCache;

    private MockedStatic<BeanValidator> beanValidator;

    @BeforeEach
    public void setUp(){
        this.beanValidator = Mockito.mockStatic(BeanValidator.class);
    }

    @AfterEach
    public void tearDown(){
        this.beanValidator.close();
    }

    @Test
    void getAllCust() {
        String idOne = "cus7c926fb4-1148-4438-9dec-03faa3dfecfa810882495967100";
        Object oneRecord = new Object();
        Mockito.when(this.customerCache.getCache(idOne)).thenReturn(oneRecord);
        Object oneResult = this.customerService.getCustById("cus7c926fb4-1148-4438-9dec-03faa3dfecfa810882495967100");
        Assertions.assertNotNull(oneResult);
        Assertions.assertEquals(Result.success(oneRecord), oneResult);
        String id = "user123";
        Mockito.when(this.customerCache.getCache(id)).thenReturn((Object) null);
        Object result = this.customerService.getCustById(id);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("[]", result);
    }

    @Test
    void createCust() {
        Customer customerTestDate = new Customer();
        customerTestDate.setId("1");
        Assertions.assertDoesNotThrow(()-> {
            return this.customerService.createCust(customerTestDate);
        });
    }

    @Test
    void deleteCustById() {
        String idOne = "cus7c926fb4-1148-4438-9dec-03faa3dfecfa810882495967100";
        Object deleteCustData = new Object();
        Mockito.when(this.customerCache.getCache(idOne)).thenReturn(deleteCustData);
        Assertions.assertNotNull(this.customerService.deleteCustById("cus7c926fb4-1148-4438-9dec-03faa3dfecfa810882495967100"));

        String id = "user123";
        Mockito.when(this.customerCache.getCache(id)).thenReturn((Object) null);
        Exception exception = (Exception)Assertions.assertThrows(ServerErrorException.class, ()->{
            this.customerService.deleteCustById(id);
        });
        Assertions.assertNotNull(exception);
    }
}