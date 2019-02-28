<!DOCTYPE html>
<html>
    <jsp:include page="../partials/head.jsp" />
    <body>
        <div class="container-fluid">    
            <h1>Customers</h1>
            <div class="row">
                <div class="col-sm">
                    <a href="/CustomersApp/customers?action=create" class="btn btn-primary">Create New</a>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <jsp:include page="table.jsp" />
                </div>
            </div>
        </div>
    </body>
</html>
