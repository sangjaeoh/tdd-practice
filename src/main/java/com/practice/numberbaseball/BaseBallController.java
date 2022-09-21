package com.practice.numberbaseball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Controller
@RequestMapping("/api/v1/baseball")
public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }


    @GetMapping("/play")
    public @ResponseBody String play(@RequestParam String input){
        String[] lines = input.split("\\n");
        int n = Integer.parseInt(lines[0]);

        List<BaseBall> inputs = new ArrayList<>();
        for (int i = 1; i < n + 1; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(lines[i], " ");
            inputs.add(new BaseBall(
                    stringTokenizer.nextToken(),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())));
        }
        return String.valueOf(baseBallService.play(inputs));
    }


}
