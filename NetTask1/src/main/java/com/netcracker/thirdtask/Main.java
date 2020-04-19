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
		
	}
}



