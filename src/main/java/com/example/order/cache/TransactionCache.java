package com.example.order.cache;

import com.example.order.form.transaction.Transaction;
import com.example.order.utils.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static com.example.order.constant.Inventory.TRANSACTION_JSON;

@Component
@Slf4j
public class TransactionCache implements Cache {
    //TODO Please fix create Customer type first for fixing the error calling from the json file
    /* this projec not using mapper to get data from database, treat json as your main data storage and call cache*/

    private static final Map<String, Transaction> TRANS_CACHE = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Transaction> transaction = objectMapper.readValue(new File(TRANSACTION_JSON), new TypeReference<>(){});

        for(Transaction trans : transaction){
            TRANS_CACHE.put(trans.getTrxRefId(), trans);
            log.info("Transaction cache load:{}", trans);
        }

        //Initialization logic, e.g., loading configuration, setting up resources, etc.
        log.info("Transaction cache initialized");
    }

    @Override
    public void saveCache(Object data){
        if(data instanceof Transaction trans){
            TRANS_CACHE.put(trans.getTrxRefId(), trans);
        }
    }

    @Override
    public Object getCache(String key){
        return TRANS_CACHE.get(key);
    }

    @Override
    public void deleteCache(String key){TRANS_CACHE.remove(key);}

    @Override
    public List<?> getAllCache(){
        return List.of(TRANS_CACHE.values());//create immutable lists
    }

    @Scheduled(fixedRate = 1L, timeUnit = TimeUnit.SECONDS)
    private void UpdateData() throws IOException{
        FileUtils.jsonFileWriter(TRANSACTION_JSON, new ArrayList<>(TRANS_CACHE.values()));
    }
}
