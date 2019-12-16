package com.netcracker.repository;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

import com.netcracker.reflection.Injector;
import com.netcracker.reflection.InjectorException;
import com.netcracker.sort.AgeComparator;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

public class RepositoryTest {
    private final LabFactory factory = new LabFactory();
    private final IRepository<IPerson> repository = factory.createRepository(IPerson.class);
    private final IPerson[] expectedRep;
    private final IPerson[] ageRep;


     RepositoryTest() {
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
        repository.add(person);
        person.setValues("Steve","Buscemi",gender,  LocalDate.parse("13.12.1957", formatter), division, new BigDecimal(5000), 9);
        repository.add(person);
        person.setValues("Stephen","King",gender,  LocalDate.parse("21.09.1947", formatter), division, new BigDecimal(3000), 7);
        repository.add(person);
        person.setValues("Ilya","Aganin",gender,  LocalDate.parse("11.07.1999", formatter), division, new BigDecimal(4200), 1);
        repository.add(person);

        Person person1 = new Person();
        person1.setValues("Sylvester","Stallone",gender,  LocalDate.parse("06.07.1946", formatter), division, new BigDecimal(7500), 10);
        Person person2 = new Person();
        person2.setValues("Name","Surname", gender,  LocalDate.parse("09.09.1999", formatter), division, new BigDecimal(7200), 3);
        Person person3 = new Person();
        person3.setValues("Steven","Seagal", gender,  LocalDate.parse("10.04.1952", formatter), division, new BigDecimal(3000), 4);
        Person person4 = new Person();
        person4.setValues("Steve","Buscemi",gender,  LocalDate.parse("13.12.1957", formatter), division, new BigDecimal(5000), 9);
        Person person5 = new Person();
        person5.setValues("Stephen","King",gender,  LocalDate.parse("21.09.1947", formatter), division, new BigDecimal(3000), 7);
        Person person6 = new Person();
        person6.setValues("Ilya","Aganin",gender,  LocalDate.parse("11.07.1999", formatter), division, new BigDecimal(4200), 1);

        expectedRep = new Person[]{person1, person2, person3, person4, person5, person6};


        ageRep = new Person[]{person2, person6, person4, person3, person5, person1};



    }


    @Test
    void add() {
        IPerson[] actualRep = ((Repository<IPerson>)repository).getAllRepository();
        assertArrayEquals(actualRep, expectedRep);
    }

    @Test
    void get() {
        Gender gender = Gender.MALE;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        IPerson person = repository.get(0);
        Person person1 = new Person();
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        person1.setValues("Sylvester","Stallone",gender,  LocalDate.parse("06.07.1946", formatter), division, new BigDecimal(7500), 10);
        assertEquals(person, person1);
    }

    @Test
    void delete() {
    	repository.delete(0);
        Gender gender = Gender.MALE;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        Person person2 = new Person();
        person2.setValues("Name","Surname", gender,  LocalDate.parse("09.09.1999", formatter), division, new BigDecimal(7200), 3);
        Person person3 = new Person();
        person3.setValues("Steven","Seagal", gender,  LocalDate.parse("10.04.1952", formatter), division, new BigDecimal(3000), 4);
        Person person4 = new Person();
        person4.setValues("Steve","Buscemi",gender,  LocalDate.parse("13.12.1957", formatter), division, new BigDecimal(5000), 9);
        Person person5 = new Person();
        person5.setValues("Stephen","King",gender,  LocalDate.parse("21.09.1947", formatter), division, new BigDecimal(3000), 7);
        Person person6 = new Person();
        person6.setValues("Ilya","Aganin",gender,  LocalDate.parse("11.07.1999", formatter), division, new BigDecimal(4200), 1);
        IPerson[] personRep = new IPerson[] {person2, person3, person4, person5, person6};
        IPerson[] newbase = ((Repository<IPerson>)repository).getAllRepository();
        assertArrayEquals(personRep, newbase);
    }

    @Test
    void set() {
        Gender gender = Gender.MALE;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        Person person = new Person();
        person.setValues("Ilya","Aganin",gender,  LocalDate.parse("11.07.1999", formatter), division, new BigDecimal(4200), 1);
        repository.set(1,person);

        assertEquals(person, repository.get(1));

    }

    @Test
    void toList() {
        List<IPerson> iPersonList = repository.toList();
        assertEquals(iPersonList, Arrays.asList(expectedRep));
    }

    @Test
    void sortBy() throws  InjectorException {
        AgeComparator<IPerson> comparator = new AgeComparator<>();
        Injector.inject(repository);
        repository.sortBy(comparator);
        assertArrayEquals(ageRep, ((Repository<IPerson>)repository).getAllRepository());
    }
    @Test
    void searchBy() {
        Predicate<IPerson> personSearch = p -> p.getBirthdate().getYear() > 1974;

        IRepository<IPerson> reposiotry =  repository.searchBy(personSearch);
        assertEquals(reposiotry, repository);
    }
    @Test
    void testAdd() {
        Gender gender = Gender.MALE;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Division division = new Division();
        division.setId(1);
        division.setName("name");
        Person person5 = new Person();
        person5.setValues("Stephen","King",gender,  LocalDate.parse("21.09.1947", formatter), division, new BigDecimal(3000), 7);
        repository.add(1, person5);
        assertEquals(repository.get(1), person5);

    }
}
