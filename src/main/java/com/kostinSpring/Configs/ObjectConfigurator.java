package com.kostinSpring.Configs;

/**
 * In Spring is BeanPostProsessor
 */

public interface ObjectConfigurator {
    public void configure(Object object, ApplicationContext context);
}
