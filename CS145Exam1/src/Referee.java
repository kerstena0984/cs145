/**
 * The referee watches plays and randomly throws FlagExceptions
 * @author Andrew Kersten
 */
public class Referee
{
    /** The number of flags the referee has thrown */
    private int totalFlags;
    
    /**
     * Initializes the number of flags thrown to zero
     */
    public Referee()
    {
        totalFlags = 0;
    }
    
    /**
     * Throws a FlagException randomly.  Only two flags can ever be thrown.  Keeps track of how many flags have been thrown.
     * @throws FlagException randomly
     */
    public void watchPlay() throws FlagException
    {
        if (totalFlags == 2) return;
        
        totalFlags++;
        
        double r = Math.random();
        
        if (r <= 0.2)
            throw new FlagException("Holding", "Offense", -10);
        if (r <= 0.4)
            throw new FlagException("Offsides", "Defense", 5);
        
        totalFlags--;
    }
}
