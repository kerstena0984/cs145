package cs145.kersten.lab4;

public class WisconsinInfo extends PersonalInfo
{
    private static final int DL_NUMBER_LENGTH = 14;
    
    public WisconsinInfo(String firstName, String middleName, String lastName, char gender, int birthDay, int birthMonth, int birthYear, String dlNumber)
    {
        super(firstName, middleName, lastName, gender, birthDay, birthMonth, birthYear, dlNumber);
    }

    @Override
    public boolean verifyDLNumber()
    {
        char[] dlNumber = getDlNumber().toCharArray();
        
        if (dlNumber.length != DL_NUMBER_LENGTH) return false;
        if (!Character.isUpperCase(dlNumber[0])) return false;
        for (int i = 1; i < DL_NUMBER_LENGTH; i++)
        {
            if (!Character.isDigit(dlNumber[i])) return false;
        }
        
        
        return true;
    }
}
