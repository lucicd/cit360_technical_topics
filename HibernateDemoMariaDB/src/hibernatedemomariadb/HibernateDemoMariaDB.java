package hibernatedemomariadb;

import java.util.List;

public class HibernateDemoMariaDB {

     public static void main(String[] args) {
        TestDAO t = TestDAO.getInstance();
        List<Person> customers = t.getPersons();
        for (Person customer: customers)
        {
            System.out.println(customer);
        }
        System.out.println(t.getPerson(1));
    }    
}
