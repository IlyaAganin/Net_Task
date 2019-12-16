package com.netcracker.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;


import ru.vsu.lab.entities.enums.Gender;

class PersonTest {

    @Test
    void getAge() {
        Gender gender = Gender.MALE;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        Person person = new Person();
        person.setValues("Ilya","Aganin", gender,  LocalDate.parse("11.07.1999", formatter), division, new BigDecimal(9000), 12);
        assertEquals(20, person.getAge());

    }


}
