/** 
 * Describes a single play of a football game
 * @author Andrew Kersten
 */
public class Play
{
    /** A description of the play */
    private String description;
    
    /** The yards traveled on the play */
    private int yards;
    
    /** Initializes local variables */
    public Play(String description, int yards)
    {
        this.description = description;
        this.yards = yards;
    }
    
    /**
     *  Returns the description of the play
     * @return Returns the description of the play
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Returns the yards traveled on the play
     * @return Returns the yards traveled on the play
     */
    public int getYards()
    {
        return yards;
    }
    
    @Override
    public String toString()
    {
        String result = description + " for ";
        
        if (yards > 0)
            result += "a gain of " + yards + " yards";
        else if (yards < 0)
            result += "a loss of " + yards + " yards";
        else
            result += "no gain";
        
        return result;
    }
}
