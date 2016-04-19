package polynomial;

/**
 * Class to make Pair objects
 */
public final class Pair {
    public double x = 0.0;
    public double y = 0.0;

    /**
     * Only constructor for the class.
     * @param double x
     * @param double y
     */
    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * toString Method that prints both properties of the object
     */
    public String toString() {
        return "" + this.x + "," + this.y;
    }
}

