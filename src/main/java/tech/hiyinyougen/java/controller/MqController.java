package tech.hiyinyougen.java.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hiyinyougen.java.config.RabbitMQConfig;
import tech.hiyinyougen.java.model.ResultModel;
import tech.hiyinyougen.java.model.UserModel;
import tech.hiyinyougen.java.util.SendMqUtils;

/**
 * @author yinyg
 * @date 2020/7/13
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private SendMqUtils sendMqUtils;

    @GetMapping("/sendMqTest")
    public ResultModel sendMqTest() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.prepare(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, JSON.parseObject(JSON.toJSONString(userModel)));
        return ResultModel.builder().success(Boolean.TRUE).build();
    }
}
