package com.netcracker.reflection;

//import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.netcracker.repository.Division;
import com.netcracker.repository.LabFactory;
import com.netcracker.repository.Person;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

class InjectorTest {
    private final LabFactory factory = new LabFactory();
    private final IRepository<IPerson> repository = factory.createRepository(IPerson.class);



    @Test
    void inject() throws  InjectorException {
        Gender gender = Gender.MALE;
        Person person = (Person) factory.createPerson();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        person.setValues("Sylvester","Stallone",gender,  LocalDate.parse("06.07.1946", formatter), division, new BigDecimal(7500), 10);
        repository.add(person);
        person.setValues("Name","Surname", gender,  LocalDate.parse("09.09.1999", formatter), division, new BigDecimal(7200), 3);
        repository.add(person);
        person.setValues("Steven","Seagal", gender,  LocalDate.parse("10.04.1952", formatter), division, new BigDecimal(3000), 4);
        Injector.inject(repository);
    }
}