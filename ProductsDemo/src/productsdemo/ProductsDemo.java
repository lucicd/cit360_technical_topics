/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsdemo;

import java.util.List;

/**
 *
 * @author Drazen
 */
public class ProductsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductDAO t = ProductDAO.getInstance();

        List<Product> c = t.getProducts();
        for (Product i : c) {
            System.out.println(i);
        }

        System.out.println(t.getProduct(1));
    }
    
}
