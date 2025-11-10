package com.example.order.cache;

import java.util.List;

public interface Cache {
    void saveCache(Object data);
    Object getCache(String key);
    void deleteCache(String key);
    List<?> getAllCache();
}
