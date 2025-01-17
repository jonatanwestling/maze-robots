package Robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
class MazeTest {
    private Maze maze;
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
        s.close();
    }

    @Test
    void isMovable() {
        Position validPos = new Position(3, 1);
        assertTrue(maze.isMovable(validPos));

        Position goal = new Position(3, 3);
        assertTrue(maze.isMovable(goal));

        Position wall = new Position(4, 1);
        assertFalse(maze.isMovable(wall));

        Position outOfBounds = new Position(100, 100);
        assertFalse(maze.isMovable(outOfBounds));
    }

    @Test
    void isGoal() {
        Position goalPos = new Position(3, 3);
        assertTrue(maze.isGoal(goalPos));

        Position validPos = new Position(1, 2);
        assertFalse(maze.isGoal(validPos));

        Position wall = new Position(4, 3);
        assertFalse(maze.isGoal(wall));

        Position outOfBounds = new Position(35, -34);
        assertFalse(maze.isGoal(outOfBounds));
    }

    @Test
    void getStart() {
        Position start = maze.getStart();
        assertNotNull(start);
        assertEquals(1, start.getX());
        assertEquals(0, start.getY());
    }

    @Test
    void getNumColumns() {
        int cols = maze.getNumColumns();
        assertEquals(5, cols);

    }

    @Test
    void getNumRows() {
        int rows = maze.getNumRows();
        assertEquals(4, rows);
    }
}