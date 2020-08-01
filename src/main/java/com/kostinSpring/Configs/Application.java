package com.kostinSpring.Configs;

import lombok.NonNull;

import java.util.Map;

/**
 * this Class as class SpringApplication in Spring!
 */
public class Application {

    @NonNull
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }

}
