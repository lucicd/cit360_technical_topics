/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemodrazen;

import java.util.List;

/**
 *
 * @author Drazen
 */
public class HibernateDemoDrazen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonTestDAO p = PersonTestDAO.getInstance();

        List<Person> c = p.getPersons();
        for (Person i : c) {
            System.out.println(i);
        }

//        System.out.println(p.getPersonEntity(1));
//        
//        Product r = Product.getInstance();
//
//        List<ProductEntity> d = r.getProductEntitys();
//        for (ProductEntity i : d) {
//            System.out.println(i);
//        }
//
//        System.out.println(r.getProductEntity(1));
        
    }
    
}
