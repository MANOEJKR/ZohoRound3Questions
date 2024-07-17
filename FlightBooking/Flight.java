package FlightBooking;

import java.util.*;
public class Flight {
    
    //for each flight details
    static int id=1;
    int flightid;
    int passengerid;
    int tickets;
    int price;
    
    Map<Integer,List<String>>flightpassengerdetails; // 1, {name,bookedticket,totalcost}

    public Flight()
    {
        flightid=id;
        id+=1;
        passengerid=1;
        tickets=50;
        price=5000;
        flightpassengerdetails = new HashMap<>();

    }
    // public void book(String name,int customerticket)
    // {
         
    // }


}
