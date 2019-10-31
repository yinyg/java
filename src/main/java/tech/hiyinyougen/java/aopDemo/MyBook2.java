package tech.hiyinyougen.java.aopDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author yinyg
 * @CreateTime 2019/10/30 11:08
 * @Description
 */
@Aspect
@Component
public class MyBook2 {

    @Before(value = "execution(* tech.hiyinyougen.java.aopDemo.Book2.*(..))")
    public void before2() {
        System.out.println("前置增强...注解版本...");
    }

    @After(value = "execution(* tech.hiyinyougen.java.aopDemo.Book2.*(..))")
    public void after2() {
        System.out.println("后置增强...注解版本...");
    }

    //环绕通知
    @Around(value = "execution(* tech.hiyinyougen.java.aopDemo.Book2.*(..))")
    public void around2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前
        System.out.println("方法之前...注解版本...");

        //执行被增强的方法
        proceedingJoinPoint.proceed();

        //方法之后
        System.out.println("方法之后...注解版本...");

    }

}
