package productsdemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {
    SessionFactory factory = null;
    Session session = null;
    
    private static ProductDAO singleInstance = null;
    
    private ProductDAO()
    {
        factory = HibernateUtils.getSessionFactory();
    }
    
    public static ProductDAO getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new ProductDAO();
        }
        return singleInstance;
    }
    
    public List<Product> getProducts()
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from productsdemo.Product";
            List<Product> customers;
            customers = (List<Product>)session.createQuery(sql).getResultList();
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
    
    public Product getProduct(int id)
    {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql;
            sql = "from productsdemo.Product where id=" + Integer.toString(id);
            Product customer;
            customer = (Product)session.createQuery(sql).getSingleResult();
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
