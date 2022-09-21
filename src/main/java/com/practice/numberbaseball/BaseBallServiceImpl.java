package com.practice.numberbaseball;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BaseBallServiceImpl implements BaseBallService{
    @Override
    public int play(List<BaseBall> inputs) {
        int answer = 0;
        for (int number = 123; number <= 987; number++) {
            if (hasSameOrZeroNum(number)) {
                continue;
            }

            int allCasePass = 0;
            for (BaseBall baseBallData : inputs) {
                final String source = baseBallData.number;
                final String target = String.valueOf(number);
                final int strike = countStrike(source, target);
                final int ball = countBall(source, target);
                if (strike == baseBallData.strike && ball == baseBallData.ball) {
                    allCasePass++;
                } else {
                    break;
                }
            }

            if (allCasePass == inputs.size()) {
                answer++;
            }

        }
        return answer;
    }
    private boolean hasSameOrZeroNum(int number){
        String sNum = String.valueOf(number);
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < sNum.length(); i++){
            chars.add(sNum.charAt(i));
        }
        return chars.contains('0') || chars.size() != 3;
    }

    private int countStrike(String source, String target){
        int strike = 0;
        for (int i = 0; i < 3; i++){
            if(source.charAt(i) == target.charAt(i)){
                strike++;
            }
        }
        return strike;
    }

    private int countBall(String source, String target){
        int ball = 0;
        for (int i = 0; i < 3; i++){
            if(source.charAt(i) == target.charAt((i+1) % 3) || source.charAt(i) == target.charAt((i+2) % 3)) {
                ball++;
            }
        }
        return ball;
    }








}
