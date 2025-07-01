package com.home.restservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Getter
@Setter
@Entity
@Table(name = "People")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int age;

    public Person(String name, int age, int snils) {
        this.name = name;
        this.age = age;
        this.snils = snils;
    }



    private int snils;

}
