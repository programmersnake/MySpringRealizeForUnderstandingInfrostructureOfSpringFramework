package com.kostinSpring.Configs;

import com.kostinSpring.*;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectFactory {

    private static ObjectFactory ourInstance;
    private ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context=context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    /**
     * Method, which help Your Infrastructure Create needed you Obj
     * @param implClass
     * @param <T>
     * @return Object that you need
     */
    @SneakyThrows
    public <T> T createObject (Class<T> implClass) {
        T t = create(implClass);

        configure(t);

        invokeInitMethod(implClass, t);

        return t;
    }

    private <T> void invokeInitMethod(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t, context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }

}
