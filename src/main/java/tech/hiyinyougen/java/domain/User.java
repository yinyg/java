package tech.hiyinyougen.java.domain;

import lombok.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

/**
 * @author yinyg
 * @date 2019/6/18
 */
//@Entity
@Getter
@Setter
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Component(value = "user3")
public class User implements InitializingBean, DisposableBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 用户名
    private String username;

    // 手机
    private String phone;

    public User() {
        System.out.println("调用Bean的函数(constructor)");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("调用Bean的函数(postConstruct)");
    }
    //MainConfig中@Bean 的initMethod
    public void initMethod2(){
        System.out.println("调用Bean的函数(initMethod2)");
    }
    //InitializingBean接口的方法afterPropertiesSet
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用Bean的函数(afterPropertiesSet)");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("调用Bean的函数(preDestroy)");
    }
    //DisposableBean接口的方法destroy
    @Override
    public void destroy() throws Exception {
        System.out.println("调用Bean的函数(destroy)");
    }
    //MainConfig中@Bean 的destroyMethod
    public void destroyMethod(){
        System.out.println("调用Bean的函数(destroyMethod)");
    }

}
