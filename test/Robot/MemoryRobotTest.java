package Robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class MemoryRobotTest {
    private Maze maze;
    private MemoryRobot robot;
    @BeforeEach
    void setUp() throws Exception {
        String stringMaze = """
                *S***
                *   *
                *   *
                ***G*
                """;
        Scanner s = new Scanner(stringMaze);
        maze = new Maze(s);
        robot = new MemoryRobot(maze);
        s.close();
    }

    @Test
    void move() {
        robot.move();
        Position currentPos = robot.getPosition();
        assertTrue(maze.isMovable(currentPos));
        assertTrue(robot.positionsVisited.contains(currentPos));
    }
}