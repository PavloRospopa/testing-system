package com.gmail.at.rospopa.pavlo.testingsystem.application;

import com.gmail.at.rospopa.pavlo.testingsystem.service.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ServiceHolder {
    INSTANCE;

    private ConcurrentMap<String, Service> services = new ConcurrentHashMap<>();

    public <T extends Service> void put(Class<T> clazz, Service o){
        services.put(clazz.getName(), o);
    }

    public <T extends Service> T get(Class<T> clazz){
        return (T) services.get(clazz.getName());
    }

    public <T extends Service> T remove(Class<T> clazz){
        return (T) services.remove(clazz.getName());
    }
}
