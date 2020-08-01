package com.kostinSpring;

import com.kostinSpring.Configs.ObjectFactory;

@Singleton
public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    public ConsoleAnnouncer() {
    }

    @Override
    public void announceToAll(String s) {
        System.out.println(s);
        recommendator.recommend();
    }
}
