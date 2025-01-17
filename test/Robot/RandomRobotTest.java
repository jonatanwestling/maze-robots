package Robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RandomRobotTest {
    Maze maze;
    RandomRobot robot;

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
        //check that it only can go to pos 1, 1 after start
        assertFalse(maze.isMovable(new Position(0, 1)));
        assertFalse(maze.isMovable(new Position(1, 0)));
        assertFalse(maze.isMovable(new Position(2, 0)));
        assertTrue(maze.isMovable(new Position(1, 1)));
        //check so it moves to that position
        robot.move();
        assertEquals(new Position(1, 1), robot.getPosition());
        robot.move();
        assertNotEquals(new Position(1, 1), robot.getPosition());
    }

    @Test
    void getPosition() {
        Position pos = new Position(2, 3);
        robot.setPosition(pos);
        assertEquals(pos, robot.getPosition());

    }

    @Test
    void hasReachedGoal() {
        Position robotPos = new Position(1, 1);
        robot.setPosition(robotPos);
        Position goalPos = new Position(3, 3);
        assertFalse(robot.hasReachedGoal());
        robot.setPosition(goalPos);
        assertTrue(robot.hasReachedGoal());
    }

    @Test
    void setPosition() {
        Position pos = new Position(1,1);
        robot.setPosition(pos);
        assertEquals(new Position(1,1), robot.getPosition());
        Position newPos = new Position(2, 2);
        robot.setPosition(newPos);
        assertNotEquals(pos, robot.getPosition());
        assertEquals(newPos, robot.getPosition());
    }
}