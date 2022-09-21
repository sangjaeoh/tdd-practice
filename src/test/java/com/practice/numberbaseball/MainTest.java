package com.practice.numberbaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @DisplayName("같은 숫자가 존재 하는지 or 0이 존재하는지 여부 판단")
    @ParameterizedTest
    @ValueSource(ints = { 775, 103, 555 })
    void hasSameOrZeroNum(int number) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Method method = main.getClass().getDeclaredMethod("hasSameOrZeroNum", int.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(main, number);
        assertTrue(result);
    }

    @Test
    @DisplayName("주어진 케이스와 비교할 값을 받아 스트라이크 갯수 체크")
    void countStrike() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Method method = main.getClass().getDeclaredMethod("countStrike", String.class, String.class);
        method.setAccessible(true);

        String source = "123";
        String target = "124";
        int result = (int) method.invoke(main, source, target);

        assertEquals(result, 2);
    }

    @Test
    @DisplayName("주어진 케이스와 비교할 값을 받아 볼 갯수 체크")
    void countBall() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Method method = main.getClass().getDeclaredMethod("countBall", String.class, String.class);
        method.setAccessible(true);

        String source = "123";
        String target = "142";
        int result = (int) method.invoke(main, source, target);

        assertEquals(result, 1);
    }

    @Test
    @DisplayName("숫자 야구 게임 플레이")
    void play() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Method method = main.getClass().getDeclaredMethod("play", List.class);
        method.setAccessible(true);

        List<Main.BaseBall> inputs = Arrays.asList(
                new Main.BaseBall("123", 1, 1),
                new Main.BaseBall("356", 1, 0),
                new Main.BaseBall("327", 2, 0),
                new Main.BaseBall("489", 0, 1)
        );

        int result = (int) method.invoke(main, inputs);

        assertEquals(result, 2);
    }

}