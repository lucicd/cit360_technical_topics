package personsdemo;

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
    
    public List<Person> getPersons()
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from personsdemo.Person";
            List<Person> customers;
            customers = (List<Person>)session.createQuery(sql).getResultList();
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
    
    public Person getPerson(int id)
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from personsdemo.Person where id=" + Integer.toString(id);
            Person customer;
            customer = (Person)session.createQuery(sql).getSingleResult();
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
