package com.kostinSpring.Configs;

import com.kostinSpring.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotentionObjectConfigurator implements ObjectConfigurator {

    private Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotentionObjectConfigurator() {
        String pathToApplicationProperties = ClassLoader.getSystemResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(pathToApplicationProperties)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

    }

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        Arrays.stream(implClass.getDeclaredFields()).forEach(field -> {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if(annotation!=null) {
                String value = propertiesMap.get(annotation.value().isEmpty() ? field.getName() : annotation.value());
                field.setAccessible(true);
                try{
                    field.set(t, value);
                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }
}
