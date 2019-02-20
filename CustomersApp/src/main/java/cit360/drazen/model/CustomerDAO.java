package cit360.drazen.model;

import cit360.drazen.exceptions.ModelException;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public class CustomerDAO {
    SessionFactory factory = null;
    Session session = null;
    
    private static CustomerDAO singleInstance = null;
    
    private CustomerDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }
    
    public static CustomerDAO getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new CustomerDAO();
        }
        return singleInstance;
    }
    
    public List<Customer> getCustomers() throws ModelException
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from cit360.drazen.model.Customer";
            List<Customer> customers;
            customers = (List<Customer>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return customers;
        } catch(HibernateException ex) {
            session.getTransaction().rollback();
            throw new ModelException("Failed to get customers. " + ex.getMessage());
        } finally {
            session.close();
        }
    }
    
    public Customer getCustomer(int id) throws ModelException
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from cit360.drazen.model.Customer where id=" + Integer.toString(id);
            Customer customer;
            customer = (Customer)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return customer;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw new ModelException("Failed to get customer. " + ex.getMessage());
        } finally {
            session.close();
        }
    }
    
    public Integer addCustomer(Customer customer) throws ModelException
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            Integer id = (Integer)session.save(customer);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            throw new ModelException("Failed to add customer. " + ex.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void truncate() throws ModelException
    {
         try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "TRUNCATE TABLE customers";
            NativeQuery ps = session.createSQLQuery(sql);
            ps.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
             throw new ModelException("Failed to truncate customers table. " + ex.getMessage());
        } finally {
            session.close();
        }
    }
}
