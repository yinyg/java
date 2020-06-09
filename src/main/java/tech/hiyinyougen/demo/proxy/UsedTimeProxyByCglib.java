package tech.hiyinyougen.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 16:04
 * @Description
 */
public class UsedTimeProxyByCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy method " + args[0]);
        Object result = methodProxy.invokeSuper(proxy, args);
        return result;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new UsedTimeProxyByCglib());
        // 创建代理对象
        UserService userServiceProxy = (UserService)enhancer.create();
        // 通过代理对象调用目标方法
        System.out.println(userServiceProxy.getUsername("cglib"));
    }
}
