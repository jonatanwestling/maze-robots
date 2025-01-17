package Robot;
import java.util.Objects;
/**
 * This java class handles the positions of the robots.
 * @author Jonatan Westling, c22jwg.
 * @version v2. 2023-05-11: Second public version.
 */
public class Position {
    private final int x, y;

    /**
     * Creates an object that hold an x-value and a y-value.
     * @param x the x-value the object should hold.
     * @param y the y-value the object should hold.
     */
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method that returns the x-value of a position.
     * @return the x-value
     */
    public int getX() {
        return this.x;
    }

    /**
     * Method that returns the y-value of a position.
     * @return the y-value
     */
    public int getY() {
        return this.y;
    }

    /** Following four methods get a position for a step
     * at either north, south, east or west.
     *
     * @return the new position after a step at any direction.
     */
    public Position getPosToSouth() {
        return new Position(this.x, this.y +1);
    }
    public Position getPosToNorth() {
        return new Position(this.x, this.y - 1);
    }
    public Position getPosToEast() {
        return new Position(this.x + 1, this.y);
    }
    public Position getPosToWest() {
        return new Position(this.x - 1, this.y);
    }
    /**
     *  Method first checks if object is from the same class otherwise they can not be equal.
     *  Then method checks if the positions are the same.
     * @param o, object o to compare.
     * @return true or false.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        else return ((Position) o).x == this.x && ((Position) o).y == this.y;
    }
    /**
     * Generates a hashcode based from the x and y values.
     * @return hashcode of integers.
     */
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

