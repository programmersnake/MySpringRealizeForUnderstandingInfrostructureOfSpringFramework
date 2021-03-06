package com.kostinSpring.Configs;

import com.kostinSpring.Singleton;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    private final Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private final Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        Class<? extends T> implClass = type;

        if(cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);

        if(implClass.isAnnotationPresent(Singleton.class)){
            cache.put(type, t);
        }

        return t;
    }
}
