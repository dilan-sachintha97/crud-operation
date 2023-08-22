package com.spark.possystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestControl {

    @GetMapping("/get-text")
    public String getText(){
        return "Spring boot app is starting ";
    }

    @GetMapping("/get-name")
    public  String getName(){
        return "I am Dilan Sachintha";
    }
}
