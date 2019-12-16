package com.netcracker.repository;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import au.com.bytecode.opencsv.CSVReader;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

/**
 * class for working with csv files
 *
 */
public class CsvLoader {
    private static final LabFactory factory = new LabFactory();

    /**
     * method which parses dataframe from csv file
     * @param repository which need to be parsed
     * @throws IOException exception
     */
    @SuppressWarnings("resource")
	static public void parseRepository(final IRepository<IPerson> repository, final String path) throws IOException {

        final CSVReader reader = new CSVReader(new
                FileReader(
                path),
                ';'
                ,'"' ,
                1);

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            int id;
            String firstName;
            String lastName;
            Gender gender;
            LocalDate date;
            IDivision division;
            BigDecimal salary;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            id = Integer.parseInt(nextLine[0]);
            firstName = nextLine[1];
            lastName = nextLine[1];
            if (nextLine[2].compareTo("Male") > 0) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }
            division = checkArrayDivision(nextLine[4]);
            date = LocalDate.parse(nextLine[3], formatter);
            salary = new BigDecimal(nextLine[5]);
            IPerson person =  factory.createPerson();
            ((Person)person).setValues(firstName, lastName, gender, date, division, salary, id);
            repository.add(person);
        }
    }

    /**
     * method which check department on existence
     * @param divisionName name of unique department
     * @return new object Division if this one doesn't exist
     */
    static private IDivision checkArrayDivision(String divisionName) {
        for (IDivision currentDivision: Person.alldDivision) {
            if(currentDivision.getName().equals(divisionName)) {
                return currentDivision;
            }
        }
        IDivision newDivision = factory.createDivision() ;
        newDivision.setName(divisionName);
        newDivision.setId(Person.alldDivision.size() + 1);
        Person.alldDivision.add(newDivision);
        return newDivision;
    }
}	
