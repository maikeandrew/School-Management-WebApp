package com.andrew.system_school_control_m.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {
    @GetMapping("/bemvindo")
    public String getMensabemDeBemVindo(){
        return "test test test test test testtest test test test test test test test test test";
    }
}
