package cit360.drazen.model;

import cit360.drazen.exceptions.ModelException;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerDAOTest {
    
    private static final Customer VALERIE = new Customer();
    private static final Customer WILLIAM = new Customer();
    private static final Customer MARY = new Customer();
        
    @Before
    public void setUp() {
        VALERIE.setFirstName("Valerie");
        VALERIE.setLastName("Smith");
        VALERIE.setPhone("609-359-6127");
        VALERIE.setMobile("479-477-1548");
        VALERIE.setEmail("valerie@iffymedia.com");
        VALERIE.setStreet("3326  Lake Road");
        VALERIE.setCity("Dardanelle");
        VALERIE.setStateCode("AR");
        VALERIE.setZipCode(72834);
        
        WILLIAM.setFirstName("William");
        WILLIAM.setLastName("Pippin");
        WILLIAM.setPhone("662-778-3058");
        WILLIAM.setMobile("601-463-7979");
        WILLIAM.setEmail("william@thrubay.com");
        WILLIAM.setStreet("798  Tanglewood Road");
        WILLIAM.setCity("Moscow");
        WILLIAM.setStateCode("MS");
        WILLIAM.setZipCode(38057);
        
        MARY.setFirstName("Mary");
        MARY.setLastName("Schwenk");
        MARY.setPhone("201-502-8669");
        MARY.setMobile("201-600-3562");
        MARY.setEmail("mary@fakemailgenerator.net");
        MARY.setStreet("2489  Walnut Avenue");
        MARY.setCity("Lyndhurst");
        MARY.setStateCode("NJ");
        MARY.setZipCode(7071);
        
        CustomerDAO dao = CustomerDAO.getInstance();
        try {
            dao.truncate();
        } catch (ModelException ex) {
            System.err.println("Unexpected exception. " + ex.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CustomerDAO result = CustomerDAO.getInstance();
        assertThat(result).isNotNull();
    }
    
    @Test
    public void testaddCustomer() {
        System.out.println("addCustomer");
        try {
            CustomerDAO dao = CustomerDAO.getInstance();
            Integer maryId = dao.addCustomer(MARY);
            assertThat(maryId).isNotNull();
            Integer valerieId = dao.addCustomer(VALERIE);
            assertThat(valerieId).isNotNull();
            Integer williamId = dao.addCustomer(WILLIAM);
            assertThat(williamId).isNotNull(); 
        } catch (ModelException ex) {
            fail("Unexpected exception. " + ex.getMessage());
        }
    }
    
    @Test
    public void testaddCustomer_Duplicate() {
        System.out.println("addCustomer_Duplicate");
        try {
            CustomerDAO dao = CustomerDAO.getInstance();
            dao.addCustomer(MARY);
            dao.addCustomer(MARY);
            fail("Exception expected.");
        } catch (ModelException ex) {
            assertThat(ex.getMessage()).contains("customer");
        }
    }
    
    @Test
    public void testConveertStateToUpperCase() {
        System.out.println("testConveertStateToUpperCase");
        MARY.setStateCode(" tx ");
        assertThat(MARY.getStateCode()).isEqualTo("TX");
        assertThat(MARY.getStateCode()).isNotEqualTo("tx");
    }
    
    @Test
    public void testConveertEmailToUpperCase() {
        System.out.println("testConveertEmailToUpperCase");
        String email = "  TeTTT34@TeST.CoM  ";
        MARY.setEmail(email);
        assertThat(MARY.getEmail()).isEqualTo(email.trim().toLowerCase());
        assertThat(MARY.getEmail()).isNotEqualTo(email.trim());
    }

    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        try {
            CustomerDAO dao = CustomerDAO.getInstance();
            Integer maryId = dao.addCustomer(MARY);
            Customer customer = dao.getCustomer(maryId);
            assertThat(customer).isEqualTo(MARY);
            assertThat(customer).isNotSameAs(MARY);
        } catch (ModelException ex) {
            fail("Unexpected exception. " + ex.getMessage());
        }
    }
    
    /**
     * Test of getCustomers method, of class CustomerDAO.
     */
    @Test
    public void testGetCustomers() {
        System.out.println("getCustomers");
        try {
            CustomerDAO dao = CustomerDAO.getInstance();
            dao.addCustomer(MARY);
            dao.addCustomer(VALERIE);
            dao.addCustomer(WILLIAM);
            List<Customer> customers = dao.getCustomers();
            assertThat(customers)
                    .hasSize(3)
                    .containsExactlyInAnyOrder(MARY, VALERIE, WILLIAM);
        } catch (ModelException ex) {
            fail("Unexpected exception. " + ex.getMessage());
        }
    }
}