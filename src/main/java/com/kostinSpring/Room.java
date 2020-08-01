package com.kostinSpring;

public interface Room {
    String getName();
}

class EatingRoom implements Room {
    private String name = "Eating";

    @Override
    public String getName() {
        return name;
    }

}

class BashRoom implements Room {
    private String name = "Bash";

    @Override
    public String getName() {
        return name;
    }

}