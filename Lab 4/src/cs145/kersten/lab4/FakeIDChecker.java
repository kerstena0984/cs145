package cs145.kersten.lab4;

public class FakeIDChecker
{
	public static void main(String[] args)
	{
		// Make some new people with IDs
		PersonalInfo[] people = {
				// Three student's from Minnesota (which ones have fake IDs)
				new MinnesotaInfo("Joe", "Fakename", "Schmo", 'M', 7, 5, 1979, "K000356748932"),
				new MinnesotaInfo("John", "Allsoran", "Doe", 'M', 28, 2, 2001, "e489874332893"),
				new MinnesotaInfo("Suzy", "Morgan", "Stanley", 'F', 7, 11, 1999, "D000358932"),

				// Crossing the border on Sunday to buy booze in Wisconsin (with a Fake ID!!)
				new WisconsinInfo("Joe", "Fakename", "Schmo", 'M', 7, 5, 1979,   "S6603567916707"),
				new WisconsinInfo("John", "Allsoran", "Doe", 'M', 28, 2, 1935,   "D6533733506802"),
				new WisconsinInfo("Suzy", "Morgan", "Stanley", 'F', 7, 11, 1980, "S6603568089302"),
		};
		
		// Check each license (using polymorphism)
		String validString = "";
		for(int i=0; i<people.length; i++)
		{
			if(people[i].verifyDLNumber())
			{
				validString = "valid.";
			}
			else
			{
				validString = "INVALID!";
			}
			
			// Print a message specific to each polymorphic type
			if(people[i] instanceof MinnesotaInfo)
			{
				System.out.printf("%s %s's Minnesota license is %s\n", people[i].getFirstName(), people[i].getLastName(), validString);
			}
			else if(people[i] instanceof WisconsinInfo)
			{
				System.out.printf("%s %s's Wisconsin license is %s\n", people[i].getFirstName(), people[i].getLastName(), validString);
			}
		}
	}
}
