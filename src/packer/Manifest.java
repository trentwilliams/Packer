package packer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {

    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;

    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;
    /**
 *
 * used to create the manifest
 */
    public Manifest() {
        //quantities = new HashMap<>();   //change to LinkedHashMap 
        quantities = new LinkedHashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    /**
 *
 * add 1x product to the manifest
 * @param p the product to add 
 */
    public void addProduct(Product p) {
        addProduct(p, 1);
    }
    /**
 *
 * add x number of product to the manifest
 * @param p the product to add 
 * @param quantity the number of items to add
 */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            //quantities.put(p,quantities.get(p)*quantity);  change * to +
            quantities.put(p, quantities.get(p) + quantity);
        } else {
            quantities.put(p, quantity);
            if (!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    /**
 *
 * remove a product from  the manifest
 * @param p the product to remove
 */
    // removes products from manifest quantities and weight 
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p, quantities.get(p) - 1);
        }

        if (quantities.get(p) == 0) {
            quantities.remove(p);
        }

        //if (quantities.containsKey(p)) {  if not exists
        if (!quantities.containsKey(p)) {
            byWeight.remove(p);
        }
    }
    /**
 *
 * @return the total weight of all the products in the manifest
 */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            //weight = quantities.get(p) * p.getWeight();  not incrimenignt wight correcyly
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }

        /**
 *
 * @return the product that is closest to but under the given
 * @param weight the maximum the product can be
 */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {   // heaviest under includes <=
                return p;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return byWeight.isEmpty();
    }

    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length() - 1);
    }

    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }

    //*****  HAZARDOUS ITEMS
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }

}
