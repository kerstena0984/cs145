/** 
 * FlagException describes a penalty on a play
 * @author Andrew Kersten
 */
public class FlagException extends Exception
{
    /** The penalty that occured */
    private String penalty;
    
    /** The team that caused the penalty */
    private String team;
    
    /** The yards the penalty is worth */
    private int penaltyYards;
    
    /**
     * Sets the message for the exception and initializes local variables
     * @param penalty describes the penalty that occured
     * @param team is the team that caused the penalty
     * @param penaltyYards is the yards th penalty is worth
     */
    public FlagException(String penalty, String team, int penaltyYards)
    {
        super(penalty + " on the " + team + " for " + penaltyYards + " yards.");
        this.penalty = penalty;
        this.team = team;
        this.penaltyYards = penaltyYards;
    }
    
    /**
     * Returns the yards the penalty is worth
     * @return Returns the yards the penalty is worth
     */
    public int getPenaltyYards()
    {
        return penaltyYards;
    }
}
