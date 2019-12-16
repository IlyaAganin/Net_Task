package com.netcracker.repository;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ru.vsu.lab.repository.IRepository;

class LabFactoryTest {
	
    @Test
    void createRepository() {
        LabFactory factory = new LabFactory();
		@SuppressWarnings({ "unused", "rawtypes" })
		IRepository repository = factory.createRepository(Person.class);
    }
}
