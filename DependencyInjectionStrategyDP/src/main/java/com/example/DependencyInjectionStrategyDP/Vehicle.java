package com.example.DependencyInjectionStrategyDP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
    @Autowired
    @Qualifier("eEngg")
    private Engine engine;

    public Vehicle(){
        System.out.println("vehicle :: 0-param constructor");
    }
    public void move(String source, String dest){
        engine.start();
        System.out.println("Journey started from "+source);
        System.out.println("Journey is going on");
        engine.stop();
        System.out.println("Journey stopped at "+dest);
    }
}
