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
public class ProductTestDAO {
    SessionFactory factory = null;
    Session session = null;

    private static ProductTestDAO single_instance = null;

    private ProductTestDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }

    /** This is what makes this class a singleton.  You use this
     *  class to get an instance of the class. */
    public static ProductTestDAO getInstance()
    {
        if (single_instance == null) {
            single_instance = new ProductTestDAO();
        }

        return single_instance;
    }

    /** Used to get more than one customer from database
     *  Uses the OpenSession construct rather than the
     *  getCurrentSession method so that I control the
     *  session.  Need to close the session myself in finally.*/
    public List<Product> getProducts() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemodrazen.Product";
            List<Product> cs = (List<Product>)session.createQuery(sql).getResultList();
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
    public Product getProduct(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernatedemodrazen.Product where id=" + Integer.toString(id);
            Product c = (Product)session.createQuery(sql).getSingleResult();
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
