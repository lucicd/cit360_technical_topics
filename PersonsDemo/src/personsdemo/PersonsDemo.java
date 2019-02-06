/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personsdemo;

import java.util.List;

/**
 *
 * @author Drazen
 */
public class PersonsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestDAO t = TestDAO.getInstance();
        List<Person> persons = t.getPersons();
        for (Person person: persons)
        {
            System.out.println(person);
        }
        System.out.println(t.getPerson(1));
    }
    
}
