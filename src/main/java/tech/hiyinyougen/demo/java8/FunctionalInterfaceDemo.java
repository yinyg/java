package tech.hiyinyougen.demo.java8;

/**
 * @Author yinyg
 * @CreateTime 2019/7/3 16:07
 * @Description 函数式接口demo
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FunctionalInterface f = (int a, int b) -> System.out.println(a + " + " + b + " = " + (a + b));

        f.handle(1, 2);
    }
}
