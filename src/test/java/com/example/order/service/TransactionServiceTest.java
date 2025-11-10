package com.example.order.service;

import com.example.order.Result;
import com.example.order.cache.TransactionCache;
import com.example.order.constant.Inventory;
import com.example.order.enums.Status;
import com.example.order.form.transaction.Order;
import com.example.order.form.transaction.RequestStatus;
import com.example.order.form.transaction.Transaction;
import com.example.order.utils.SystemUtils;
import com.example.order.validation.BeanValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    TransactionCache transactionCache;

    @Mock
    SystemUtils systemUtils;

    @Test
    void getAllTran() {
        Assertions.assertDoesNotThrow(()->{
            return this.transactionService.getAllTran();
        });
    }

    @Test
    void createOrder() {
        Order order = new Order("A1", 1);
        String trxRfId = "transe8dbee7e-f3d7-48fd-b904-1450d3c443f3444376884796416";
        LocalDateTime localDateTime = LocalDateTime.now();
        RequestStatus rs = new RequestStatus(Status.SUBMITTED.name(), Status.SUBMITTED.getStatusDesc(), "Please process quickly");
        Transaction data = new Transaction(order, trxRfId, rs.getStatus().toString(), rs.getStatusDesc(),
                rs.getRemarks(), localDateTime.format(Inventory.FORMATTER), localDateTime.format(Inventory.FORMATTER));
        BeanValidator.validateWithException(data);
        this.transactionCache.saveCache(data);
        Object result = this.transactionService.createOrder(order);
        Assertions.assertNotNull(Result.success(data));
        Assertions.assertNotNull(result);
    }

    @Test
    void updateOrderStatus() {
        String trxRefId = "trx123";
        RequestStatus rs = new RequestStatus(Status.COMPLETED.name(), Status.COMPLETED.getStatusDesc(),
                "Please process quickly");
        Transaction record = new Transaction(new Order("A1", 0), "trx123", Status.COMPLETED.name(), rs.getStatusDesc(), rs.getRemarks(), LocalDateTime.now().format(Inventory.FORMATTER), LocalDateTime.now().format(Inventory.FORMATTER));
        Mockito.when(this.transactionCache.getCache(trxRefId)).thenReturn(record);
        Object result = this.transactionService.updateOrderStatus(trxRefId,rs);
        Assertions.assertNotNull(result);
    }
}