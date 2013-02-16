/**
 * 
 */
package cs145.kersten.lab1;

/**
 * Contains the name and badge number required to describe a police officer.  Also provides functionality to determine if a ParkedCar has been parked at a ParkingMeter for too long
 * @author Andrew Kersten
 */
public class PoliceOfficer
{
    private String name;
    private String badgeNumber;
    
    public PoliceOfficer(String name, String badgeNumber)
    {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }
    
    /*
     * Determine if a ParkedCar has been parked at a ParkingMeter for too long
     */
    public ParkingTicket patrol(ParkedCar car, ParkingMeter meter)
    {
        int minutesOver = car.getMinutesParked() - meter.getMinutesPurchased();
        if (minutesOver <= 0)
        {
            return null;
        }
        
        return new ParkingTicket(car, this, minutesOver);
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the badgeNumber
     */
    public String getBadgeNumber()
    {
        return badgeNumber;
    }

    /**
     * @param badgeNumber the badgeNumber to set
     */
    public void setBadgeNumber(String badgeNumber)
    {
        this.badgeNumber = badgeNumber;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return new String(
                "Officer Data:\n" +
                "Name: " + name + "\n" +
                "Badge Number: " + badgeNumber + "\n"
        );
    }
}
