<%@page import="java.util.Objects"%>
<%@page import="cit360.drazen.model.Customer"%>
<%
    Customer customer = (Customer)request.getAttribute("customer");
    if (customer == null)
    {
        customer = new Customer();
    }
%>
<form 
    class="needs-validation" novalidate 
    method="post" 
    action="/CustomersApp/customers?action=insert"
>
    <input type="hidden"
           value="<%=customer.getId()%>"
           id ="id">
    <div class="form-group">
        <label for="firstName">First name:</label>
        <input type="text"
               value="<%=Objects.toString(customer.getFirstName(),"")%>"
               class="form-control" 
               id="firstName" 
               name="firstName" 
               placeholder="Enter first name" 
               required>
        <div class="invalid-feedback">
            Please input first name.
        </div>
    </div>
    <div class="form-group">
        <label for="firstName">Last name:</label>
        <input type="text"
               value="<%=Objects.toString(customer.getLastName(),"")%>"
               class="form-control"
               id="lastName"
               name="lastName"
               placeholder="Enter last name"
               required>
        <div class="invalid-feedback">
            Please input last name.
        </div>
    </div>
    <div class="form-group">
        <label for="phone">Phone:</label>
        <input type="text" 
               class="form-control" 
               id="phone" 
               name="phone" 
               placeholder="Phone number">
    </div>
    <div class="form-group">
        <label for="mobile">Mobile:</label>
        <input type="text"
               class="form-control" 
               id="mobile" 
               name="mobile" 
               placeholder="Mobile number"
               required>
        <div class="invalid-feedback">
            Please input mobile.
        </div>
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" 
               class="form-control" 
               id="email" 
               name="email" 
               placeholder="Email address"
               required>
        <div class="invalid-feedback">
            Please input email.
        </div>
    </div>
    <div class="form-group">
        <label for="email">Street:</label>
        <input type="text"
               class="form-control"
               id="street"
               name="street"
               placeholder="Street">
    </div>
    <div class="form-group">
        <label for="city">City:</label>
        <input type="text" 
               class="form-control" 
               id="city" 
               name="city" 
               placeholder="City">
    </div>
    <div class="form-group">
        <label for="stateCode">State:</label>
        <input type="text" 
               class="form-control" 
               id="stateCode" 
               name="stateCode" 
               placeholder="State">
    </div>
    <div class="form-group">
        <label for="zipCode">Zip:</label>
        <input type="text" 
               class="form-control" 
               id="zipCode" 
               name="zipCode" 
               placeholder="Zip Code">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <a href="/CustomersApp/customers">Back to list</a>
</form>
