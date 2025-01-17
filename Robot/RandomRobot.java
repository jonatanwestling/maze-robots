package Robot;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This java class handles how the robot randomly choose a valid step in the maze.
 * If there aren't any possible moves forward or to the sides the robot goes back
 * to the previous position.
 * @author Jonatan Westling, c22jwg.
 * @version v1. v2. 2023-05-11: Second public version.
 */
public class RandomRobot implements Robot {
    private Position position;
    private Position previousPosition;
    private final Maze maze;

    /**
     * Constructor that creates a RandomRobot object.
     * @param maze the maze that the robot will traverse.
     */
    public RandomRobot(Maze maze) {
        this.maze = maze;
        this.position = this.maze.getStart();
        this.previousPosition = this.position;
    }

    /**
     * The move method that picks a random direction of the possible
     * positions it can pick which is the positions that are left in
     * the list possibleMoves. If there is no new position it can choose
     * (the list is empty) the robot will go back to previous position.
     */
    public void move() {
        //list to hold possible positions that is not the previous one
        Position pos = this.getPosition();
        //add all positions to the list
        ArrayList<Position> possibleMoves = new ArrayList<>(Arrays.asList(pos.getPosToEast(),
                                            pos.getPosToSouth(),pos.getPosToWest(), pos.getPosToNorth()));
        //remove all positions that is not a new possible position
        possibleMoves.removeIf(p -> !maze.isMovable(p) || previousPosition.equals(p));
        if (possibleMoves.size() == 0){
            //robot reached dead end, go back
            setPosition(previousPosition);
        }
        else {
            //randomize a direction to go
            int random = (int) (Math.random() * possibleMoves.size());
            Position move = possibleMoves.get(random);
            setPosition(move);
        }
    }

    /**
     * Gets the current position of the robot.
     * @return the current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Checks if the current position is the goal.
     * @return true or false depending on if the position is a goal or not.
     */
    public boolean hasReachedGoal() {
        return maze.isGoal(position);
    }

    /**
     * Sets a position to the current position.
     * @param p the position to set.
     */
    public void setPosition(Position p)
    {
        this.previousPosition = this.position;
        this.position = p;
    }
}