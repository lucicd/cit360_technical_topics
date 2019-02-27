<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cit360.drazen.model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            List<Customer> customers = 
                    (ArrayList<Customer>)request.getAttribute("customers");
            if (customers.size() > 0)
            {
        %>
        <div class="container">    
            <h1>Customers</h1>
            <table class="table table-striped table-bordered table-hover">
                <caption>Customers</caption>
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Phone</th>
                        <th>Street</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    for (Customer customer: customers)
                    {
                        %>
                        <tr>
                            <td scope = "row"><%= customer.getId() %></td>
                            <td><%= customer.getFirstName() %></td>
                            <td><%= customer.getLastName() %></td>
                            <td><%= customer.getEmail() %></td>
                            <td><%= customer.getMobile() %></td>
                            <td><%= customer.getPhone() %></td>
                            <td><%= customer.getStreet() %></td>
                            <td><%= customer.getCity() %></td>
                            <td><%= customer.getStateCode() %></td>
                            <td><%= customer.getZipCode() %></td>
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
        </div>
    </body>
</html>
