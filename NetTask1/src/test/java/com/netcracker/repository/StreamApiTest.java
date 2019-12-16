package com.netcracker.repository;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ru.vsu.lab.entities.IPerson;

class StreamApiTest {

    @Test
    void stream() throws IOException {
        @SuppressWarnings("rawtypes")
		Repository rep = new Repository();
        String path = "src/main/resources/persons.csv";
        StreamApi<IPerson> streamApi = new StreamApi<>(rep, path);
        streamApi.streamDepartmentPersons();
        streamApi.streamPersonName();
        streamApi.streamPersonNameSalary();
        streamApi.streamPersonSalary();
        streamApi.streamPersonAge();
    }
}