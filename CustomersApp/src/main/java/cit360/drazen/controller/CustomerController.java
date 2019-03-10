package cit360.drazen.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerController 
{
    private final Map<String,Handler> handlerMap = new HashMap();
    
    private static CustomerController singleInstance = null;
    
    private CustomerController()
    {
        mapAction("list", new GetCustomersHandler());
        mapAction("create", new CreateCustomerHandler());
        mapAction("edit", new EditCustomerHandler());
        mapAction("insert", new InsertCustomerHandler());
    }
    
    public static CustomerController getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new CustomerController();
        }
        return singleInstance;
    }

    public void handleRequest(String action, 
            HttpServletRequest request, HttpServletResponse response)
    {
        Handler actionHandler = 
                handlerMap.get(action == null ? "list" : action);
        if (actionHandler == null)
        {
            actionHandler = new UnknownActionHandler();
        } 
        actionHandler.handleIt(request, response);
    }

    private void mapAction(String action, Handler handler)
    {
        handlerMap.put(action, handler);
    }
}
