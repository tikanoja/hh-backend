package fi.haagahelia.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello(
        @RequestParam(name = "location", required = false, defaultValue = "default location") String location,
        @RequestParam(name = "name", required = false, defaultValue = "unnamed person") String name
    ) {
        String greeting = "Welcome to the " + location + " " + name + "!";
        return greeting;
    }
    
}
