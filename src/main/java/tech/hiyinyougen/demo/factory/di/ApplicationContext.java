package tech.hiyinyougen.demo.factory.di;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 09:43
 * @Description
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
