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
import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.MethodSorters;

/**
 *
 * @author trent
 */

public class ManifestTest {
    
    
     // Test data

    Coordinates testCoordinates0 = new Coordinates(1, 1);
    Address testAddress0 = new Address("number", "street", "suburb", "city", testCoordinates0);
    Customer customer1  = new Customer("test",testAddress0);
    
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Depot testDepot1 = new Depot("City Depot", testAddress1);
    Depot testDepot2 = new Depot("Suburbs Depot", testAddress2);
    Depot testDepot3 = new Depot("Country Depot", testAddress3);
    
    Product testProduct1=new Product("a",1,false,false);
    Product testProduct2=new Product("b",10,true,false);
    Product testProduct3=new Product("c",100,false,true);    
    Product testProduct4=new Product("d",1000,true,true);   
   
    

        
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//  @Before
//    public void setUp() throws Exception {
//        System.out.println("test before");
//    }
    
    
    /**
    * Test of AddProduct_prod being passed an int method, of class Manifest.
     */ 
    @Test
    public void testAddProduct_prod_int(){
        
        System.out.println("Testing add product INT...");
        
        Manifest testManifest1 = new Manifest();
        Manifest testManifest2 = new Manifest();
        Manifest testManifest3 = new Manifest();
        Manifest testManifest4 = new Manifest();

        testManifest1.addProduct(testProduct1,1);
        
        testManifest2.addProduct(testProduct1,1);
        testManifest2.addProduct(testProduct2,1);
        testManifest2.addProduct(testProduct3,1);
        
        testManifest3.addProduct(testProduct3,1);
        
        testManifest4.addProduct(testProduct4,1);
        testManifest4.addProduct(testProduct4,2);
        testManifest4.addProduct(testProduct4,5);
        
        assertEquals("a x 1",testManifest1.toString());
        assertEquals("a x 1\nb x 1\nc x 1",testManifest2.toString());
        assertEquals("c x 1",testManifest3.toString());
        assertEquals("d x 8",testManifest4.toString());
    }
    
    /**
    * Test of AddProduct_prod being passed only product, of class Manifest.
     */ 
    @Test
    public void testAddProduct_prod(){
        
        System.out.println("Testing add product ONLY...");
        
        Manifest testManifest1 = new Manifest();
        Manifest testManifest2 = new Manifest();
        Manifest testManifest3 = new Manifest();

        testManifest1.addProduct(testProduct1);
        testManifest2.addProduct(testProduct2);
        testManifest3.addProduct(testProduct3);
        testManifest3.addProduct(testProduct3);
        
        
        assertEquals("a x 1",testManifest1.toString());
        assertEquals("b x 1",testManifest2.toString());
        assertEquals("c x 2",testManifest3.toString());
    }
    
    
    /**
    * Test of isEmpty method, of class Manifest.
     */ 
    @Test
    public void testIsEmpty() {
        
        System.out.println("Testing is empty...");
        
        Manifest testManifest1 = new Manifest();
        Manifest testManifest2 = new Manifest();
        
        testManifest2.addProduct(testProduct2,1);

        assertEquals(true, testManifest1.isEmpty());
        assertEquals(false, testManifest2.isEmpty());
    }
    
    
    /**
    * Test of remove product method, of class Manifest.
     */ 
    @Test
    public void testRemoveProduct() {
        
        System.out.println("Testing remove product...");
        
        Manifest testManifest1 = new Manifest();
        
        testManifest1.addProduct(testProduct1,1);
        testManifest1.addProduct(testProduct2,1);
        testManifest1.addProduct(testProduct3,1);
        testManifest1.addProduct(testProduct4,1);
        
        assertEquals("a x 1\nb x 1\nc x 1\nd x 1",testManifest1.toString());
        
        testManifest1.removeProduct(testProduct2);
        
        assertEquals("a x 1\nc x 1\nd x 1",testManifest1.toString());

        testManifest1.removeProduct(testProduct1);
        
        assertEquals("c x 1\nd x 1",testManifest1.toString());
        
    }
    
        //public double getTotalWeight() {
        //public Product getHeaviestUnder(double weight) {
        //public boolean containsProduct(Product p) {
        //public boolean hasFragileItems() {
        //public boolean hasHazardousItems() ()
        
    
    
    
    
    
}
