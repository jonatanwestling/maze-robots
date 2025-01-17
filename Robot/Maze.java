package Robot;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This java class creates a maze from a textfile that is passed as argument 1. The created
 * maze is stored as an arraylist of strings and is traversable by the robot.
 * @author Jonatan Westling, c22jwg
 * @version v2. 2023-05-11: Second public version.
 */
public class Maze {
    private Position start;
    private final ArrayList<Position> goalList;
    private final ArrayList<String> mazeList;
    private int rowNumb;
    private int colNumb;
    private int numbS;
    private int numbG;

    /**
     * Constructor that creates a maze object. The constructor reads the file and add
     * the chars into an ArrayList with strings. So each row is a string. The constructor
     * also have an ArrayList that holds goal positions so the maze can handle multiple goals.
     * @param s the scanner that will read the textfile.
     * @throws IllegalArgumentException an exception will be thrown if there are invalid chars in the textfile
     * or if there is not a correct amount of start positions and goal positions.
     */
    public Maze(Scanner s) throws IllegalArgumentException {
        //initialize variables
        this.start = null;
        this.numbS = 0;
        this.numbG = 0;
        this.colNumb = 0;
        this.rowNumb = 0;

        //create a maze and goal list
        mazeList = new ArrayList<>();
        goalList = new ArrayList<>();
        //read text file until end
        while(s.hasNextLine())
        {
            //add the line to a string
            String line = s.nextLine();
            if (line.length() > colNumb)
            {
                colNumb = line.length();
            }
            //add line in maze list
            mazeList.add(line);
            //iterate over each line
            for (int i = 0; i < line.length(); i++)
            {
                //check for invalid characters
                char c = line.charAt(i);
                if (c!= ' ' && c != '*' && c != 'S' && c != 'G')
                {
                    throw new IllegalArgumentException("Invalid chars in maze, only '', '*', 'G' and 'S' are accepted.");
                }
                if(c == 'S')
                {
                    //start found, add pos
                    this.start = new Position(i, rowNumb);
                    this.numbS++;
                }
                else if (c == 'G')
                {
                    //goal found, add to list of goal pos
                    goalList.add(new Position(i, rowNumb));
                    this.numbG++;
                }
            }
            rowNumb++;
        }
        //close the scanner when we are done using it
        s.close();
        if(this.numbS != 1 || this.numbG < 1)
        {
            throw new IllegalArgumentException("Invalid number of start positions and/or goal positions");
        }
    }

    /**
     * Checks if a position is a valid position that the robot can go to.
     * @param p the position to check.
     * @return true or false depending on if the robot is movable to that position or not.
     */
    public boolean isMovable(Position p)
    {
        int x = p.getX();
        int y = p.getY();
        try
        {
            return mazeList.get(y).charAt(x) == ' ' || mazeList.get(y).charAt(x) == 'G';
        }
        catch (IndexOutOfBoundsException e)
        {
            return false;
        }
    }

    /**
     * Checks if a position is the goal.
     * @param p the position to check.
     * @return true or false.
     */
    public boolean isGoal(Position p)
    {
        for(int i = 0; i < this.numbG; i++)
        {
            if (p.equals(goalList.get(i)))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * A method that will return the start position for the robot in the maze.
     * @return position of start.
     */
    public Position getStart()
    {
        System.out.println(start.getX()+"."+ start.getY());
        return this.start;
    }

    /**
     * A method that will return the number of columns.
     * @return integer of columns.
     */
    public int getNumColumns()
    {
        return this.colNumb;
    }

    /**
     * A method that will return the number of rows.
     * @return integer of rows.
     */
    public int getNumRows()
    {
        return this.rowNumb;
    }
}
