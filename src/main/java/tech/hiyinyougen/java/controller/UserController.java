package tech.hiyinyougen.java.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.hiyinyougen.java.async.event.UserSaveEvent;
import tech.hiyinyougen.java.config.RabbitMQConfig;
import tech.hiyinyougen.java.dao.UserDao;
import tech.hiyinyougen.java.model.ResultModel;
import tech.hiyinyougen.java.model.UserModel;

import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 10:26
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/findAll")
    public ResultModel findAll() {
        List<UserModel> userModelList = userDao.selectAll();
        return ResultModel.builder().success(Boolean.TRUE).data(userModelList).build();
    }

    @Transactional
    @PostMapping("save")
    public ResultModel save(@RequestBody UserModel userModel) {
        context.publishEvent(new UserSaveEvent(this, userModel));
        return ResultModel.builder().success(Boolean.TRUE).build();
    }

    @Transactional
    @PostMapping("send")
    public ResultModel send(@RequestBody UserModel userModel) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TEST_EXCHANGE, RabbitMQConfig.USER_QUEUE, JSONObject.toJSONString(userModel, SerializerFeature.WriteMapNullValue));
        return ResultModel.builder().success(Boolean.TRUE).message("发送成功").build();
    }
}
