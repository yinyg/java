package tech.hiyinyougen.java.config;

import com.rabbitmq.client.Channel;
import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author yinyg
 * @date 2019/5/9
 */
@Data
//@Configuration
//@ConfigurationProperties(prefix="spring.rabbitmq")
@EnableRabbit
public class RabbitConfig {
    public String host;

    public Integer port;

    public String username;

    public String password;

    private static final String HELLOEXCHANGE = "helloExchange";

    private static final String HELLO = "hello";

    private static final String HELLO2 = "hello2";

    private static final String CONNECTIONFACTORYNAME = "rabbitConnectionFactory";

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
            channel.queueDeclare(HELLO, true, false, false, null);
            channel.queueDeclare(HELLO2, true, false, false, null);
            channel.exchangeDeclare(HELLOEXCHANGE, ExchangeTypes.FANOUT, true);
            channel.queueBind(HELLO, HELLOEXCHANGE, "");
            channel.queueBind(HELLO2, HELLOEXCHANGE, "");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return HELLO;
        }
    }

    @Bean(name="rabbitFactory")
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

    @RabbitListener(queues = { HELLO })
    public void processMessage0(@Payload Message content,
                                @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                                Channel channel) throws Exception {
        System.out.println("HELLO-Receiver:" + content.toString());
    }

    @RabbitListener(queues = { HELLO2 })
    public void processMessage02(@Payload Message content,
                                @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                                Channel channel) throws Exception {
        System.out.println("HELLO2-Receiver:" + content.toString());
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
}
