package tech.hiyinyougen.java.async.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import tech.hiyinyougen.java.model.UserModel;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 15:32
 * @Description
 */
@Getter
public class UserSaveEvent extends ApplicationEvent {
    private UserModel userModel;

    public UserSaveEvent(Object source, UserModel userModel) {
        super(source);
        this.userModel = userModel;
    }
}
