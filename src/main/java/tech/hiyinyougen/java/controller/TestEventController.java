package tech.hiyinyougen.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hiyinyougen.java.model.ResultModel;
import tech.hiyinyougen.java.service.TestEventService;

/**
 * @author yinyg
 * @date 2020/8/28
 * @description
 */
@RestController
@RequestMapping("/testEvent")
public class TestEventController {
    @Autowired
    private TestEventService testEventService;

    @GetMapping("/publishEvent")
    public ResultModel publishEvent() {
        testEventService.publishEvent();
        return ResultModel.builder().success(Boolean.TRUE).build();
    }
}
