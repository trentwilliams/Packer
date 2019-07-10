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
    Product a0 = new Product("TestProduct1", 10, true, true);
    Product a1 = new Product("TestProduct1", 8, true, true);
    Product a2 = new Product("TestProduct1", 11, true, true);
    Product a3 = new Product("TestProduct2", 12, true, true);
    Product a4 = new Product("TestProduct3", 13, true, true);

    // specifiy the capatcity of a box
    double boxCapacity = 20;

    @BeforeClass
    public static void setUpClass() {

        System.out.println("\n#############################\nTesting Packer class...");

    }

    /**
     * Test of getName method, of class Depot.
     */
    @Test
    public void testPackProductsSimple() {
        System.out.println("Testing the packer to make sure it packs the correct number of boxes ...");

        manifest.addProduct(a0, 10);

        List<Box> testList1 = Packer.packProducts(customer, depot, manifest, boxCapacity);

        // test size of list
        assertEquals(5, testList1.size(), 0);

    }

    @Test
    public void testPackProductsFull() {
        System.out.println("Testing the packer in great detail...");

        manifest.addProduct(a1, 5);

        List<Box> testList1 = Packer.packProducts(customer, depot, manifest, boxCapacity);

        // test size of list
        assertEquals(3, testList1.size(), 0);

        //get box 2 and check paramaters
        assertEquals(true, testList1.get(1).isHazardous());
        assertEquals(true, testList1.get(1).isFragile());

        // get box 3 and try to fit items
        assertEquals(true, testList1.get(2).canFit(a2));
        assertEquals(true, testList1.get(2).canFit(a3));
        assertEquals(false, testList1.get(2).canFit(a4));

        // get box 3 and get weight and how much cpacity is left
        assertEquals(12.0, testList1.get(2).remainingCapacity(), 0);
        assertEquals(8.0, testList1.get(2).getWeight(), 0);

    }

}
