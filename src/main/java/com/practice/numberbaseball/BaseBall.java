package com.practice.numberbaseball;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BaseBall {
    String number;
    int strike;
    int ball;

    public BaseBall(String number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}
