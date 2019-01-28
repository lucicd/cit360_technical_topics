/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Drazen
 */
public class ShowQuotesView extends AbstractView {

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("=======================================");
        System.out.println("Quotes");
        System.out.println("=======================================");
        List<Map<String, Object>> quotes = 
                (List<Map<String, Object>>)data.get("quotes");
        for (Map<String, Object> quote: quotes)
        {
            System.out.format("Cust:\t %s\n", quote.get("customer"));
            System.out.format("Width:\t %5.2f inch\n", quote.get("width"));
            System.out.format("Depth:\t %5.2f inch\n", quote.get("depth"));
            System.out.format("Area:\t %6.2f sq inch\n", quote.get("area"));
            System.out.format("Drawers:\t %d\n", quote.get("drawers"));
            System.out.format("Mat:\t %s\n", quote.get("surface"));
            System.out.format("Build:\t %s\n", quote.get("buildtime"));
            System.out.format("Price:\t $%6.2f\n", quote.get("price"));
            System.out.println();
        }
    }
    
}
