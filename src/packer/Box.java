package packer;

/**
 *
 * @author I.M.Bad
 */
/**
* The Box class contains items and holds the customer and contents details via a manifest
*/
public class Box {

    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private double capacity;
    /**
 *
 * used to create the box
 * @param customer the customer 
 * @param depot the depot the good will be dispatched from
 * @param capacity the size of the box
 */
    public Box(Customer customer, Depot depot, double capacity) {
        this.customer = customer;
        this.depot = depot;
        this.capacity = capacity;
        contents = new Manifest();
    }

    /**
     * adds 1x product to box
     * @param product the product to add
     */
    // adding a product to the box
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

//      public void addProduct(Product product) {
//        if (canFit(product)) {
//            contents.addProduct(product, 1);
//        }
//    }  
    /**
     * @param product the product to add
     * @param quantity they number of items to add
     * adds quantity x product to box
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product, quantity));
        {
            contents.addProduct(product, quantity);
        }
    }

    /**
     * @return the label of the box
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()) {
            label.append("HAZARDOUS\n");
        }
        return label.toString();
    }

    /**
     *
     * @return the label of the box
     */
    @Override
    public String toString() {
        return getLabel();
    }

    /**
     * @return the weight of the box
     */
    public double getWeight() {
        //return contents.getWeight();
        return contents.getTotalWeight();

    }

    /**
     * @param p product to try
     * @return the given product x1 can fit in box
     */
    public boolean canFit(Product p) {

//        System.out.println("box contents " + this.getWeight());
//        System.out.println("product " + p.getWeight());
        //return p.getWeight() < 20;  comparing against 20 always
        return p.getWeight() <= this.remainingCapacity();

    }

    /**
     * @param quantity the number of items to try
     * @param p product to try
     * @return the given product x quantity can fit in box
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < this.capacity;
    }

    /**
     * @return how much space is left in box
     */
    public double remainingCapacity() {
        return this.capacity - this.getWeight();
    }

    /**
     * @return if box contains fragile item
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }

    /**
     * @return if box contains hazardous item
     */
    public boolean isHazardous() {
        //return false; needs to return contest has hazardous
        return contents.hasHazardousItems();
    }
}
