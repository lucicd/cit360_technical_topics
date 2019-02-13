package cit360.drazen.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDAO {
    SessionFactory factory = null;
    Session session = null;
    
    private static PersonDAO singleInstance = null;
    
    private PersonDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }
    
    public static PersonDAO getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new PersonDAO();
        }
        return singleInstance;
    }
    
    public List<Person> getPeople()
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from cit360.drazen.model.Person";
            List<Person> people;
            people = (List<Person>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return people;
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
            sql = "from cit360.drazen.model.Person where id=" + Integer.toString(id);
            Person person;
            person = (Person)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
    
    public Integer addPerson(Person person)
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            Integer id = (Integer)session.save(person);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
