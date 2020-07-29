package tech.hiyinyougen.java.controller;

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
@RestController
@RequestMapping("/mq")
public class MqController {
    @Autowired
    private SendMqUtils sendMqUtils;

    @GetMapping("/publishMqTest")
    public ResultModel publishMqTest() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.publish(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }

    @GetMapping("/publishMqTestWithTransaction")
    public ResultModel publishMqTestWithTransaction() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.publishWithTransaction(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }

    @GetMapping("/publishMqTestWithConfirm")
    public ResultModel publishMqTestWithConfirm() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.publishWithConfirm(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }

    @GetMapping("/publishMqTestWithAsyncConfirm")
    public ResultModel publishMqTestWithAsyncConfirm() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.publishWithAsyncConfirm(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }

    @GetMapping("/publishMqTestWithPersistent")
    public ResultModel publishMqTestWithPersistent() {
        UserModel userModel = UserModel.builder().Username("yinyg").age(18).build();
        sendMqUtils.publishWithPersistent(RabbitMQConfig.JAVA_EXCHANGE, RabbitMQConfig.QUEUE, userModel);
        return ResultModel.builder().success(Boolean.TRUE).build();
    }
}
