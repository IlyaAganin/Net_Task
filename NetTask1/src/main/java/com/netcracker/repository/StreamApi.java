package com.netcracker.repository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.netcracker.repository.CsvLoader;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

/**
 * class for working with container using StreamApi
 * @param <T> type which will contain the container
 */
public class StreamApi<T extends IPerson> {
    /**
     * container for parsing
     */
    private List<T> parseList;

    /**
     * constructor where will be parsed repository
     * @param rep object in which repository will be written
     * @throws IOException exception
     */
    @SuppressWarnings("unchecked")
	public StreamApi(@SuppressWarnings("rawtypes") final IRepository rep, final String path) throws IOException {
        CsvLoader.parseRepository(rep, path);
        this.parseList = rep.toList() ;
    }

    /**
     * method selects users whose first letter "A" is salary U 3000 and age > 30
     * @return  filtered container
     */
    public List<T> streamPersonNameSalary() {
        Stream<T> personStream = parseList.stream();

        return personStream.filter(per -> per.getFirstName()
                .substring(0,1).equals("A") &&
                per.getSalary().intValueExact() > 3000 &&
                per.getAge() > 30).collect(Collectors.toList());
    }

    /**
     * method which filter users who the first letter are "aa"
     * @return filtered container
     */
    public List<T> streamPersonName() {
        Stream<T> personStream = parseList.stream();
        return personStream.filter(per -> per
                .getFirstName()
                .substring(0,2).toLowerCase()
                .equals("aa")).collect(Collectors.toList());
    }

    /**
     * Sorts users by branches and the total salary of employees
     * @return filtered container
     */
    public  Map<? extends IDivision, Long> streamPersonSalary() {
        Stream<T> personStream = parseList.stream();

        return personStream.collect(
                Collectors.groupingBy(IPerson::getDivision,
                        Collectors.summingLong(per -> per
                        .getSalary()
                        .intValueExact())));
    }
    /**
     * Sorts users by branches and the number of people in the branch
     * @return filtered container
     */
    public Map<? extends IDivision, Long> streamDepartmentPersons() {
        Stream<T> personStream = parseList.stream();
        return personStream.collect(Collectors.groupingBy(
                IPerson::getDivision,Collectors.counting()));
    }

    /**
     * Groups users by age
     * @return filtered container
     */
    public Map<Integer, Long> streamPersonAge() {
        Stream<T> personStream = parseList.stream();
        return personStream.collect(Collectors.groupingBy(
                IPerson::getAge,Collectors.counting()
        ));
    }
}
