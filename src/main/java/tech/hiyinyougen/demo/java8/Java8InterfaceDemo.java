package tech.hiyinyougen.demo.java8;

/**
 * @Author yinyg
 * @CreateTime 15:17
 * @Description 接口默认方法和静态方法demo
 */
public class Java8InterfaceDemo {
    public static void main(String[] args) {
        Java8Interface java8InterfaceImpl = new Java8InterfaceImpl();
        java8InterfaceImpl.print();
        Java8Interface.print2();
    }
}
