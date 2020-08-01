package com.kostinSpring;

import com.kostinSpring.Configs.ObjectFactory;

/**
 * @author Kostin Denis
 */
public class CoronaDisinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start (Room room) {
        announcer.announceToAll("Will start dezinfect. You need leave this room");
        policeman.makeAllPeopleLeaveFromRoom("All leave this room!!!");
        dezinfect(room);
        announcer.announceToAll("Dezinfect was end. You can return to room " + room.getName());
    }

    private void dezinfect (Room room) {
        System.out.println("Starting dezinfection in " + room.getName() + "room");
    }

}
