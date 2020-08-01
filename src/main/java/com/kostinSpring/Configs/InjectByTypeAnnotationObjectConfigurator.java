package com.kostinSpring.Configs;

import com.kostinSpring.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object object, ApplicationContext context) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object creatingObject = context.getObject(field.getType());
                field.set(object, creatingObject);
            }
        }
    }
}
