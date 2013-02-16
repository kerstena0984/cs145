package cs145.kersten.lab3;

import java.util.Arrays;

public class StoutTester
{
    public static void main(String[] args)
    {
        StoutPerson[] stoutPeople = new StoutPerson[] {
            new StoutFaculty(73, "Terry", "Mason", "Assistant Professor"),
            new StoutFaculty(12, "Seth", "Berrier", "Assistant Professor"),
            new StoutFaculty(62, "Dennis", "Schmidt", "Instructor"),
            new StoutStudent(126, "Andrew", "Kersten", "Freshman", "GDD", 3.8)
        };
        
        Arrays.sort(stoutPeople);
        
        for (StoutPerson stoutPerson : stoutPeople)
        {
            System.out.println(stoutPerson.toString());
        }
    }
}
