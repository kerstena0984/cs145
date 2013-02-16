/**
   ParkingTicketSimulator program
   Parking Ticket Simulator
*/

package cs145.kersten.lab1;

public class ParkingTicketSimulator
{
   public static void main(String[] args)
   {
      // Create a ParkedCar object.
      // The car was parked for 135 minutes.
      ParkedCar car = new ParkedCar("Volkswagen", "Beetle", "Green", "147HZM", 135);
      
      // Create a ParkingMeter object. 60 minutes were purchased.
      ParkingMeter meter = new ParkingMeter(60);
      
      // Create a PoliceOfficer object.
      PoliceOfficer officer = new PoliceOfficer("Kurt Wallander", "4788W");
                                                
      // Let the officer patrol.
      ParkingTicket ticket = officer.patrol(car, meter);
      
      // Did the officer issue a ticket?
      if (ticket != null) System.out.println(ticket);
      else System.out.println("No crimes committed!");
   }
}