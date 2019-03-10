package cit360.drazen.controller;

import cit360.drazen.model.Customer;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CustomerHelpers {
    public static Set<ConstraintViolation<Customer>> validate(Customer customer)
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        return violations;
    }
    
    public static Customer createCustomer(HttpServletRequest request)
    {
        Customer customer = new Customer();
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setEmail(request.getParameter("email"));
        customer.setMobile(request.getParameter("mobile"));
        customer.setPhone(request.getParameter("phone"));
        customer.setStreet(request.getParameter("street"));
        customer.setCity(request.getParameter("city"));
        customer.setStateCode(request.getParameter("stateCode"));
        String zipCode = request.getParameter("zipCode");
        if (zipCode != null) {
            customer.setZipCode(Integer.parseInt(zipCode));
        }
        return customer;
    }
}
