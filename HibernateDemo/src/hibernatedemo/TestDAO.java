package hibernatedemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestDAO {
    SessionFactory factory = null;
    Session session = null;
    
    private static TestDAO singleInstance = null;
    
    private TestDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }
    
    public static TestDAO getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new TestDAO();
        }
        return singleInstance;
    }
    
    public List<Customer> getCustomers()
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemo.Customer";
            List<Customer> customers;
            customers = (List<Customer>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return customers;
        } catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
    
    public Customer getCustomer(int id)
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from hibernatedemo.Customer where id=" + Integer.toString(id);
            Customer customer;
            customer = (Customer)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
