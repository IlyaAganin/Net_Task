package com.netcracker.repository;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

/**
 * Class which help work with dataframes
 *
 */
public class LabFactory implements ILabFactory{

	@Override
	public IDivision createDivision() {
		// TODO Auto-generated method stub
		return new Division();
	}

	@Override
	public IPerson createPerson() {
		// TODO Auto-generated method stub
		return new Person();
	}

	@Override
	public IPersonRepository createPersonRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> IRepository<T> createRepository(Class<T> clazz) {
		// TODO Auto-generated method stub
		return new Repository<>();
	}
	
}
