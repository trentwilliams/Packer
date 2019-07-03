/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author trent
 */
public class BoxTest {
    
    
     // Test data
    Coordinates testCoordinates0 = new Coordinates(1, 1);
    Address testAddress0 = new Address("number", "street", "suburb", "city", testCoordinates0);
    Customer customer0  = new Customer("test",testAddress0);


    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Depot testDepot1 = new Depot("City Depot", testAddress1);
    Depot testDepot2 = new Depot("Suburbs Depot", testAddress2);
    Depot testDepot3 = new Depot("Country Depot", testAddress3);
    
    
//    Product testProduct0=new Product("test",7,false,false);
    
    
    

    


    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
        

        
    }
        
    @Test
    public void testRemaingCapacity() {
        
        Box box0 = new Box(customer0, testDepot1,0.0);
        Box box1 = new Box(customer0, testDepot1,20.0);
        Box box2 = new Box(customer0, testDepot1,40.0);
        
        System.out.println("Testing remaining capacity...");
        assertEquals(0.0, box0.remainingCapacity(),0);
        assertEquals(20.0, box1.remainingCapacity(),0);
        assertEquals(40.0, box2.remainingCapacity(),0);
        
        //assertEquals("asdd","1asd");
        //assertEquals("1 First St\nAplace\nCitadel City\nA111", testAddress1.toString());
    }
}
