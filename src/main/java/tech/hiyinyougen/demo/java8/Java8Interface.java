package tech.hiyinyougen.demo.java8;

/**
 * @Author yinyg
 * @CreateTime 15:15
 * @Description
 */
public interface Java8Interface {
    default void print() {
        System.out.println("默认方法");
    }
}
