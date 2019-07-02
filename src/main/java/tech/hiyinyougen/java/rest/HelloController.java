package tech.hiyinyougen.java.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "HelloController", description = "hello")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @ApiOperation("helloworld")
    @GetMapping("/helloworld")
    public String index() { return "Hello World"; }
}
