package tech.hiyinyougen.java.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionNameStrategy;
import org.springframework.amqp.rabbit.connection.SimplePropertyValueConnectionNameStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 16:32
 * @Description
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="spring.rabbitmq")
public class RabbitMQConfig {
    private String host;
    private Integer port;
    private String username;
    private String password;

    @Bean
    public ConnectionNameStrategy cns() {
        return new SimplePropertyValueConnectionNameStrategy("spring.application.name");
    }

    @Bean(name = "javaConnectionFactory")
    public ConnectionFactory connectionFactory(ConnectionNameStrategy cns) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        connectionFactory.setPublisherReturns(true);
        connectionFactory.setConnectionNameStrategy(cns);
        return connectionFactory;
    }
}
