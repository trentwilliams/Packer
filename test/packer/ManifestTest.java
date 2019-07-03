/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author trent
 */
public class ManifestTest {
    
    
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
    
    Product testProduct0=new Product("test",7,false,false);
    
    

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
        
        
        

        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
        
    @Test
    public void testIsEmpty() {
        
        System.out.println("Testing is empty...");
        
        Manifest testManifest1=new Manifest();
        

        assertEquals(true, testManifest1.isEmpty());
        //assertEquals(20.0, box1.remainingCapacity(),0);
        //assertEquals(40.0, box2.remainingCapacity(),0);

    }

    @Test
    public void testAddProduct(){
        
        System.out.println("Testing add product...");

        Manifest manifest = new Manifest();
        
        manifest.addProduct(testProduct0);
        System.out.println(""+testProduct0);
        System.out.println(""+manifest);
        //assertEquals
        
        


//manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        
    }

    /**
     * Test of addProduct method, of class Manifest.
     */
//    @Test
//    public void testAddProduct_Product() {
////        System.out.println("addProduct");
////        Product p = null;
////        Manifest instance = new Manifest();
////        instance.addProduct(p);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addProduct method, of class Manifest.
//     */
//    @Test
//    public void testAddProduct_Product_int() {
////        System.out.println("addProduct");
////        Product p = null;
////        int quantity = 0;
////        Manifest instance = new Manifest();
////        instance.addProduct(p, quantity);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeProduct method, of class Manifest.
//     */
//    @Test
//    public void testRemoveProduct() {
////        System.out.println("removeProduct");
////        Product p = null;
////        Manifest instance = new Manifest();
////        instance.removeProduct(p);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTotalWeight method, of class Manifest.
//     */
//    @Test
//    public void testGetTotalWeight() {
////        System.out.println("getTotalWeight");
////        Manifest instance = new Manifest();
////        double expResult = 0.0;
////        double result = instance.getTotalWeight();
////        assertEquals(expResult, result, 0.0);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHeaviestUnder method, of class Manifest.
//     */
//    @Test
//    public void testGetHeaviestUnder() {
////        System.out.println("getHeaviestUnder");
////        double weight = 0.0;
////        Manifest instance = new Manifest();
////        Product expResult = null;
////        Product result = instance.getHeaviestUnder(weight);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of containsProduct method, of class Manifest.
//     */
//    @Test
//    public void testContainsProduct() {
////        System.out.println("containsProduct");
////        Product p = null;
////        Manifest instance = new Manifest();
////        boolean expResult = false;
////        boolean result = instance.containsProduct(p);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Manifest.
//     */
//    @Test
//    public void testToString() {
////        System.out.println("toString");
////        Manifest instance = new Manifest();
////        String expResult = "";
////        String result = instance.toString();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hasFragileItems method, of class Manifest.
//     */
//    @Test
//    public void testHasFragileItems() {
////        System.out.println("hasFragileItems");
////        Manifest instance = new Manifest();
////        boolean expResult = false;
////        boolean result = instance.hasFragileItems();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
    
    
}
