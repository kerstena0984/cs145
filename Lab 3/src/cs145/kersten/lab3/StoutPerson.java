package cs145.kersten.lab3;

/**
 * StoutPerson provides the similar data between StoutStudents and StoutFaculty
 * @author Andrew Kersten
 **/
public abstract class StoutPerson implements Comparable<StoutPerson>, Employable
{
    /* the students id */
    private int id;
    /* the students first name */
    private String firstName;
    /* the students last name */
    private String lastName;
    
    /*
     * Initializes the StoutPersons id, firstName, and lastName
     */
    public StoutPerson(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Returns a brief descriptor stating the persons role
     * @return Returns a brief descriptor stating the persons role
     */
    public abstract String role();
    
    @Override
    public int compareTo(StoutPerson stoutPerson)
    {
        return id - stoutPerson.getId();
    }
    
    /**
     * Returns the StoutPerson's ID
     * @return Returns the StoutPerson's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Returns the StoutPerson's first name
     * @return Returns the StoutPerson's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Returns the StoutPerson's last name
     * @return Returns the StoutPerson's last name
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Sets the StoutPerson's id
     * @param Sets the StoutPerson's id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the StoutPerson's first name
     * @param Sets the StoutPerson's first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    /**
     * Sets the StoutPerson's last name
     * @param Sets the StoutPerson's last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String toString()
    {
        return new String(
                "ID: " + id + "\n" +
                "Name: " + firstName + " " + lastName + "\n"
        );
    }
}
