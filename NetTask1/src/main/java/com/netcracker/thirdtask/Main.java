package com.netcracker.thirdtask;


import java.io.IOException;
import com.netcracker.repository.CsvLoader;
import com.netcracker.repository.Repository;

/**
 * Main for homework
 */
public class Main {


	public static void main(String[] args) throws IOException{
		task3();


	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void task3() throws IOException{
		String path = "src/main/resources/persons.csv";
		Repository rep = new Repository();
		CsvLoader.parseRepository(rep,path);
		rep.showAllRepository();
		//System.out.println("------------------------------------------------------------------------");
		//System.out.println(rep.get(0));
		
	}
}


//import java.math.BigDecimal;
//import java.time.LocalDate;
//import ru.vsu.lab.entities.enums.Gender;

/*Division ABC = new Division("IT");
Person A = new Person(12365, "Ilya", Gender.MALE,  LocalDate.parse("1999-07-11"), ABC, BigDecimal.valueOf(1200));
Person B = new Person(4050, "Natalya", Gender.FEMALE, LocalDate.parse("1978-01-12"), ABC, BigDecimal.valueOf(5000));
Person C  = new Person(4780, "Volodya", Gender.MALE, LocalDate.parse("1946-02-10"), ABC, BigDecimal.valueOf(8000));
A.setGender(Gender.MALE);
Repository List1 = new Repository();
List1.add(A);
List1.add(B);
List1.add(C);
List1.getPersonsData();

System.out.println("Сортировка по id:");
List1.sortBy(Person.comparatorid);
List1.getPersonsData();
System.out.println("Сортировка по имени:");
List1.sortBy(Person.comparatorname);
List1.getPersonsData();

System.out.println(A.getDivision().getName());*/


//rep.getPersonsData();
/*for (int i = 0; i < rep.getCount(); i++) {

    System.out.println(rep.get(i).getId());
    System.out.println(rep.get(i).getFirstName());
    System.out.println(rep.get(i).getGender());
    System.out.println(rep.get(i).getDivision().getName());
    System.out.println(rep.get(i).getAge());
    System.out.println(rep.get(i).getSalary());
    System.out.println("-----------------------------------------------");
            }*/
