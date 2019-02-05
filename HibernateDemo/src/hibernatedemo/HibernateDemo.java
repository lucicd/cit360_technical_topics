package hibernatedemo;

import java.util.List;

public class HibernateDemo {
    

    public static void main(String[] args) {
        TestDAO t = TestDAO.getInstance();
        List<Customer> customers = t.getCustomers();
        for (Customer customer: customers)
        {
            System.out.println(customer);
        }
        
        System.out.println(t.getCustomer(1));
    }
    
}
