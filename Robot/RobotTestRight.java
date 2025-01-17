package Robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RobotTestRight {
    public static void main(String[] args) throws Exception
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("Put: RobotTest <File Name for Maze>");
        }
        //create maze from text file
        String s = args[0];
        Maze m = createMaze(s);
        if (m == null)
        {
            throw new Error("File NOT FOUND");
        }
        RightHandRuleRobot r = createRightHandRobot(m, s);
        if (r == null)
        {
            throw new Error("Robot is null");
        }
        int steps = 0;
        while (!r.hasReachedGoal())
        {
            r.move();
            steps++;
            if (steps == 50)
            {
                System.exit(1);
            }

        }
        System.out.println("SUCCESS: GOAL FOUND");
        System.out.println("Total steps: "+steps);
    }

    /**
     * Method opens the file and creates a scanner to read from the file
     * then calls Maze with the scanner as parameter.
     * @param filename
     * @return The created maze
     * @throws Exception
     */
    public static Maze createMaze(String filename) throws Exception {
        System.out.println("Creating maze from file: " + filename);
        Scanner in;
        try {
            File file = new File(filename);
            in = new Scanner(file);
            Maze m = new Maze(in);
            System.out.println("SUCCESS: Maze created.");
            return m;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            throw e;
        } catch (Exception e) {
            throw new Exception("Failed to create maze");
        }
    }
    public static RightHandRuleRobot createRightHandRobot (Maze m, String filename)
    {
        System.out.println("Creating robot to traverse maze: " + filename);
        RightHandRuleRobot robot = null;
        try {
            robot = new RightHandRuleRobot(m);
        } catch (NullPointerException e)
        {
            return null;
        }
        System.out.println("SUCCESS: Robot created.");
        return robot;
    }




}
