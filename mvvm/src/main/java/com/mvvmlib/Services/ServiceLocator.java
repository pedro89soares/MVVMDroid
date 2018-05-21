package com.mvvmlib.Services;

import com.mvvmlib.Services.Interfaces.IService;

import java.util.HashMap;

public class ServiceLocator {


    private static ServiceLocator instance;
    private HashMap<Class, IService> services;

    public static ServiceLocator getInstance() {
        if (instance == null)
            instance = new ServiceLocator();

        return instance;
    }

    private ServiceLocator() {
        services = new HashMap<>();
    }

    public <T extends IService> T getService(Class<T> serviceKey) {
        if (services.containsKey(serviceKey)) {
            IService serviceClass = services.get(serviceKey);
            if (serviceClass != null)
                return (T) serviceClass;
            else {
                try {
                    T instance = serviceKey.newInstance();
                    if (instance != null) {
                        services.put(serviceKey, instance);
                        return instance;
                    }
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public <T extends IService>void registerService(Class<T> interfaceClass, Class serviceClass) {
        if(!interfaceClass.isAssignableFrom(serviceClass)) return;
        try {
            Object inst = serviceClass.newInstance();
            if (inst != null)
                services.put(interfaceClass, (IService) inst);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
