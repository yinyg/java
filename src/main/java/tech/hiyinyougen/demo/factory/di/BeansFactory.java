package tech.hiyinyougen.demo.factory.di;

import org.springframework.beans.factory.BeanCreationException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 10:01
 * @Description
 */
public class BeansFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beansDefinition = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        if (beanDefinitions != null && beanDefinitions.size() > 0) {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                beansDefinition.putIfAbsent(beanDefinition.getBeanId(), beanDefinition);
            }
            for (BeanDefinition beanDefinition : beanDefinitions) {
                if (beanDefinition.getScope() == BeanDefinition.Scope.SINGELTON && beanDefinition.isLazyInit() == false) {
                    this.createBean(beanDefinition);
                }
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.getScope() == BeanDefinition.Scope.SINGELTON && singletonObjects.containsKey(beanDefinition.getBeanId())) {
            return singletonObjects.get(beanDefinition.getBeanId());
        }
        Object bean = null;
        try {
            Class beanClass = Class.forName(beanDefinition.getClassName());
            if (beanClass == null) {
                throw new ClassNotFoundException("can not resolve beanId: " + beanDefinition.getBeanId());
            }
            BeanDefinition.ConstructorArg[] args = beanDefinition.getArgs();
            if (args == null || args.length == 0) {
                bean = beanClass.newInstance();
            } else {
                Class[] argClasses = new Class[args.length];
                Object[] argObjects = new Object[args.length];
                for (int i = 0; i < args.length; i++) {
                    if (args[i].isRef()) {
                        BeanDefinition refBeanDefinition = beansDefinition.get(args[i].getArg());
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    } else {
                        argClasses[i] = args[i].getType();
                        argObjects[i] = args[i].getArg();
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanCreationException(e.getMessage());
        }
        return bean;
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beansDefinition.get(beanId);
        if (beanDefinition == null) {
            throw new NullPointerException("no such bean, beanId: " + beanId);
        }
        return this.createBean(beanDefinition);
    }
}
