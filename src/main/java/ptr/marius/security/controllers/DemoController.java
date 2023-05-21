package ptr.marius.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String hello() {

        return "Hello";
    }

    @GetMapping("/test")
    public String test() {

        return "test";
    }

    @PostMapping("/test")
    public String test2() {

        return "testPOST";
    }
}
