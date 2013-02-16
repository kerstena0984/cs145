/**
 * 
 */
package cs145.kersten.lab1;

import java.text.DecimalFormat;

/**
 * Contains all information related to an issued parking ticket
 * @author Andrew Kersten
 */
public class ParkingTicket
{
    private ParkedCar car;
    private PoliceOfficer officer;
    private double fine;
    private int minutesOver;
    private static final double baseFine = 50.00; // $
    private static final double hourlyFine = 15.00; // $
    
    public ParkingTicket(ParkedCar car, PoliceOfficer officer, int minutesOver)
    {
        this.car = car;
        this.officer = officer;
        this.minutesOver = minutesOver;
        
        calculateFine();
    }
    
    /*
     *  Calculate the fine using minutesOver.  The fine is calculated  using a $50 base fine and $15 for each additional hour.
     */
    private void calculateFine()
    {
        if (minutesOver == 0)
        {
            fine = 0;
            return;
        }
        
        fine = baseFine;
        int minutesOverHour = minutesOver - 60;
        if (minutesOverHour > 0)
        {
            fine += Math.ceil(minutesOverHour / 60.0000) * hourlyFine;
        }
    }

    /**
     * @return returns the car
     */
    public ParkedCar getCar()
    {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(ParkedCar car)
    {
        this.car = car;
    }

    /**
     * @return the officer
     */
    public PoliceOfficer getOfficer()
    {
        return officer;
    }

    /**
     * @param officer the officer to set
     */
    public void setOfficer(PoliceOfficer officer)
    {
        this.officer = officer;
    }

    /**
     * @return the minutesOver
     */
    public int getMinutesOver()
    {
        return minutesOver;
    }

    /**
     * @param minutesOver the minutesOver to set
     */
    public void setMinutesOver(int minutesOver)
    {
        this.minutesOver = minutesOver;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        
        return new String(
                car.toString() + "\n" +
                officer.toString() + "\n" +
                "Minutes Illegally Parked: " + minutesOver + "\n" +
                "Fine: $" + decimalFormat.format(fine) + "\n"
        );
    }
}
