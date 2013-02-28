
public abstract class FootballGame {
	
	/** The current down */
	private int down;
	
	/** Yards to go until a first down */
	private int yardsToGo;
	
	/** Count of how many first downs have occurred */
	private int firstDowns;

	/** The plays that will be run to simulate a drive */
	private Play[] plays = {
			new Play("Offense runs the ball",4),
			new Play("Offense passes the ball",24),
			new Play("Defense sacks the quarterback",-7),
			new Play("Defense stuffs the run",0),
			new Play("Offense runs the ball",4),
			new Play("Offense runs the ball",17)
	};
	
	/**
	 * Construct a new FootballGame.  Initializes all member variables.
	 */
	public FootballGame()
	{
		down = 1;
		yardsToGo = 10;
		firstDowns = 0;
	}

	/**
	 * Get the value of the current down
	 * @return An integer representing the current down.
	 */
	public int getDown()
	{
		return down;
	}
	
	/**
	 * This abstract method will run the play, handle any exceptions that might be thrown.
	 * @param play The play object that is to be ran 
	 * @return the number of penalty yards on the play, zero if no penalty occurs.
	 */
	public abstract int runPlay(Play play);

	/**
	 * Start a game and use the pre-determined plays to simulate a drive.  This method will
	 * call runPlay() at key points to allow the play to be simulated independently.
	 */
	public void playGame()
	{
		// Loop over all the pre-determined plays
		for (int playNumber = 0; playNumber < plays.length; playNumber++)
		{
			// Print informatino about the current down and the play
			Play play = plays[playNumber];
			System.out.println("Down: " + down + ", " + yardsToGo + " yards to go for a first down.");
			System.out.println(play);

			// Simulate the play
			int penaltyYards = runPlay(play);

			// Check if a penalty occurred
			if (penaltyYards != 0)
			{				
				// If the penalty was on the defense and resulted in fewer yards than the actual play
				// we probably want to decline the penalty.
				if(penaltyYards > 0 && play.getYards() > penaltyYards)
				{
					down++;
					yardsToGo -= play.getYards();
					System.out.println("The penalty is declined.");
				}
				
				// Otherwise, add the penalty yards back onto yards to go
				else yardsToGo -= penaltyYards;
			}
			
			// No penalty, update down count and yards to go
			else
			{
				down++;
				yardsToGo -= play.getYards();
			}
			
			// Did we achieve a first down?
			if (yardsToGo <= 0)
			{
				// Notify of a first down (as long as this isn't the last play, in that case, what's the point)
				if(playNumber < plays.length-1) System.out.println("First down! The offense keeps playing");

				// Reset/update the various counters
				yardsToGo = 10;
				down = 1;
				firstDowns++;
			}
			
			// Otherwise, are we out of downs?
			else if (down == 4)
			{
				System.out.println("Down: 4, the offense didn't make a first down, they must punt.");
				firstDowns = 0;
				break;
			}
			
		}

		// If the offense achieved at least 2 first downs without turning the ball over, success!!
		if(firstDowns > 1 && down != 4) System.out.println("TOUCHDOWN!!!");
		else System.out.println("Time ran out!  Game Over!");
	}
}
