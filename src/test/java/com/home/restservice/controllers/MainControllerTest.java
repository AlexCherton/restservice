package com.home.restservice.controllers;

import com.home.restservice.entity.Person;
import com.home.restservice.repositories.PersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {
    @Mock
    private PersonRepo personRepo;

    @InjectMocks
    private MainController mainController;

    @Test
    void updPerson() {
        int id = 1;
        Person person = new Person();
        person.setId(id);

        when (personRepo.existsById(id)).thenReturn(false);
        String expected = "Не существует такого клиента";
        assertEquals(expected, mainController.updPerson(person));

    }
}