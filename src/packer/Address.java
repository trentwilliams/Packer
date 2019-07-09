package packer;

/**
 *
 * @author I.M.Bad
 */
public class Address {

    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;
    
    /**
 *
 * used to create the address
 * @param street the street part of the address
 * @param suburb the suburb part of the address
 * @param city the city part of the address
 * @param postcode the post code for the address
 * @param coordinates the location of the address
 */

    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
    
    /**
 *
 * @return the address
 */

    public String toString() {
        return street + "\n"
                + suburb + "\n"
                + city + "\n"
                + postcode;
    }

    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

}
