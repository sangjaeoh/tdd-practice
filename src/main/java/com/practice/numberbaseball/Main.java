package com.practice.numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void maim(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<BaseBall> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            inputs.add(new BaseBall(
                    stringTokenizer.nextToken(),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())));
        }

        System.out.println(play(inputs));
    }

    private static int play(List<BaseBall> inputs){
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

    private static boolean hasSameOrZeroNum(int number){
        String sNum = String.valueOf(number);
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < sNum.length(); i++){
            chars.add(sNum.charAt(i));
        }
        return chars.contains('0') || chars.size() != 3;
    }

    private static int countStrike(String source, String target){
        int strike = 0;
        for (int i = 0; i < 3; i++){
            if(source.charAt(i) == target.charAt(i)){
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(String source, String target){
        int ball = 0;
        for (int i = 0; i < 3; i++){
            if(source.charAt(i) == target.charAt((i+1) % 3) || source.charAt(i) == target.charAt((i+2) % 3)) {
                ball++;
            }
        }
        return ball;
    }
    static class BaseBall {

        String number;
        int strike;
        int ball;

        public BaseBall(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }

    }




}
