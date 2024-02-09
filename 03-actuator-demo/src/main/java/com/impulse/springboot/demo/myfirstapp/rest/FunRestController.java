package com.impulse.springboot.demo.myfirstapp.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    // expose a new endpoint for forture
    @GetMapping("/fortune")
    public String getDailyfortune(){
        return "Today is your lucky day.";
    }

}
