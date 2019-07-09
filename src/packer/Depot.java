package packer;

/**
 *
 * @author I.M.Bad
 */
/**
* The Depot class contains depot name and addresses
*/
public class Depot {

    private String name;
    private Address address;
    /**
 *
 * used to create the depot
 * @param name the customer 
 * @param address the address of the depot
 */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    /**
     *
     * @return the name this depot belongs to
     */
    public String getName() {
        //return address.toString();  changed to name
        return name.toString();
    }
    /**
     *
     * @return the coordinates of this depot
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    /**
     *
     * @return the name this depot belongs to
     */
    public String toString() {
        return this.getName();
    }

}
