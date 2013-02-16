package cs145.kersten.lab2;

import java.io.*;
import java.util.Scanner;

/**
 * This is a driver for the Precipitation class.  It opens the
 * file precip.dat and passes it to the precipitation object.
 * It then creates a PrintWriter for the file precip.out and
 * output's the string form of the Precipitation object.
 * @author Seth Berrier (berriers@uwstout.edu)
 */
public class RainfallSimulator
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Create a precipitation object
		Precipitation wetStuff = new Precipitation();

		// Open the precip.dat file and pass it to the precipitation object		
		File file  = new File("precip.dat");
		Scanner infile = new Scanner(file);
		wetStuff.readFile(infile);
		infile.close();

		// Open a new output file then write the precipitation object to it 
		PrintWriter outfile = new PrintWriter("precip.out");
		outfile.println(wetStuff);
		outfile.close();
	}
}