package tech.hiyinyougen.java.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import tech.hiyinyougen.java.model.UserModel;
import tech.hiyinyougen.java.service.UserService;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 16:32
 * @Description
 */
@Data
@Configuration
@ConfigurationProperties(prefix="spring.rabbitmq")
@EnableRabbit
@Slf4j
public class RabbitMQConfig {
    public String host;
    public Integer port;
    public String username;
    public String password;

    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserService userService;

    private static final String CONNECTIONFACTORYNAME = "connectionFactory";

    public static final String TEST_EXCHANGE = "test";

    /************* 队列 *************/
    // 用户队列
    public static final String USER_QUEUE = "user-queue";

    @Bean(name=CONNECTIONFACTORYNAME)
    @Primary
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirms(true); // enable confirm mode
        return connectionFactory;
    }

    @Bean
    public String queue(@Qualifier(CONNECTIONFACTORYNAME) ConnectionFactory connectionFactory) {
        try {
            Channel channel =connectionFactory.createConnection().createChannel(false);
            channel.queueDeclare(USER_QUEUE, true, false, false, null);
            channel.exchangeDeclare(TEST_EXCHANGE, BuiltinExchangeType.FANOUT,true);
            channel.queueBind(USER_QUEUE, TEST_EXCHANGE,"");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return USER_QUEUE;
        }
    }

    @Bean(name="rabbitListenerFactory")
    public SimpleRabbitListenerContainerFactory rabbitFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier(CONNECTIONFACTORYNAME) ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(1);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @RabbitListener(queues = {USER_QUEUE},containerFactory="rabbitListenerFactory")
    public void userQueueListener(@Payload Message content,
                                  @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                                  Channel channel) throws Exception {
        try {
            log.info("base mq process message=============================");
            JSONObject obj = null;//将json字符串转换为json对象
            String contentType = content.getMessageProperties().getContentType();
            if (MessageProperties.CONTENT_TYPE_JSON.equals(contentType)){
                obj = (JSONObject) JSON.parse(content.getBody());
            }else if(MessageProperties.CONTENT_TYPE_TEXT_PLAIN.equals(contentType)){
                obj = JSONObject.parseObject(new String(content.getBody()));
            }else{
                throw new RuntimeException("ContentType不支持！（"+contentType+"）");
            }
            String data = obj.toString();
            UserModel userModel = JSONObject.parseObject(data, UserModel.class);
            userService.save(userModel);
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            channel.basicAck(deliveryTag, false);
            log.info("base mq process message==========================end");
        }
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
}
