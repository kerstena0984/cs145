/**
 * 
 */
package cs145.kersten.lab1;

/**
 * Contains all information required to describe a usage instance of a parking meter, namely the number of minutes purchased
 * @author Andrew Kersten
 */
public class ParkingMeter
{
    private int minutesPurchased;
    
    public ParkingMeter(int minutesPurchased)
    {
        this.minutesPurchased = minutesPurchased;
    }

    /**
     * @return the minutesPurchased
     */
    public int getMinutesPurchased()
    {
        return minutesPurchased;
    }

    /**
     * @param minutesPurchased the minutesPurchased to set
     */
    public void setMinutesPurchased(int minutesPurchased)
    {
        this.minutesPurchased = minutesPurchased;
    }
}
