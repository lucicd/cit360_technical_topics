/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DeskQuote;
import model.Quotes;
import view.AbstractView;
import view.ShowQuotesView;

/**
 *
 * @author Drazen
 */
public class ShowQuotesHandler implements IHandler {

    @Override
    public void handleIt(Controller controller, Map<String, Object> data) {
        List<DeskQuote> quotes = Quotes.getAll();
        List<Map<String, Object>> viewQuotes = new ArrayList<>();
        for (DeskQuote quote: quotes)
        {
            Map<String, Object> viewQuote = new HashMap<>();
            viewQuote.put("customer", quote.getCustomer());
            viewQuote.put("width", quote.getDesk().getWidth());
            viewQuote.put("depth", quote.getDesk().getDepth());
            viewQuote.put("area", quote.getDesk().getArea());
            viewQuote.put("drawers", quote.getDesk().getNumberOfDrawers());
            viewQuote.put("surface", quote.getDesk().getSurfaceType().getName());
            viewQuote.put("buildtime", quote.getDesk().getBuildTime().getName());
            viewQuote.put("price", quote.getPrice());
            viewQuotes.add(viewQuote);
        }
        
        Map<String, Object> viewData = new HashMap<>();
        viewData.put("quotes", viewQuotes);
        AbstractView view = new ShowQuotesView();
        view.render(viewData);
    }
    
}
