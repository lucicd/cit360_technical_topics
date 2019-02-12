/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import org.json.simple.JSONObject;

/**
 *
 * @author aed20672
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public Person(JSONObject obj) {
        this.firstName = obj.get("firstName").toString();
        this.lastName = obj.get("lastName").toString();
        this.age = Integer.parseInt(obj.get("age").toString());
    }

    public int getAge() {
        return age;
    }
    
    public JSONObject makeJSONObject()
    {
        JSONObject obj = new JSONObject();
        obj.put("firstName", this.firstName);
        obj.put("lastName", this.lastName);
        obj.put("age", this.age);
        return obj;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }
}
