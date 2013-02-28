/**
 * OfficiatedFootballGame provides a Referee to watch a FootballGame and throw flags
 * @author Andrew Kersten
 */
public class OfficiatedFootballGame extends FootballGame
{
    /** The referee that watches the game */
    private Referee referee;
    
    /** Calls parents constructor and initializes referee */
    public OfficiatedFootballGame()
    {
        super();
        referee = new Referee();
    }
    
    @Override
    public int runPlay(Play play)
    {
        try
        {
            referee.watchPlay();
        }
        catch (FlagException ex)
        {
            System.out.println("Flag on the play!  " + ex.getMessage());
            return ex.getPenaltyYards();
        }
        
        return 0;
    }
    
    public static void main(String[] args)
    {
        OfficiatedFootballGame game = new OfficiatedFootballGame();
        game.playGame();
    }
}
