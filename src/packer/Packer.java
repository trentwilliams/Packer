package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
/**
* The Packer class converts a manifest (order) into boxes, by packing efficiently
*/
public class Packer {

    public static List<Box> packProducts(Customer c, Depot d, Manifest m, double boxCapacity) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;

        while (!m.isEmpty()) { // repeat until all items are packed

            if (b == null) {

                //b = new Box(d,c);  swap c & d
                b = new Box(c, d, boxCapacity);
                System.out.println("\n-----  New Box -----");
            }

            //find out how much space left in box
            //System.out.println("capacity before add " + b.remainingCapacity());
            //System.out.println("current " + b.getWeight());
            //meets criteria
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            } else {

                System.out.println("Adding: " + prodToAdd);

                // this modifies the weight.... not working correctly?
                b.addProduct(prodToAdd);

                // Working correctly
                m.removeProduct(prodToAdd);

            }

        }

        if (b != null) {
            packedBoxes.add(b);
            //packedBoxes.add(b);  duplicated
        }
        return packedBoxes;
    }
}
