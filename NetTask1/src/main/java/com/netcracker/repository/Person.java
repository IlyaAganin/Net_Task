package com.netcracker.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

/**
 * Class which storage information about certain person
 * 
 */
public class Person implements IPerson	{

    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer id;
    private java.time.LocalDate birthdate;
    private BigDecimal salary;
    private IDivision division;
    static final List<IDivision> alldDivision = new ArrayList<>();
    
    /**
     * Empty constructor
     */
    public Person() {
    		
    }
    
    /**
     * Constructor
     * @param ID number
     * @param firstName of person
     * @param gender of person (female or male)
     * @param birthday date as YYYY-MM-DD format
     * @param division of person (employee)
     * @param salary of person (employee)
     */
    public Person(Integer id, String firstName, Gender gender, java.time.LocalDate birthdate, IDivision division,  BigDecimal salary) {
    	this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.division = division;
        this.salary = salary;
    }
    
    /**
     * Constructor
     * @param ID number
     * @param firstName of person
     * @param gender of person (female or male)
     * @param birthday date as YYYY-MM-DD format
     */
    public Person(Integer id, String firstName, Gender gender, java.time.LocalDate birthdate) {
    	this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.birthdate = birthdate;
    }
    
    public final void setValues(final String reqfirstNameParam,
            final String reqLastNameParam,
            final Gender reqGenderParam,
            final java.time.LocalDate birthdateParam,
            final IDivision divisionParam,
            final BigDecimal salaryParam,
            final Integer idParam
                ) {
					this.firstName = reqfirstNameParam;
					this.lastName = reqLastNameParam;
					this.birthdate = birthdateParam;
					this.division = divisionParam;
					this.gender = reqGenderParam;
					this.salary = salaryParam;
					this.id = idParam;
   }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public Gender getGender() {
        return gender;
    }


    public Integer getId() {
        return id;
    }


    public java.time.LocalDate getBirthdate() {
        return birthdate;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setGender(Gender gender) {

        this.gender = gender;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setBirthdate(java.time.LocalDate birthdate) {
       this.birthdate = birthdate;
    }
    
    /** function
     * function for getting age from date of birthday
     * @return age as integer number
     */
    public final Integer getAge() {
        return LocalDate.now().minusYears(birthdate.getYear()).getYear();
    }
    public BigDecimal getSalary(){
        return salary;

    }
    public void setSalary(BigDecimal salary){
        this.salary = salary;

    }

    public IDivision getDivision(){

        return division;

    }

    public void setDivision(IDivision division){
       this.division = division;

    }

    @Override
	public int hashCode() {
		return Objects.hash(division, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(division, other.division) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Person [" +
			   "firstName=" + firstName +
			   ", lastName=" + lastName + 
			   ", gender=" + gender + 
		       ", id=" + id + 
			   ", birthday=" + birthdate + 
			   ", salary=" + salary + 
		       ", division=" + division + 
			   "]";
	}

	
}

//import java.util.Comparator;
/* public static final Comparator<IPerson> comparatorid =
(IPerson a, IPerson b) -> (a.getId() - b.getId());
public static final Comparator<IPerson> comparatorname =
 (IPerson a, IPerson b) -> (a.getFirstName().compareTo(b.getFirstName()));
public static final Comparator<IPerson> comparatorbirthday =
 (IPerson a, IPerson b) -> (comparer(a,b));

public static  int comparer(IPerson a,IPerson b){
java.time.LocalDate a1 = a.getBirthdate();
java.time.LocalDate b1 = b.getBirthdate();
int rezult;
if (a1.isBefore(b1)) {
 rezult = 1;
}
if(a1.isAfter((b1))){
 rezult = -1;
}
else rezult = 0;
return rezult;
}*/