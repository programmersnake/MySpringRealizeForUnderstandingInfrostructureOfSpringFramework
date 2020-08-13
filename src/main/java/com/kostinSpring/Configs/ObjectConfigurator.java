package com.kostinSpring.Configs;

/**
 * In Spring is BeanPostProcessor
 */
public interface ObjectConfigurator {
    void configure(Object object, ApplicationContext context);
}
