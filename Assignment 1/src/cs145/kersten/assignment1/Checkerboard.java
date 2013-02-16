package cs145.kersten.assignment1;

import java.io.File;
import java.util.Scanner;

/**
 * Checkerboard extends the basic GameBoard to be used specifically for checkers.
 * It provides functionality to display a board as well as calculate the number of jumps available for both red and black players.
 * @author Andrew Kersten
 */
public class Checkerboard extends GameBoard
{
    /** Checkerboard.FileFormat is used to determine which type of file we are loading, row major or column major **/
    public enum FileFormat
    {
        /** Signals a row major board file **/
        ROW_MAJOR,
        /** Signals a column major board file **/
        COL_MAJOR
    }
    
    /**
     * Creates a checkerboard object and sets the pieces on the board as specified by the board file
     * @param file is the board file that contains the piece data
     * @param format is the format of the board file, row major or column major
     * @return returns the checkerboard created from the file
     */
    public static Checkerboard loadFromFile(File file, FileFormat format)
    {
        try
        {
            Scanner scanner = new Scanner(file);
            Checkerboard checkerboard = new Checkerboard();
            
            switch (format)
            {
                case ROW_MAJOR:
                    loadRowMajor(checkerboard, scanner);
                    break;
                case COL_MAJOR:
                    loadColMajor(checkerboard, scanner);
                    break;
                default:
                    throw new Exception("Unsupported board file format");
            }
            
            return checkerboard;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Loads column major board files
     * @param checkerboard is the checkerboard to store the piece data
     * @param scanner is the scanner to pull the piece data from
     */
    private static void loadColMajor(Checkerboard checkerboard, Scanner scanner) throws Exception
    {
        for (int row = 0; row < CHECKERBOARD_HEIGHT; row++)
        {
            for (int col = 0; col < CHECKERBOARD_WIDTH; col++)
            {
                checkerboard.setPiece(row, col, scanner.nextLine().toCharArray()[0]);
            }
        }
    }
    
    /**
     * Loads row major board files
     * @param checkerboard is the checkerboard to store the piece data
     * @param scanner is the scanner to pull the piece data from
     */
    private static void loadRowMajor(Checkerboard checkerboard, Scanner scanner) throws Exception
    {
        for (int col = 0; col < CHECKERBOARD_HEIGHT; col++)
        {
            for (int row = 0; row < CHECKERBOARD_WIDTH; row++)
            {
                checkerboard.setPiece(row, col, scanner.nextLine().toCharArray()[0]);
            }
        }
    }
    
    /** The width of the checkerboard **/
    public static final int CHECKERBOARD_WIDTH = 8;
    
    /** The height of the checkerboard **/
    public static final int CHECKERBOARD_HEIGHT = 8;
    
    /** Initializes the checkerboard to be CHECKERBOARD_WIDTH wide by CHECKERBOARD_HEIGHT tall **/
    public Checkerboard()
    {
        super(CHECKERBOARD_WIDTH, CHECKERBOARD_HEIGHT);
    }
    
    /**
     * Translates the character stored in the board array into a CheckersPiece
     * @param row is the row of the piece to retrieve
     * @param col is the col of the piece to retrieve
     * @return returns the CheckersPiece equivalent to the character code stored in the board array at row row and column col
     */
    public CheckersPiece getCheckersPiece(int row, int col)
    {
        return CheckersPiece.fromCode(getPiece(row, col));
    }
    
    @Override
    public String toString()
    {
        String horizontalLine = "---------------------------------\n";
        String result = "";
        
        result += horizontalLine;
        for (int row = 0; row < CHECKERBOARD_HEIGHT; row++)
        {
            result += "|";
            for (int col = 0; col < CHECKERBOARD_WIDTH; col++)
            {
                result += " " + getCheckersPiece(row, col).getVisual() + " |";
            }
            result += "\n" + horizontalLine;
        }
        
        return result;
    }
}
