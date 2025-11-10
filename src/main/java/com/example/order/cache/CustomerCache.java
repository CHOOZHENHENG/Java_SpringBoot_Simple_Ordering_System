package com.example.order.cache;

import com.example.order.form.customerInfo.Customer;
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

import static com.example.order.constant.Inventory.CUSTOMER_JSON;

@Component
@Slf4j
public class CustomerCache implements Cache{
    //TODO Please fix create Customer type first for fixing the error calling from the json file
    /* this project not using mapper to get data from database, treat json as your main data storage and call cache*/

    private static final Map<String, Customer> CUSTOMER_CACHE = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Customer> customers = objectMapper.readValue(new File(CUSTOMER_JSON), new TypeReference<>(){});

        for(Customer cus : customers){
            CUSTOMER_CACHE.put(cus.getId(), cus);
            log.info("Customer cache load:{}", cus);
        }

        //Initialization logic, e.g., loading configuration, setting up resources, etc.
        log.info("Customer cache initialized");
    }

    @Override
    public void saveCache(Object data){
        if(data instanceof Customer cus){
            CUSTOMER_CACHE.put(cus.getId(), cus);
        }
    }

    @Override
    public Object getCache(String key){
        return CUSTOMER_CACHE.get(key);
    }

    @Override
    public void deleteCache(String key){CUSTOMER_CACHE.remove(key);}

    @Override
    public List<?> getAllCache(){
        return List.of(CUSTOMER_CACHE.values());//create immutable lists
    }

    @Scheduled(fixedRate = 1L, timeUnit = TimeUnit.SECONDS)
    private void UpdateData() throws IOException{
        FileUtils.jsonFileWriter(CUSTOMER_JSON, new ArrayList<>(CUSTOMER_CACHE.values()));
    }
}
