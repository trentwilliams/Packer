package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
public class Packer {

    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        double boxleft;
        Box b = null;
        
        //Lopping through all items on manifest
        while (!m.isEmpty()) { // repeat until all items are packed
            
            //fill a box, then move onto next box
            
            if (b == null) {
                b = new Box(c,d);

            }
            boxleft=b.remainingCapacity();
            System.out.println("weight left " +boxleft);
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            
            System.out.println("product to add " + prodToAdd);
            
            if (prodToAdd == null  ) {
                
                packedBoxes.add(b);
                System.out.println("\n\n box added");
                b = null;
            }
            else {
                b.addProduct(prodToAdd);
                System.out.println("PACKING " +prodToAdd);
                m.removeProduct(prodToAdd);
                System.out.println("REMOVED " +prodToAdd);          
            }  
        }
        
        
        
        if (b != null) {
            packedBoxes.add(b);
            packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}
