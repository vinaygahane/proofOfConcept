package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody//converts java object to json , which is returned to client

@RestController//internally uses above two annotations
public class HelloWorldController {

    //HTTP GET REQUEST
    //http://localhost:8080/hello-world

    @GetMapping("/hello-world")//Map incoming HTTP GET request onto specific handler method
    public String   helloWorld()
    {
        return "hello World!";//prints heloo world at above address
    }
}
