package com.example.DependencyInjectionStrategyDP;

import org.springframework.stereotype.Component;

@Component("pEngg")
public class PetrolEngine implements Engine {
    public PetrolEngine() {
        System.out.println("Petrol Engine : 0-param constructor");
    }

    @Override
    public void start() {
        System.out.println("Petrol engine start");
    }

    @Override
    public void stop() {
        System.out.println("Petrol engine stop");

    }
}
