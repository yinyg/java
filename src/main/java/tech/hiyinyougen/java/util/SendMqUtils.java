package tech.hiyinyougen.java.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.hiyinyougen.java.config.RabbitMQConfig;

/**
 * @author yinyg
 * @date 2020/7/13
 * @description
 */
@Component
@Slf4j
public class SendMqUtils {
    @Autowired
    private RabbitMQConfig commonRabbit;

    /**
     * @description 发送数据
     * @param: exchange
     * @param: queueName
     * @param: message
     * @throws
     * @author yinyg
     * @date 2020/7/13
     */
    public void prepare(String exchange, String queueName, JSONObject message) {
        try {
            RabbitTemplate template = commonRabbit.rabbitTemplate();
            template.convertAndSend(exchange, exchange + "." + queueName, JSONObject.toJSONString(message, SerializerFeature.WriteMapNullValue));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }

    }
}
