package com.practice.numberbaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@Import({BaseBallServiceImpl.class})
class BaseBallServiceImplTest {

    @Autowired
    BaseBallService baseBallService;

    @Test
    @DisplayName("숫자야구 게임 플레이볼")
    void play() {
        // given
        List<BaseBall> inputs = new ArrayList<>();
        inputs.add(new BaseBall("123", 1, 1));
        inputs.add(new BaseBall("356", 1, 0));
        inputs.add(new BaseBall("327", 2, 0));
        inputs.add(new BaseBall("489", 0, 1));

        // when
        int result = baseBallService.play(inputs);

        // then
        assertEquals(result, 2);
    }

    @DisplayName("같은 숫자가 존재 하는지 or 0이 존재하는지 여부 판단")
    @ParameterizedTest
    @ValueSource(ints = { 775, 103, 555 })
    void hasSameOrZeroNum(int number) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = baseBallService.getClass().getDeclaredMethod("hasSameOrZeroNum", int.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(baseBallService, number);
        assertTrue(result);
    }

    @Test
    @DisplayName("주어진 케이스와 비교할 값을 받아 스트라이크 갯수 체크")
    void countStrike() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = baseBallService.getClass().getDeclaredMethod("countStrike", String.class, String.class);
        method.setAccessible(true);

        String source = "123";
        String target = "124";
        int result = (int) method.invoke(baseBallService, source, target);

        assertEquals(result, 2);
    }

    @Test
    @DisplayName("주어진 케이스와 비교할 값을 받아 볼 갯수 체크")
    void countBall() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = baseBallService.getClass().getDeclaredMethod("countBall", String.class, String.class);
        method.setAccessible(true);

        String source = "123";
        String target = "142";
        int result = (int) method.invoke(baseBallService, source, target);

        assertEquals(result, 1);
    }


}