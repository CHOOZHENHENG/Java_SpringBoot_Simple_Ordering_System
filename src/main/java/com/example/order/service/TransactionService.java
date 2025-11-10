package com.example.order.service;

import com.example.order.Result;
import com.example.order.cache.TransactionCache;
import com.example.order.constant.Inventory;
import com.example.order.enums.Status;
import com.example.order.exception.ServerErrorException;
import com.example.order.form.transaction.Order;
import com.example.order.form.transaction.RequestStatus;
import com.example.order.form.transaction.Transaction;
import com.example.order.utils.SystemUtils;
import com.example.order.validation.BeanValidator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionCache transactionCache;

    public List<?> getAllTran() {
        return transactionCache.getAllCache();
    }

    public Object createOrder(Order order) {
        String trxRefId = SystemUtils.generateID(order);
        LocalDateTime localDateTime = LocalDateTime.now();
        RequestStatus rs = new RequestStatus(Status.SUBMITTED.name(), Status.SUBMITTED.getStatusDesc(),
                "Please process quickly");
        Transaction data = new Transaction(order, trxRefId, rs.getStatus(), rs.getStatusDesc(),
                rs.getRemarks(), localDateTime.format(Inventory.FORMATTER), localDateTime.format(Inventory.FORMATTER));
        BeanValidator.validateWithException(data);
        transactionCache.saveCache(data);
        return Result.success(data);
    }

    public Object updateOrderStatus(String trxRefId, RequestStatus rs) {
        Transaction record = (Transaction) transactionCache.getCache(trxRefId);
        if(record != null) {
            LocalDateTime localDateTime = LocalDateTime.now();
            record.setStatus(rs.getStatus());
            record.setStatusDesc(rs.getStatusDesc());
            record.setRemarks(rs.getRemarks());
            record.setLastUpdated(localDateTime.format(Inventory.FORMATTER));
            BeanValidator.validateWithException(record);
            transactionCache.saveCache(record);
            return Result.success(record);
        }
        else throw new ServerErrorException();
    }
}
