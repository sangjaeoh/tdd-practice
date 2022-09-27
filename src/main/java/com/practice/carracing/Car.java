package com.practice.carracing;

public class Car {

    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int FORWARD_CRITERIA = 4;
    private final String name;
    private int position = 0;
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void run() {
        int randomValue = RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomValue >= FORWARD_CRITERIA) {
            position++;
        }
    }

}
