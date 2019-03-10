package cit360.drazen.model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CustomerTest {
    
    private Customer mary;
    private Validator validator;
    
    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        mary = new Customer();
        mary.setFirstName("Mary");
        mary.setLastName("Schwenk");
        mary.setPhone("201-502-8669");
        mary.setMobile("201-600-3562");
        mary.setEmail("mary@fakemailgenerator.net");
        mary.setStreet("2489  Walnut Avenue");
        mary.setCity("Lyndhurst");
        mary.setStateCode("NJ");
        mary.setZipCode(7071);
    }
    
    @Test
    public void testGoodRecord()
    {
        Set<ConstraintViolation<Customer>> violations = validator.validate(mary);
        assertThat(violations.isEmpty()).isTrue();
    }
    
    @Test
    public void testBadRecord_FirstName()
    {
        Set<ConstraintViolation<Customer>> violations;
        
        mary.setFirstName(null);
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
        
        mary.setFirstName("    ");
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
    }
    
    @Test
    public void testBadRecord_LastName()
    {
        Set<ConstraintViolation<Customer>> violations;
        
        mary.setLastName(null);
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
        
        mary.setLastName("    ");
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
    }
    
    @Test
    public void testBadRecord_Mobile()
    {
        Set<ConstraintViolation<Customer>> violations;
        
        mary.setMobile(null);
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
        
        mary.setMobile("    ");
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
    }
    
    @Test
    public void testBadRecord_Email()
    {
        Set<ConstraintViolation<Customer>> violations;
        
        mary.setEmail(null);
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
        
        mary.setEmail("    ");
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("may not be null");
    }
    
    @Test
    public void testBadRecord_StateCode()
    {
        Set<ConstraintViolation<Customer>> violations;
        
        mary.setStateCode("toolong");
        violations = validator.validate(mary);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("size must be between 0 and 2");
    }
}