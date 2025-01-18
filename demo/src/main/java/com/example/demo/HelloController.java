package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello(
        @RequestParam(name = "firstname", required = false, defaultValue = "World") String firstName,
        @RequestParam(name = "lastname", required = false, defaultValue = "") String lastName
    ) {
        String greeting = "Hello " + firstName;
        if (!lastName.isEmpty()) {
            greeting += " " + lastName;
        }
        return greeting;
    }
    
}
