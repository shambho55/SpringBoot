package com.springboot.thymeleafdemo.controller;


import com.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguage;

    @Value("${favoriteSystems}")
    private List<String> favoriteOperatingSystem;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create a student object

        Student theStudent = new Student();

        // add student object to the model

        theModel.addAttribute("student",theStudent);

        // add the list of countries of the model

        theModel.addAttribute("countries",countries);

        // add the list of programming languages

        theModel.addAttribute("favoriteLanguage",favoriteLanguage);

        // add the list of Operating Systems

        theModel.addAttribute("favoriteOperatingSystem",favoriteOperatingSystem);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
       System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry() + " " + theStudent.getFavoriteLanguage() + " " + theStudent.getFavoriteOperatingSystem());



        return "student-confirmation";
    }

}
