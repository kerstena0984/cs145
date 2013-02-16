/**
   ParkingTicketSimulator program
   Parking Ticket Simulator
*/

package cs145.kersten.lab1;

public class ParkingTicketSimulator2
{
   public static void main(String[] args)
   {
      // Create a ParkedCar object.
      // The car was parked for 58 minutes.
      ParkedCar car = new ParkedCar("Mazda", "MPV", "Black", "434DZH", 58);
      
      // Create a ParkingMeter object. 60 minutes were purchased.
      ParkingMeter meter = new ParkingMeter(60);
      
      // Create a PoliceOfficer object.
      PoliceOfficer officer = new PoliceOfficer("Martin Beck", "76745B");
                                                
      // Let the officer patrol.
      ParkingTicket ticket = officer.patrol(car, meter);
      
      // Did the officer issue a ticket?
      if (ticket != null) System.out.println(ticket);
      else System.out.println("No crimes committed!");
   }
}