package com.netcracker.repository;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

class CsvLoaderTest {

    @Test
    void parseBase() throws IOException {
        LabFactory factory = new LabFactory();
        IRepository<IPerson> repository = factory.createRepository(IPerson.class);
        String path = "src/main/resources/persons.csv";
        CsvLoader.parseRepository(repository, path);;
    }
}
