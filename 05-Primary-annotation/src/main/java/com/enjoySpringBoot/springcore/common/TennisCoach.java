package com.enjoySpringBoot.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}
