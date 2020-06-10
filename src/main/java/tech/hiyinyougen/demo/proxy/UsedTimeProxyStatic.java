package tech.hiyinyougen.demo.proxy;

/**
 * @Author yinyg
 * @CreateTime 2020/6/10 15:37
 * @Description
 */
public class UsedTimeProxyStatic implements UserService {
    private UserService userService;

    public UsedTimeProxyStatic(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUsername() {
        System.out.println("static proxy success");
        String ret = this.userService.getUsername();
        return ret;
    }

    @Override
    public String getUsername(String username) {
        System.out.println("static proxy success");
        String ret = this.userService.getUsername(username);
        return ret;
    }

    public static void main(String[] args) {
        UserService userService = new UsedTimeProxyStatic(new UserServiceImpl());
        System.out.println(userService.getUsername());
    }
}
