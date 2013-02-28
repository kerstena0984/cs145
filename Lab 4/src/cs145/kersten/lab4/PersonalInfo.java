package cs145.kersten.lab4;

public abstract class PersonalInfo
{
    private String firstName;
    private String middleName;
    private String lastName;
    private char gender;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String dlNumber;
    
    public PersonalInfo(String firstName, String middleName, String lastName, char gender, int birthDay, int birthMonth, int birthYear, String dlNumber)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.dlNumber = dlNumber;
    }
    
    public abstract boolean verifyDLNumber();

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public char getGender()
    {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender)
    {
        this.gender = gender;
    }

    /**
     * @return the birthDay
     */
    public int getBirthDay()
    {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(int birthDay)
    {
        this.birthDay = birthDay;
    }

    /**
     * @return the birthMonth
     */
    public int getBirthMonth()
    {
        return birthMonth;
    }

    /**
     * @param birthMonth the birthMonth to set
     */
    public void setBirthMonth(int birthMonth)
    {
        this.birthMonth = birthMonth;
    }

    /**
     * @return the birthYear
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * @return the dlNumber
     */
    public String getDlNumber()
    {
        return dlNumber;
    }

    /**
     * @param dlNumber the dlNumber to set
     */
    public void setDlNumber(String dlNumber)
    {
        this.dlNumber = dlNumber;
    }
}
