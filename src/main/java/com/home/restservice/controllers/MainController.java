package com.home.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.restservice.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener () {
    return "Hello, world";
    }

    @GetMapping("/api/person")
    public  String getPerson(){
        Person person = new Person("Вася", 32, 1010);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            System.out.println("error with person");
        }
        return jsonData;
    }

    @PostMapping("/api/specperson")
    public  String getSpecPerson(@RequestParam String name){
        Person person = new Person(name, 32, 1010);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            System.out.println("error with person");
        }
        return jsonData;
    }

}
