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
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            
            
            if (b == null) {
                
                //b = new Box(d,c);  swap c & d
                b = new Box(c,d,20);
            }

            
            //find out how much space left in box
            System.out.println("capacity before add " + b.remainingCapacity());
            //System.out.println("current " + b.getWeight());
            //meets criteria
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
            
                System.out.println("\nPacking "+ prodToAdd);
                
                // this modifies the weight.... not working correctly?
                b.addProduct(prodToAdd);
             
                // Working correctly
                m.removeProduct(prodToAdd);
                
                System.out.println("\nMANIFEST (to be packed):\n"+m);
                
            }  
            
            
            //find out how much space left in box
            //System.out.println("capacity after add " + b.remainingCapacity());

            
            
            
            
            
        }
        
        if (b != null) {
            packedBoxes.add(b);
            //packedBoxes.add(b);  duplicated
        }
        return packedBoxes;
    }    
}