package cs145.kersten.lab3;

/**
 * StoutStudent provides access to student specific data for Stout students
 * @author Andrew Kersten
 **/
public class StoutStudent extends StoutPerson
{
    /* the StoutStudent's year */
    private String year;
    /* the StoutStudent's major */
    private String major;
    /* the StoutStudent's gpa */
    private double gpa;
    
    /*
     * Initializes StoutStudent specific data and calls the constructor of the parent
     */
    public StoutStudent(int id, String firstName, String lastName, String year, String major, double gpa)
    {
        super(id, firstName, lastName);
        this.year = year;
        this.major = major;
        this.gpa = gpa;
    }

    @Override
    public String role()
    {
        return "Take Classes";
    }

    @Override
    public boolean isEmployable()
    {
        if (gpa >= 2.0)
        {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isEmployed()
    {
        return false;
    }
    
    /**
     * Returns the StoutStudent's year
     * @return Returns the StoutStudent's year
     */
    public String getYear()
    {
        return year;
    }
    
    /**
     * Returns the StoutStudent's major
     * @return Returns the StoutStudent's major
     */
    public String getMajor()
    {
        return major;
    }
    
    /**
     * Returns the StoutPerson's GPA
     * @return Returns the StoutPerson's GPA
     */
    public double getGPA()
    {
        return gpa;
    }
    
    /**
     * Sets the StoutStudents's year
     * @param Sets the StoutStudent's year
     */
    public void setYear(String year)
    {
        this.year = year;
    }
    
    /**
     * Sets the StoutStudents's major
     * @param Sets the StoutStudent's major
     */
    public void setMajor(String major)
    {
        this.major = major;
    }
    
    /**
     * Sets the StoutStudents's gpa
     * @param Sets the StoutStudent's gpa
     */
    public void setGPA(double gpa)
    {
        this.gpa = gpa;
    }
    
    @Override
    public String toString()
    {
        String result = new String(
                super.toString() +
                "Year: " + year + "\n" +
                "Major: " + major + "\n" +
                "GPA: " + gpa + "\n" +
                "Role: " + role() + "\n"
        );
        
        if (isEmployable())
        {
            result += "HIRE THEM!!\n";
        }
        
        return result;
    }
}
