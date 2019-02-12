package pojo;

import java.io.Serializable;
import java.util.Map;

public class Person implements Serializable{
    
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    public Person() {}
    
    public Person(Map person) {
        this.firstName = person.get("firstName").toString();
        this.lastName = person.get("lastName").toString();
        this.yearOfBirth = Integer.parseInt(person.get("yearOfBirth").toString());
    }
    
    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }
    
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", yearOfBirth=" + yearOfBirth + '}';
    }
}
