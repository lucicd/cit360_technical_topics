<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cit360.drazen.model.Customer"%>
<%
    List<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
    if (customers.size() > 0) {
%>
<table class="table table-striped table-bordered table-hover">
    <caption>Customers</caption>
    <thead class="thead-dark">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Phone</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Customer customer : customers) {
        %>
        <tr>
            <td><%= customer.getFirstName()%></td>
            <td><%= customer.getLastName()%></td>
            <td><%= customer.getEmail()%></td>
            <td><%= customer.getMobile()%></td>
            <td><%= customer.getPhone()%></td>
            <td><%= customer.getStreet()%></td>
            <td><%= customer.getCity()%></td>
            <td><%= customer.getStateCode()%></td>
            <td><%= customer.getZipCode()%></td>
            <td>
                <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                    <a href="/CustomersApp/customers?action=edit&id=<%= customer.getId()%>"
                       class="btn btn-secondary">Edit</a>
                    <a href="/CustomersApp/customers?action=details&id=<%= customer.getId()%>" 
                       class="btn btn-secondary">Details</a>
                    <a href="/CustomersApp/customers?action=delete&id=<%= customer.getId()%>" 
                       class="btn btn-warning">Delete</a>
                </div>
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
} else {
%>
<h1>No customer record found.</h1>
<%
    }
%>