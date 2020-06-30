package tech.hiyinyougen.java.async.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import tech.hiyinyougen.java.async.event.UserSaveEvent;
import tech.hiyinyougen.java.service.UserService;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 15:20
 * @Description
 */
@Component
@Slf4j
public class GeneralListener {
    @Autowired
    private UserService userServicel;

    @Async
    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            if (event instanceof UserSaveEvent) {
                userServicel.save(((UserSaveEvent) event).getUserModel());
            }
        } catch (Exception e) {
            log.warn(ExceptionUtils.getFullStackTrace(e));
        }
    }
}
