package com.practice.carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void inputNames() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // given
        String input = "hong,kill,dong";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(in);
        CarRacingController controller = new CarRacingController(scanner);

        Method method = controller.getClass().getDeclaredMethod("inputNames");
        method.setAccessible(true);

        // when
        List<String> names = (List<String>) method.invoke(controller);

        // then
        System.out.println(names);
        assertArrayEquals(input.split(","), names.toArray());

    }

}