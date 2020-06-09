package tech.hiyinyougen.demo.proxy;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 15:00
 * @Description
 */
public class UserServiceImpl implements UserService {
    public String getUsername() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "yinyg";
    }

    @Override
    public String getUsername(String username) {
        return username;
    }
}
