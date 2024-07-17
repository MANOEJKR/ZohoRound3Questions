 

package FlightBooking;
import java.util.*;
public class Booking {

    public void book(String name, int customerticket,Flight flight)
    {
        List<String>temp = new ArrayList<>();
        if(flight.tickets<customerticket)
        {
            System.out.println("Not enough tickets avaiable");
            return;
        }
        
        
        flight.tickets-=customerticket;
        temp.add(name);
        temp.add(String.valueOf(customerticket));
        temp.add(String.valueOf(flight.price*customerticket));
        System.out.println("Booked successfully");
        System.out.println(name+ " \n ticket:" + customerticket + " \n Total cost: "+ flight.price*customerticket);
        flight.price+=(200*customerticket);

        flight.flightpassengerdetails.put(flight.passengerid,temp);
        
        flight.passengerid+=1;
    }

    public void printdetailspassenger(List<Flight>totTotalFlightDetails)
    {
        for(Flight flight : totTotalFlightDetails){
            if(flight.flightpassengerdetails.size()!=0){
        for (Map.Entry<Integer, List<String>> entry : flight.flightpassengerdetails.entrySet()) {
            
            System.out.println("Passenger id " + entry.getKey());
            List<String> store = entry.getValue();
            System.out.println("Name: " + store.get(0));
            System.out.println("Number of tickets booked: " + store.get(1));
            System.out.println("Total cost: " + store.get(2));
            
            
        }
    }

    }
        System.out.println("Invalid passenger number or passenger not available");
    }

    public void cancel(Flight flight, int passnumber1) {
        // TODO Auto-generated method stub

        for(Map.Entry<Integer,List<String>> entry : flight.flightpassengerdetails.entrySet())
        {
                if(entry.getKey() == passnumber1)
                {
                    System.out.println("Passenger id " + entry.getKey());
                    List<String> store= entry.getValue();

                    flight.flightpassengerdetails.remove(passnumber1);
                    flight.tickets+=Integer.parseInt(store.get(1));
                    flight.price-=Integer.parseInt(store.get(2));
                    System.out.println("canceled successfully");
                    return;
                }
        }

        System.out.println("Invalid passenger number or passenger not available");
       
    }


    
}
