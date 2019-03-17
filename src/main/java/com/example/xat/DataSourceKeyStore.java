package com.example.xat;

import org.springframework.stereotype.Component;

@Component
public class DataSourceKeyStore {
    private final ThreadLocal<String> store = new ThreadLocal<>();

    public void set(String key) {
        this.store.set(key);
    }

    public String get() {
        return this.store.get();
    }

    public void clear() {
        this.store.remove();
    }
}
