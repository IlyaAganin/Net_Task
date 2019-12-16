package com.netcracker.repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import com.netcracker.reflection.Injector;
import com.netcracker.reflection.InjectorException;
import com.netcracker.reflection.LabInject;
import com.netcracker.sort.BubbleSorter;
import com.netcracker.sort.ISorted;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

/**
 * Class for storage objects
 * @param <T> object
 */
public class Repository<T> implements IRepository<T> {
	
	private final LabFactory factory = new LabFactory();
	
	private int repLength = 0;
	
    @SuppressWarnings("unchecked")
	private T[]repository = (T[]) new Object[10];
    
    @LabInject
    private ISorted<T> sorter;

    /**
     * method which add object Person by index to repository
     * @param index  
     * @param person 
     */
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index,final T person) {
		// TODO Auto-generated method stub
        if (repository.length == repLength) {
            T[] newRepository = (T[]) new Person[repository.length
                    + (int)Math.ceil(1.5 * repository.length)];

            System.arraycopy(repository,
                    0,
                    newRepository,
                    0,
                    repository.length);
            repository = newRepository;
        }
        if (repLength + 1 - index >= 0)
            System.arraycopy(repository,
                    index,
                    repository,
                    index + 1,
                    repLength + 1 - index);
        repository[index] = person;
        repLength++;
		
	}
	
	/**
	 * method which add object Person to repository
	 * @param person object for adding
	 */
	@SuppressWarnings("unchecked")
	@Override
	final public void add(final T person) {
		// TODO Auto-generated method stub
		if (repository.length == repLength) {
			T[] newRepository = (T[]) new IPerson[
			       repository.length
	               + (int)Math.ceil(1.5 * repository.length)
	               ];
	       System.arraycopy(repository,
	               0,
	               newRepository,
	               0,
	               repository.length);
	       repository = newRepository;
	    }
		if (repLength == 0 || !getPerson(person).isPresent()) {
			T tempPerson = (T) factory.createPerson();
		    ((Person)tempPerson).setValues(
		    		((Person)person).getFirstName(),
		            ((Person)person).getLastName(),
		            ((Person)person).getGender(),
		            ((Person)person).getBirthdate(),
		            ((Person)person).getDivision(),
		            ((Person)person).getSalary(),
		            ((Person)person).getId()
		    );
		    repository[repLength] = tempPerson;
		    repLength++;
		 } else {
			System.out.println("This person already exists!");
		 }
	}
	
	/**
	 * method which deletes object by index
	 * @param index of element
	 */
	@Override
	public T delete(int index) {
		// TODO Auto-generated method stub
		T tempPerson = repository[index];
        for (int j = index; j < repLength - 1; j++) {
        	repository[j] =  repository[++j];
            j--;
        }
       repository[repLength - 1] = null;
       repLength = repLength - 1;
       return tempPerson;

	}

	/**
	 * method which returns element of repository by index
	 * @param index index of element
	 */
	@Override
	public T get(final int index) {
		// TODO Auto-generated method stub
		return repository[index];
	}
	
	/**
     * method that retrieves an item from a repository
     * @param requiredPerson the object to be removed from the repository
     * @return if the object is present, method returns it
     */
    private Optional<T> getPerson(final T requiredPerson) {
        for (int i = 0; i < repLength; i++) {
            if (repository[i].equals(requiredPerson)) {
                return Optional.of(repository[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * method which search elements with predicate
     * @param predicate which contains the conditions of search
     */
	@SuppressWarnings("unchecked")
	@Override
	public IRepository<T> searchBy(@SuppressWarnings("rawtypes") final Predicate predicate) {
		// TODO Auto-generated method stub

        for (T p:
                repository) {
            if (predicate.test(p)) {
                return this;
            }
        }
        return null;
	}

	/**
	 * set element in repository
	 * @param index the position of element
	 * @param person object which will be added 
	 * @return set element
	 */
	@Override
	public T set(int index, T person) {
		// TODO Auto-generated method stub
		repository[index] = person;
		return repository[index];
	}

	/**
	 * Sort repository with one of the methods of sorting arrays
	 * @param comparator 
	 */
	@Override
	public void sortBy(final Comparator<T> comparator) {
		// TODO Auto-generated method stub
        try {
            Injector.inject(this);
        } catch ( InjectorException e) {
            sorter = new BubbleSorter<>();
            e.printStackTrace();
        }
        sorter.sort(this, comparator );
		
	}

	/**
	 * Converts object Repository into list
	 * @return list of objects 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> toList() {
		// TODO Auto-generated method stub
        T[] returnedRepository = (T[]) new IPerson[repLength];
        System.arraycopy(repository,
                0,
                returnedRepository,
                0,
                repLength);
        return Arrays.asList(returnedRepository);
	}
	

    /**
     * the method that displays the repository
     */
    public final void showAllRepository() {
        for (T item: repository) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }
    
    /**
     * method which returns repository without null fields
     * @return repository without null fields
     */
    public final IPerson[] getAllRepository() {
        IPerson[] returnedRepository =  new Person[repLength];
        System.arraycopy(repository,
                0,
                returnedRepository,
                0,
                repLength);
        return returnedRepository;
    }
    
}
