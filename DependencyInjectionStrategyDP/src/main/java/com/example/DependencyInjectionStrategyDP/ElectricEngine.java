package com.example.DependencyInjectionStrategyDP;

import org.springframework.stereotype.Component;


@Component("eEngg")
public class ElectricEngine implements Engine {

    public ElectricEngine() {
        System.out.println("Electric Engine : 0-param constructor");
    }

    @Override
    public void start() {
        System.out.println("Electric engine start");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stop");

    }
}
