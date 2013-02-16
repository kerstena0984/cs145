package cs145.kersten.lab2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Precipitation reads, stores, and operates on precipitation data loaded from disk.
 * Precipitation's toString method generates a nicely formatted table of the precipitation data.
 * @author Andrew Kersten
 **/
public class Precipitation 
{
	private final static int MONTHS = 12;
	private final static int YEARS = 5;
	private final static int STARTYEAR = 1995;
	private final String[] monthLabel = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
										 "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	private double[][] precipitationAmount;
	private double[] yearTotal;
	private double[] monthlyAverage;

	public Precipitation()
	{
	    precipitationAmount = new double[YEARS][MONTHS];
	    yearTotal = new double[YEARS];
	    monthlyAverage = new double[MONTHS];
	}

	/**
	 * Computes the average for each month and store it in an array member
	 */
	private void calculateMonthlyAverage()
	{
	    for (int month = 0; month < MONTHS; month++)
	    {
	        double total = 0;
	        
	        for (int year = 0; year < YEARS; year++)
	        {
	            total += precipitationAmount[year][month];
	        }
	        
	        monthlyAverage[month] = total / YEARS;
	    }
	}

	/**
	 * Computes the total for each year and store it in an array member
	 */
	private void calculateYearTotal()
	{
	    for (int year = 0; year < YEARS; year++)
	    {
	        double total = 0;
	        
	        for (int month = 0; month < MONTHS; month++)
	        {
	            total += precipitationAmount[year][month];
	        }
	        
	        yearTotal[year] = total;
	    }
	}
	
	/**
	 * Finds the max rainfall in the precipitation array
	 * @return Returns a sentence describing this value and the month and year it occurred
	 */
	private String findMax()
	{
	    double maxPrecip = 0;
	    int maxMonth = 0;
	    int maxYear = 0;
	    
	    for (int year = 0; year < YEARS; year++)
	    {
	        for (int month = 0; month < MONTHS; month++)
	        {
	            double precip = precipitationAmount[year][month];
	            
	            if (precip > maxPrecip)
	            {
	                maxPrecip = precip;
	                maxMonth = month;
	                maxYear = year;
	            }
	        }
	    }
	    
		return "The maximum rainfall of " + maxPrecip + " occurred in " + monthLabel[maxMonth] + " of " + (STARTYEAR + maxYear);
	}	

	/**
     * Finds the min rainfall in the precipitation array
     * @return Returns a sentence describing this value and the month and year it occurred
     */
	private String findMin()
	{
	    double minPrecip = Double.MAX_VALUE;
	    int minMonth = 0;
	    int minYear = 0;
	    
	    for (int year = 0; year < YEARS; year++)
        {
            for (int month = 0; month < MONTHS; month++)
            {
                double precip = precipitationAmount[year][month];
                
                if (precip < minPrecip)
                {
                    minPrecip = precip;
                    minMonth = month;
                    minYear = year;
                }
            }
        }
	    
		return "The minimum rainfall of " + minPrecip + " occurred in " + monthLabel[minMonth] + " of " + (STARTYEAR + minYear);
	}
	
	/**
	 * Reads the precipitation data and stores that data in a 2D array member.
	 * Also calculates the monthly averages and yearly totals.
	 * @param infile The Scanner object to read the precipitation data from
	 */
	public void readFile(Scanner infile)
	{
	    for (int year = 0; year < YEARS; year++)
	    {
	        for (int month = 0; month < MONTHS; month++)
	        {
	            precipitationAmount[year][month] = infile.nextDouble();
	        }
	    }
				
		// Calculate averages and totals
		calculateMonthlyAverage();
		calculateYearTotal();
	}
	
	public String toString()
	{
	    DecimalFormat df = new DecimalFormat("0.00");
	    
	    String table = String.format("Year\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\tTotal\n\n", (Object[])monthLabel);
	    
	    String[][] precip = new String[YEARS][MONTHS];
	    for (int year = 0; year < YEARS; year++)
	    {
	        for (int month = 0; month < MONTHS; month++)
	        {
	            precip[year][month] = df.format(precipitationAmount[year][month]);
	        }
	    }
	    
	    for (int year = 0; year < YEARS; year++)
	    {
	        table += (STARTYEAR + year);
	        table += String.format("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t", (Object[])precip[year]);
	        table += df.format(yearTotal[year]) + "\n";
	    }
	    
	    String[] monthlyAverages = new String[MONTHS];
	    for (int month = 0; month < MONTHS; month++)
	    {
	        monthlyAverages[month] = df.format(monthlyAverage[month]);
	    }
	    
	    table += String.format("\nAvg\t\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", (Object[])monthlyAverages);
	    
	    table += "\n" + findMax() + "\n" + findMin();
	    
	    return table;
	}
}