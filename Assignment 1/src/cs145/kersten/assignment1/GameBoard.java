package cs145.kersten.assignment1;

/**
 * GameBoard is a wrapper around a 2D character array.  It does NOT provide bounds checking.
 * This board can be used as a base for many different games.
 * @author Andrew Kersten
 */
public abstract class GameBoard
{
    /** The 2D character array representing the game board **/
    private char[][] board;
    
    /**
     * Initializes the board to be boardWidth wide and boardHeight tall
     * @param boardWidth is the width of the game board
     * @param boardHeight is the height of the game board
     */
    public GameBoard(int boardWidth, int boardHeight)
    {
        board = new char[boardWidth][boardHeight];
    }
    
    /**
     * Returns the character representing the game piece on the board located at row row and column col.
     * It does NOT do any bounds checking.  We do not want to silently fail and java will throw the error for us.
     * @param row is the row on the board of the character to return
     * @param col is the column on the board of the character to return
     * @return Returns the character located at row row and column col on the board
     */
    public char getPiece(int row, int col)
    {
        return board[row][col];
    }
    
    /**
     * Sets the character representing the game piece on the board located at row row and column col to piece.
     * It does NOT do any bounds checking.  We do not want to silently fail and java will throw the error for us.
     * @param row is the row on the board to set to piece
     * @param col is the column on the board to set to piece
     * @param piece is the character to set the piece located at row row and column col to
     */
    public void setPiece(int row, int col, char piece)
    {
        board[row][col] = piece;
    }
}
