package cs145.kersten.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * AssignmentDriver runs the assignment
 * @author Andrew Kersten
 */
public class AssignmentDriver
{
    public static void main(String[] args) throws NumberFormatException, FileNotFoundException
    {
        FileFilter boardFileFilter = new FileFilter("board");
        File projectRoot = new File(".\\");
        File[] boardFiles = projectRoot.listFiles(boardFileFilter);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("////////////////////////////////////////\n");
            System.out.println("Select a board to examine.");
            System.out.println("Boards Found:");
            System.out.println("0. Quit");
            for (int i = 0; i < boardFiles.length; i++)
            {
                System.out.println((i + 1) + ". " + boardFiles[i].getName().split("\\.")[0]);
            }
            System.out.println();
            
            System.out.print("Select a file: ");
            String input = scanner.nextLine();
            int iInput = 0;
            
            try
            {
                iInput = Integer.parseInt(input);
            }
            catch (NumberFormatException ex)
            {
                System.out.println("[ERROR] Input must be a number");
                System.out.println();
                continue;
            }
            
            if (iInput < 0 || iInput > boardFiles.length)
            {
                System.out.println("[ERROR] Input must be a valid board");
                System.out.println();
                continue;
            }
            
            if (input.equalsIgnoreCase("0"))
            {
                break;
            }
            
            System.out.println("Board chosen: " + boardFiles[iInput - 1].getName().split("\\.")[0] + "\n");
            
            Checkerboard checkerboard = Checkerboard.loadFromFile(boardFiles[iInput - 1], Checkerboard.FileFormat.ROW_MAJOR);
            if (checkerboard == null) continue;
            CheckersJumpCalculator checkersJumpCalculator = new CheckersJumpCalculator(checkerboard);
            
            System.out.println(checkerboard.toString());
            System.out.println("Red Jumps: " + checkersJumpCalculator.getNumberRedJumps());
            System.out.println("Black Jumps: " + checkersJumpCalculator.getNumberBlackJumps());
            System.out.println();
        }
        
        scanner.close();
        System.out.println("Application Terminated");
    }
}
