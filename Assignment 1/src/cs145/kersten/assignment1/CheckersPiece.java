package cs145.kersten.assignment1;

import java.util.EnumSet;
import java.util.Hashtable;

/**
 * CheckersPiece separates the character used to represent a checkers piece in a board file from its visual representation
 * @author Andrew Kersten
 */
public enum CheckersPiece
{
    /** A black piece on a checkerboard **/
    Black('B', 'B'),
    /** A red piece on a checkerboard **/
    Red('R', 'R'),
    /** An empty piece on a checkerboard **/
    Empty(' ', ' ');
    
    /** The character representing the piece in board files **/
    private char dataCode;
    
    /** The visual representation of the piece **/
    private char visual;
    
    /**
     * Sets the data and visual value for the enum option
     * @param dataCode is the character used in a board file representing the piece
     * @param visual is the character used when displaying the piece
     */
    private CheckersPiece(char dataCode, char visual)
    {
        this.dataCode = dataCode;
        this.visual = visual;
    }
    
    /**
     * Returns the character used to represent the piece in a board file
     * @return Returns the character used to represent the piece in a board file
     */
    public char getDataCode()
    {
        return dataCode;
    }
    
    /**
     * Returns the visual character when displaying a piece
     * @return Returns the visual character when displaying a piece
     */
    public char getVisual()
    {
        return visual;
    }
    
    /**
     * Maps the dataCode to a CheckersPiece
     */
    private static Hashtable<Character, CheckersPiece> charToPieceIndex = new Hashtable<Character, CheckersPiece>();
    
    /**
     * Returns the CheckerPiece associated with the code
     * @param code is the character in board files representing a piece
     * @return the CheckerPiece associated with the code
     */
    public static CheckersPiece fromCode(char code)
    {
        return charToPieceIndex.get(code);
    }
    
    // puts each element in the enumeration into the hashtable with the dataCode being the key
    static
    {
        for (CheckersPiece piece : EnumSet.allOf(CheckersPiece.class))
        {
            charToPieceIndex.put(piece.getDataCode(), piece);
        }
    }
}
