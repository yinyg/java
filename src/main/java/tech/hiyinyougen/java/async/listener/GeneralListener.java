package tech.hiyinyougen.java.async.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author yinyg
 * @CreateTime 2020/6/29 15:20
 * @Description
 */
@Component
@Slf4j
public class GeneralListener {
    @Async
    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        try {
        } catch (Exception e) {
            log.warn(ExceptionUtils.getFullStackTrace(e));
        }
    }
}
