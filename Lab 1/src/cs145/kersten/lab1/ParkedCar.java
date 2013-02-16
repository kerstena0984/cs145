/**
 * 
 */
package cs145.kersten.lab1;

/**
 * Contains all information required to describe a car, as well as how long it has been parked
 * @author Andrew Kersten
 */
public class ParkedCar
{
    private String make;
    private String model;
    private String color;
    private String licenseNumber;
    private int minutesParked;
    
    public ParkedCar(String make, String model, String color, String licenseNumber, int minutesParked)
    {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNumber = licenseNumber;
        this.minutesParked = minutesParked;
    }

    /**
     * @return returns the make of the car
     */
    public String getMake()
    {
        return make;
    }

    /**
     * @param set the car's make to make
     */
    public void setMake(String make)
    {
        this.make = make;
    }

    /**
     * @return returns the model of the car
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @param set the car's model to model
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * @return returns the color of the car
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @param sets the car's color to color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @return returns the license number of the car
     */
    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    /**
     * @param sets the car's license number to  licenseNumber
     */
    public void setLicenseNumber(String licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return returns the minutes the car has been parked
     */
    public int getMinutesParked()
    {
        return minutesParked;
    }

    /**
     * @param sets the car's minutes parked to minutesParked
     */
    public void setMinutesParked(int minutesParked)
    {
        this.minutesParked = minutesParked;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return new String(
                "Car Data:\n" +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Color: " + color + "\n" +
                "License Number: " + licenseNumber + "\n" +
                "Minutes Parked: " + minutesParked + "\n"
        );
    }
}
