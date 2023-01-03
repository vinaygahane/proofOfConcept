package com.example.DependencyInjectionStrategyDP;

import org.springframework.stereotype.Component;

@Component("dEngg")
public class DieselEngine implements Engine {

    public DieselEngine() {
        System.out.println("Diesel Engine : 0-param constructor");
    }

    @Override
    public void start() {
        System.out.println("Diesel engine start");
    }

    @Override
    public void stop() {
        System.out.println("Diesel engine stop");

    }
}
