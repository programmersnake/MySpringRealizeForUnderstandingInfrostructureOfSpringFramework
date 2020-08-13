package com.kostinSpring;

import com.kostinSpring.Configs.Application;
import com.kostinSpring.Configs.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = Application.run("com.kostinSpring", new HashMap<>(Map.of(Policeman.class, ConsolePoliceman.class, Announcer.class, ConsoleAnnouncer.class)));
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new EatingRoom());
    }

}
