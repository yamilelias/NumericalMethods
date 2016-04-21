package polynomial;

/**
 *
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 1.0
 * @since 2016-04-20
 */
public final class Pair {
    /**
     * The x value
     */
    public double x = 0.0;
    /**
     * The y value
     */
    public double y = 0.0;

    /**
     * Only constructor for the class that recieves two paramethers
     * @param double x  The x value
     * @param double y  The y value
     */
    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to print up the x,y values
     * @return The x,y values in a string form
     */
    public String toString() {
        return "" + this.x + "," + this.y;
    }
}

