package cs145.kersten.assignment1;

/**
 * CheckersJumpCalculator Calculates the number of jumps available for each player for a given checkerboard
 * @author Andrew Kersten
 */
public class CheckersJumpCalculator
{
    /** The checkerboard to evaluate **/
    private Checkerboard checkerboard;
    
    /** Sets the checkerboard we are going to evaluate to checkerboard **/
    public CheckersJumpCalculator(Checkerboard checkerboard)
    {
        this.checkerboard = checkerboard;
    }
    
    /**
     * Calculates the number of jumps available to the black player
     * @return returns the number of jumps available to the black player
     */
    public int getNumberBlackJumps()
    {
        int jumpCount = 0;
        
        for (int row = 0; row < Checkerboard.CHECKERBOARD_HEIGHT; row++)
        {
            for (int col = 0; col < Checkerboard.CHECKERBOARD_WIDTH; col++)
            {
                if (checkerboard.getCheckersPiece(row, col) != CheckersPiece.Black)
                {
                    continue;
                }
                
                int row1 = row - 1;
                int col1 = col - 1;
                if (!(row1 < 0 || col1 < 0))
                {
                    if (checkerboard.getCheckersPiece(row1, col1) == CheckersPiece.Red)
                    {
                        int row11 = row1 - 1;
                        int col11 = col1 - 1;
                        if (!(row11 < 0 || col11 < 0))
                        {
                            if (checkerboard.getCheckersPiece(row11, col11) == CheckersPiece.Empty)
                            {
                                jumpCount++;
                            }
                        }
                    }
                }
                
                int row2 = row - 1;
                int col2 = col + 1;
                if (!(row2 < 0 || col2 >= Checkerboard.CHECKERBOARD_WIDTH))
                {
                    if (checkerboard.getCheckersPiece(row2, col2) == CheckersPiece.Red)
                    {
                        int row22 = row2 - 1;
                        int col22 = col2 + 1;
                        if (!(row22 < 0 || col22 >= Checkerboard.CHECKERBOARD_WIDTH))
                        {
                            if (checkerboard.getCheckersPiece(row22, col22) == CheckersPiece.Empty)
                            {
                                jumpCount++;
                            }
                        }
                    }
                }
            }
        }
        
        return jumpCount;
    }
    
    /**
     * calculates the number of jumps available to the red player
     * @return returns the number of jumps available to the red player
     */
    public int getNumberRedJumps()
    {
        int jumpCount = 0;
        
        for (int row = 0; row < Checkerboard.CHECKERBOARD_HEIGHT; row++)
        {
            for (int col = 0; col < Checkerboard.CHECKERBOARD_WIDTH; col++)
            {
                if (checkerboard.getCheckersPiece(row, col) != CheckersPiece.Red)
                {
                    continue;
                }
                
                int row1 = row + 1;
                int col1 = col - 1;
                if (!(row1 >= Checkerboard.CHECKERBOARD_HEIGHT || col1 < 0))
                {
                    if (checkerboard.getCheckersPiece(row1, col1) == CheckersPiece.Black)
                    {
                        int row11 = row1 + 1;
                        int col11 = col1 - 1;
                        if (!(row11 >= Checkerboard.CHECKERBOARD_HEIGHT || col11 < 0))
                        {
                            if (checkerboard.getCheckersPiece(row11, col11) == CheckersPiece.Empty)
                            {
                                jumpCount++;
                            }
                        }
                    }
                }
                
                int row2 = row + 1;
                int col2 = col + 1;
                if (!(row2 >= Checkerboard.CHECKERBOARD_HEIGHT || col2 >= Checkerboard.CHECKERBOARD_WIDTH))
                {
                    if (checkerboard.getCheckersPiece(row2, col2) == CheckersPiece.Black)
                    {
                        int row22 = row2 + 1;
                        int col22 = col2 + 1;
                        if (!(row22 >= Checkerboard.CHECKERBOARD_HEIGHT || col22 >= Checkerboard.CHECKERBOARD_WIDTH))
                        {
                            if (checkerboard.getCheckersPiece(row22, col22) == CheckersPiece.Empty)
                            {
                                jumpCount++;
                            }
                        }
                    }
                }
            }
        }
        
        return jumpCount;
    }
}
