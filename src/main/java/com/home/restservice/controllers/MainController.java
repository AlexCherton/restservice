package com.home.restservice.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.restservice.dto.PersonDTO;
import com.home.restservice.entity.Person;
import com.home.restservice.repositories.PersonRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastConfigCustomizer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Methods")
public class MainController {

    private final ObjectMapper objectMapper;
    private final PersonRepo personRepo;

    /* @Autowired
   @Qualifier("loggingHazelcastConfigCustomizer")
   private HazelcastConfigCustomizer loggingHazelcastConfigCustomizer;

   /*GetMapping("/api/main")
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
  */
    @Operation(
            summary = "Добавляет нового клиента в БД",
            description = "Используя клиентский DTO используя паттерн Builder собирает и добавляет в базу клиента"
    )
    @PostMapping("/api/add")
    public void addPerson(@RequestBody PersonDTO personDTO) {
        log.info("row added:" + personRepo.save(Person.builder()
                .age(personDTO.getAge())
                .name(personDTO.getName())
                .snils(personDTO.getSnils())
                .build()));
    }

    @GetMapping("/api/getall")
    public String getAll() {
        List<Person> people = personRepo.findAll();

        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(people);
        } catch (JsonProcessingException e) {
            System.out.println("error with person");
        }
        return jsonData;

    }

    @GetMapping("/api")
    public Person getPerson(@RequestParam int id) {
        return personRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/delete")
    public void delPerson(@RequestParam int id) {
        personRepo.deleteById(id);
    }

    @PutMapping("/api/update")
    public String updPerson(@RequestBody Person person) {
        if (!personRepo.existsById(person.getId())){
            return "Не существует такого клиента";
        }
        return personRepo.save(person).toString();
    }
}
