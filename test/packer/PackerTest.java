/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import static packer.CoordinatesTest.ACCEPTABLE_DELTA;

/**
 *
 * @author trent
 */
public class PackerTest {
    
    
    

        
        
                Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Customer customer = new Customer("Andy Bravo", customerAddress1);

        Manifest manifest = new Manifest();
            Product a1 = new Product("TestProduct", 10, true, true);
           
            
        
        // specifiy the capatcity of a box
        double boxCapacity = 20;
    

        
        
         @BeforeClass
    public static void setUpClass() {
        
        System.out.println("Testing Packer class...");



    }
    
    /**
     * Test of getName method, of class Depot.
     */
    @Test
    public void testPackProducts() {
                System.out.println("Testing the packer ...");
        
                manifest.addProduct(a1,5);
                
                List<Box> testList1 = Packer.packProducts(customer, depot, manifest, boxCapacity);
                
                assertEquals(3,testList1.size(),0);
                
                manifest.addProduct(a1,10);
                
                List<Box> testList2 = Packer.packProducts(customer, depot, manifest, boxCapacity);
                
                assertEquals(5,testList2.size(),0);          
                
                

    }
    
}
