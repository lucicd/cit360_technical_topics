/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemodrazen;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Drazen
 */
public class PersonTestDAO {
    SessionFactory factory = null;
    Session session = null;

    private static PersonTestDAO single_instance = null;

    private PersonTestDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }

    /** This is what makes this class a singleton.  You use this
     *  class to get an instance of the class. */
    public static PersonTestDAO getInstance()
    {
        if (single_instance == null) {
            single_instance = new PersonTestDAO();
        }

        return single_instance;
    }

    /** Used to get more than one customer from database
     *  Uses the OpenSession construct rather than the
     *  getCurrentSession method so that I control the
     *  session.  Need to close the session myself in finally.*/
    public List<Person> getPersons() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemodrazen.Person";
            List<Person> cs = (List<Person>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return cs;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }

    }

    /** Used to get a single customer from database */
    public Person getPersonEntity(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemodrazen.Person where id=" + Integer.toString(id);
            Person c = (Person)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
