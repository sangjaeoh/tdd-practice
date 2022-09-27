package com.practice.carracing;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingController {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ROUND_COUNT = 1;

    private final List<Car> cars = new ArrayList<>();
    private int round;
    private Scanner scanner;

    public CarRacingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(){
        setCars();
    }

    private void setCars(){
        List<String> names = inputNames();
        validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
    }

    private List<String> inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = this.scanner.nextLine();
        List<String> names = Arrays.stream(input.split(",")).map(String::strip).collect(Collectors.toList());
        return names;
    }

    private void validateNames(List<String> names){
        Set<String> nameSet = new HashSet<>();
        names.forEach(name -> {
            validateName(name);
            containsName(nameSet, name);
        });
    }

    private void validateName(String name){
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1글자 이상이어야 합니다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    private void containsName(Set<String> nameSet, String name){
        if (nameSet.contains(name)){
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 고유해야만 합니다.");
        }
        nameSet.add(name);
    }


}
