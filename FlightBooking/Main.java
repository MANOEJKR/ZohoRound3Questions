
package FlightBooking;
import java.util.*;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        
    
Scanner sc = new Scanner(System.in);
    List<Flight>TotalFlightDetails = new ArrayList<>();
    Booking booking = new Booking();
    //creating for now 5 instance 
    for(int i=0;i<5;i++)
    TotalFlightDetails.add(new Flight());

    Boolean exit=false;

    while(!exit)
    {
        System.out.println("1) BOOK \n 2) Cancel \n 3) Print passenger deatils \n 4) Exit");
        int choice=sc.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Enter flight number");
            int flightnumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name");
            String name= sc.nextLine();
            System.out.println("Enter the number of ticket");
            int customerticket = sc.nextInt();
            sc.nextLine();
            
            if(flightnumber>TotalFlightDetails.size())
            {
                System.out.println("Invalid flight number");
                break;
            }

            for(Flight value : TotalFlightDetails)
            {
                if(value.flightid == flightnumber)
                booking.book(name,customerticket,value);
            }
            break;

            case 2:
            System.out.println("Enter the flight number");
            int flightnum1 = sc.nextInt();

            if(flightnum1>TotalFlightDetails.size())
            {
                System.out.println("Invalid flight number");
                break;
            }
            System.out.println("Enter the passenger");
            int passnumber1 = sc.nextInt();
            for(Flight value : TotalFlightDetails)
            {
                if(value.flightid==flightnum1){
                booking.cancel(value,passnumber1);
                }
            }
             
            break;
            
             
             case 3:
                // System.out.println("Enter the flight number");
                // int flightnum = sc.nextInt();

                // if(flightnum>TotalFlightDetails.size())
                // {
                //     System.out.println("Invalid flight number");
                //     break;
                // }
                // System.out.println("Enter the passenger");
                // int passnumber = sc.nextInt();

                    booking.printdetailspassenger(TotalFlightDetails);
            
             break;

             case 4:
                exit=true;
                sc.close();
                 break;
        
            default:
            System.out.println("Invalid choice number");
                break;
        }
        
         

    }

}
}