package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
/**
* The Customer class contains customer name and addresses
*/
public class Customer {

    private String name;
    private List<Address> addresses;
    /**
 *
 * used to create the customer and add addresses to them
 * @param name name of the customer
 * @param address the address of the customer
 */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    /**
 *
 * used to add an address
 * @param address the address of the customer
 */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    /**
 *
 * @return the name of the customer
 */
    public String getName() {
        return name;
    }
    /**
 *
 * used to get the customers address that is closest to depot
 * @param d the depot
 * @return address that is closed to the depot
 */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            //System.out.println("distance "+distance);
            if (distance < bestDistance) {
                //System.out.println("best");
                // not updating best distance
                bestDistance = distance;
                bestAddress = a;

            }
        }
        return bestAddress;
    }
    /**
 *
 * @return the name of the customer
 */
    public String toString() {
        return this.getName();
    }
}
