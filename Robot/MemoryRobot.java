package Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/**
 * This java class extends the RandomRobot. The MemoryRobot is a
 * robot that uses an arraylist to remember the positions it has visited
 * to avoid going there again, also the memory robot uses a stack to be able
 * to backtrack its old positions until it finds a position that has not been
 * visited.
 * @author Jonatan Westling, c22jwg
 * @version v2. 2023-05-11: Second public version
 */
public class MemoryRobot extends RandomRobot {
    private final Maze maze;
    public ArrayList<Position> positionsVisited;
    private Stack<Position> goBackPath;

    /**
     * Constructor that creates a MemoryRobot object.
     * @param maze the maze that the robot will traverse.
     */
    public MemoryRobot(Maze maze) {
        //set maze, position and positions visited for this robot
        super(maze);
        this.maze = maze;
        this.positionsVisited = new ArrayList<>();
        this.goBackPath = new Stack<>();
    }

    /**
     * The move method that moves the memory robot as described, in the first place
     * the robot moves to a new position that not has been discovered before. If
     * the robot does not find a new position, the robot goes back in the same path
     * it came from until it finds a new connecting position that has not been visited before.
     */
    @Override
    public void move() {
        Position pos = this.getPosition();
        goBackPath.push(pos);
        positionsVisited.add(pos);
        //add all positions to list of possible moves
        ArrayList<Position> possibleMoves = new ArrayList<>(Arrays.asList(pos.getPosToEast(),
                                            pos.getPosToSouth(),pos.getPosToWest(), pos.getPosToNorth()));
        //remove all positions that is not a new possible position
        possibleMoves.removeIf(p -> !maze.isMovable(p) || positionsVisited.contains(p));
        possibleMoves.removeIf(p -> !maze.isMovable(p) && positionsVisited.contains(p));
        if (possibleMoves.size() == 0) {
            //remove current pos
            goBackPath.pop();
            //set previous to current.
            setPosition(goBackPath.peek());
            //new current pos, remove from stack
            goBackPath.pop();
        } else {
            //randomize a direction to go
            int random = (int) (Math.random() * possibleMoves.size());
            Position move = possibleMoves.get(random);
            setPosition(move);
        }
    }
}
