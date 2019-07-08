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
    Customer customer1 = new Customer("test", testAddress0);

    Coordinates testCoordinates1 = new Coordinates(0, 0);
    Coordinates testCoordinates2 = new Coordinates(30, 40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Depot testDepot1 = new Depot("City Depot", testAddress1);
    Depot testDepot2 = new Depot("Suburbs Depot", testAddress2);
    Depot testDepot3 = new Depot("Country Depot", testAddress3);

    Product testProduct1 = new Product("a", 1, false, false);
    Product testProduct2 = new Product("b", 2, true, false);
    Product testProduct3 = new Product("c", 3, false, true);
    Product testProduct4 = new Product("d", 4, true, true);

//    Product testProduct0=new Product("test",7,false,false);
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");

    }

    @Test
    public void testRemaingCapacity() {

        System.out.println("Testing remaining capacity...");

        Box box0 = new Box(customer1, testDepot1, 0.0);
        Box box1 = new Box(customer1, testDepot1, 20.0);
        Box box2 = new Box(customer1, testDepot1, 40.0);

        assertEquals(0.0, box0.remainingCapacity(), 0);
        assertEquals(20.0, box1.remainingCapacity(), 0);
        assertEquals(40.0, box2.remainingCapacity(), 0);
    }

    @Test
    public void testAddProduct() {

        System.out.println("Testing add product ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);

        testBox1.addProduct(testProduct1);
        assertEquals(19.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct2);
        assertEquals(17.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct3);
        assertEquals(14.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct4);
        assertEquals(10.0, testBox1.remainingCapacity(), 0);

    }

    @Test
    public void testAddProduct_INT() {

        System.out.println("Testing add product with int (qty) ...");

        Box testBox1 = new Box(customer1, testDepot1, 40.0);

        testBox1.addProduct(testProduct1, 3);
        assertEquals(37.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct2, 2);
        assertEquals(33.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct3, 2);
        assertEquals(27.0, testBox1.remainingCapacity(), 0);

        testBox1.addProduct(testProduct4, 2);
        assertEquals(19.0, testBox1.remainingCapacity(), 0);

    }

    //public boolean isFragile() {
//public boolean isHazardous() {
    @Test
    public void testIsHazardous() {

        System.out.println("Testing is hazardous ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);

        testBox1.addProduct(testProduct1, 1);

        assertEquals(false, testBox1.isHazardous());

        testBox1.addProduct(testProduct2, 1);
        assertEquals(true, testBox1.isHazardous());

        testBox1.addProduct(testProduct3, 1);
        assertEquals(true, testBox1.isHazardous());

        testBox1.addProduct(testProduct4, 1);
        assertEquals(true, testBox1.isHazardous());

    }

    @Test
    public void testIsFragile() {

        System.out.println("Testing is Fragile ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);

        testBox1.addProduct(testProduct1, 1);

        assertEquals(false, testBox1.isFragile());

        testBox1.addProduct(testProduct2, 1);
        assertEquals(false, testBox1.isFragile());

        testBox1.addProduct(testProduct3, 1);
        assertEquals(true, testBox1.isFragile());

        testBox1.addProduct(testProduct4, 1);
        assertEquals(true, testBox1.isFragile());

    }

    @Test
    public void testGetLabel() {

        System.out.println("Testing get label ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);
        Box testBox2 = new Box(customer1, testDepot1, 20.0);

        testBox1.addProduct(testProduct1, 1);

        assertEquals("test\nnumber\nstreet\nsuburb\ncity\na x 1\n", testBox1.getLabel());

        testBox1.addProduct(testProduct2, 1);

        assertEquals("test\nnumber\nstreet\nsuburb\ncity\na x 1\nb x 1\nHAZARDOUS\n", testBox1.getLabel());

        testBox1.addProduct(testProduct4, 1);

        assertEquals("test\nnumber\nstreet\nsuburb\ncity\na x 1\nb x 1\nd x 1\nFRAGILE\nHAZARDOUS\n", testBox1.getLabel());

        testBox2.addProduct(testProduct3, 1);

        assertEquals("test\nnumber\nstreet\nsuburb\ncity\nc x 1\nFRAGILE\n", testBox2.getLabel());

    }

    @Test
    public void testGetWeight() {

        System.out.println("Testing the box weight ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);

        assertEquals(0.0, testBox1.getWeight(), 0);

        testBox1.addProduct(testProduct1);
        assertEquals(1.0, testBox1.getWeight(), 0);

        testBox1.addProduct(testProduct2, 3);
        assertEquals(7.0, testBox1.getWeight(), 0);

        testBox1.addProduct(testProduct3);
        assertEquals(10.0, testBox1.getWeight(), 0);

    }

    @Test
    public void testCanFit() {

        System.out.println("Testing the can fit ...");

        Box testBox1 = new Box(customer1, testDepot1, 3.0);

        assertEquals(true, testBox1.canFit(testProduct1));
        assertEquals(true, testBox1.canFit(testProduct2));

        assertEquals(true, testBox1.canFit(testProduct3));

        assertEquals(false, testBox1.canFit(testProduct4));

    }

    @Test
    public void testCanFitINT() {

        System.out.println("Testing the can fit with INT...");

        Box testBox1 = new Box(customer1, testDepot1, 10.0);

        assertEquals(true, testBox1.canFit(testProduct1, 3));
        assertEquals(false, testBox1.canFit(testProduct2, 6));

        assertEquals(true, testBox1.canFit(testProduct3, 1));

        assertEquals(false, testBox1.canFit(testProduct4, 8));

    }

    @Test
    public void testToString() {

        System.out.println("Testing get label ...");

        Box testBox1 = new Box(customer1, testDepot1, 20.0);

        testBox1.addProduct(testProduct1, 1);
        assertEquals("test\nnumber\nstreet\nsuburb\ncity\na x 1\n", testBox1.toString());

        testBox1.addProduct(testProduct3, 3);
        assertEquals("test\nnumber\nstreet\nsuburb\ncity\na x 1\nc x 3\nFRAGILE\n", testBox1.getLabel());

    }

}
