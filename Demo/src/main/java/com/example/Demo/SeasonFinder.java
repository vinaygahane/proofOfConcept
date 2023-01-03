package com.example.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("sf")//makes class spring bean
public class SeasonFinder {
    @Autowired //makes IOC container to search for spring bean
    private LocalDate ldt;

    public String findSeason()
    {
        int month = ldt.getMonthValue();//get current month

        if(month >= 3 && month <=6)
            return "Summer season";
        else if(month >= 7 && month <=10)
            return "Rainy season";
        else
            return "winter season";
    }
}
