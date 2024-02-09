package com.enjoySpringBoot.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// In case of Scope prototype, pre destroy method is not called!
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println(" In constructor : " + getClass().getSimpleName());
    }

    // define our init method

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In my doStartupStuff(): " + getClass().getSimpleName());
    }

    // define our destroy method

    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("In my doMyCleanStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
