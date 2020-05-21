package tech.hiyinyougen.java.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yinyg
 * @CreateTime 2020/5/21 11:24
 * @Description
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "Hello SpringBoot";
    }
}
