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
    private int id;
    private String name;
    private int age;
    private int snils;

    public Person(String name, int age, int snils) {
        this.name = name;
        this.age = age;
        this.snils = snils;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", snils=" + snils +
                '}';
    }
}
