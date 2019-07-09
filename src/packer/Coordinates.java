package packer;

/**
 *
 * @author I.M.Bad
 */
/**
* The Coordinates class is used for address locations and to work out distances between coordinates
*/
public class Coordinates {

    private final double x;
    private final double y;
    /**
 *
 * used to create the coordinates
 * @param x the x coordinate
 * @param y the y coordinate
 * 
 */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
 *
 * @return the x coordinate 
 */
    public double getX() {
        return x;
    }
    /**
 *
 * @return the x coordinate 
 */
    public double getY() {
        return y;
    }
    /**
 *
 * @return the euclidean distance between this coordinate and the one passed
 * @param other the coordinate to get distance from
 * 
 */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff), 0.5);
        return dist;
    }
    /**
 *
 * @return the manhatten distance between this coordinate and the one passed
 * @param other the coordinate to get distance from
 * 
 */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    /**
 *
 * @return the distance the company uses for freight between this coordinate and the one passed
 * @param other the coordinate to get distance from
 * 
 */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1), 0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        //return (dist1 + dist2)/2;  needs 1 added
        return (dist1 + dist2) / 2 + 1;
    }

}
