package com.kostinSpring;

import javax.annotation.PostConstruct;

public class ConsolePoliceman implements Policeman {

    @InjectByType
    Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makeAllPeopleLeaveFromRoom(String s) {
        System.out.println(s);
    }
}
