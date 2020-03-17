package tech.hiyinyougen.java.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hiyinyougen.java.domain.User;

@Api(value = "HelloController", description = "hello")
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ApplicationContext applicationContext;

    @ApiOperation("helloworld")
    @GetMapping("/helloworld")
    public String index() {
        String[] strings = applicationContext.getBeanNamesForType(User.class);
        return "Hello World";
    }
}
