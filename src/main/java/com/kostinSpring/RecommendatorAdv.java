package com.kostinSpring;

@Singleton
public class RecommendatorAdv implements Recommendator {

    @InjectProperty("textForAdv")
    private String advText;
    @InjectProperty
    private String Motivation;

    public RecommendatorAdv() {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("This is advers for you.");
        System.out.println(advText);
        System.out.println(Motivation);
    }
}
