package Robot;
/**
 * This java class creates a robot that follow the maze the same way a human would,
 * with the right-hand rule.
 * @author Jonatan Westling, c22jwg
 * @version v1. 2023-04-26: First public version
 */
public class RightHandRuleRobot extends RandomRobot{

    private Maze maze;
    private Position position;
    private String direction;

    /**
     * Constructor that creates a RightHandRuleRobot object.
     * @param maze the maze that the robot will traverse
     */
    public RightHandRuleRobot(Maze maze) {
        //call constructor of superclass
        super(maze);
        this.maze = maze;
        //set a default direction to start
        this.direction = "SOUTH";
    }

    /**
     * This move method is based on the right hand rule, when the robot
     * move in the maze it will follow the right wall on the maze.
     */
    @Override
    public void move() {
        position = getPosition();
        Position north = position.getPosToNorth();
        Position east = position.getPosToEast();
        Position south = position.getPosToSouth();
        Position west = position.getPosToWest();

        switch (direction) {
            case "NORTH": //robot is facing north
                if (maze.isMovable(east)) {
                    setPosition(east);
                    //update the direction
                    this.direction = "EAST";
                } else if (maze.isMovable(north)) {
                    setPosition(north);
                    //no need to update direction
                } else if (maze.isMovable(west)) {
                    setPosition(west);
                    //update direction
                    this.direction = "WEST";
                } else if (maze.isMovable(south)){
                    setPosition(south);
                    //update direction
                    this.direction = "SOUTH";
                }
                break;

            case "EAST": // robot is facing east

                if (maze.isMovable(south)) {
                    setPosition(south);
                    //update the direction
                    this.direction = "SOUTH";
                } else if (maze.isMovable(east))
                {
                    setPosition(east);
                } else if (maze.isMovable(north)) {
                    setPosition(north);
                    this.direction = "NORTH";
                } else if (maze.isMovable(west)) {
                    //dead end move back
                    setPosition(west);
                    this.direction = "WEST";
                }
                break;

            case "SOUTH": //robot is facing south
                if (maze.isMovable(west)) {
                    setPosition(west);
                    //update the direction
                    this.direction = "WEST";
                } else if (maze.isMovable(south)) {
                    setPosition(south);
                    //no need to update direction
                } else if (maze.isMovable(east)) {
                    setPosition(east);
                    this.direction = "EAST";
                } else if (maze.isMovable(north)) {
                    setPosition(north);
                    this.direction = "NORTH";
                }
                break;

            case "WEST": //robot is facing west
                if (maze.isMovable(north)) {
                    setPosition(north);
                    this.direction = "NORTH";
                } else if (maze.isMovable(west)) {
                    setPosition(west);
                } else if (maze.isMovable(south)) {
                    setPosition(south);
                    this.direction = "SOUTH";
                } else if (maze.isMovable(east)){
                    setPosition(east);
                    this.direction = "EAST";
                }
                break;
            default:
                System.out.println("ERROR. getRobotDirection returned invalid value");
                System.exit(1);
                break;
        }
    }
}
