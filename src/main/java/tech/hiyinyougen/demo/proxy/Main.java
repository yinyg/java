package tech.hiyinyougen.demo.proxy;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 15:26
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        UsedTimeProxy proxy = new UsedTimeProxy();
        UserService userService = (UserService)proxy.createProxy(new UserServiceImpl());
        System.out.println(userService.getUsername());
    }
}
