package tech.hiyinyougen.demo.factory.di;

import lombok.Data;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 09:45
 * @Description
 */
@Data
public class BeanDefinition {
    private String beanId;

    private String className;

    private Scope scope;

    private boolean lazyInit;

    private ConstructorArg[] args;

    @Data
    public static class ConstructorArg {
        private boolean isRef;

        private Class type;

        private Object arg;
    }

    public enum Scope {
        SINGELTON,
        PROTOTYPE;
    }
}
