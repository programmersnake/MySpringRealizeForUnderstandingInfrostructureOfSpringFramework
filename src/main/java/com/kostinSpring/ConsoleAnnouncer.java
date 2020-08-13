package com.kostinSpring;

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
