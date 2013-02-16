package cs145.kersten.lab3;

/**
 * StoutStudent provides access to faculty specific data for Stout faculty
 * @author Andrew Kersten
 **/
public class StoutFaculty extends StoutPerson
{
    /* the StoutFaculty's position */
    private String position;
    
    /*
     * Initializes StoutFaculty specific data and calls the constructor of the parent
     */
    public StoutFaculty(int id, String firstName, String lastName, String position)
    {
        super(id, firstName, lastName);
        this.position = position;
    }

    @Override
    public boolean isEmployable()
    {
        return false;
    }

    @Override
    public boolean isEmployed()
    {
        return true;
    }

    @Override
    public String role()
    {
        return "Teach Classes";
    }
    
    /**
     * Returns the StoutFaculty's position
     * @return Returns the StoutFaculty's position
     */
    public String getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return new String(
                super.toString() +
                "Position: " + position + "\n" +
                "Role: " + role() + "\n"
        );
    }
}
