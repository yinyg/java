package tech.hiyinyougen.demo.java8;

/**
 * @Author yinyg
 * @CreateTime 15:15
 * @Description 接口默认方法和静态方法
 */
public interface Java8Interface {
    default void print() {
        System.out.println("默认方法");
    }

    static void print2() {
        System.out.println("静态方法");
    }
}
