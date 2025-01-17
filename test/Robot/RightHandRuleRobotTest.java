package Robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
class RightHandRuleRobotTest {
    Maze maze;
    RightHandRuleRobot robot;
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
        robot = new RightHandRuleRobot(maze);
        s.close();
    }

    @Test
    void move() {
        //check so it follows the wall
        robot.move();
        assertEquals(new Position(1, 1),robot.getPosition());
        robot.move();
        assertEquals(new Position(1, 2),robot.getPosition());
        robot.move();
        assertEquals(new Position(2, 2),robot.getPosition());
        robot.move();
        assertEquals(new Position(3, 2),robot.getPosition());
    }


}