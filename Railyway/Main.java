/**
 * Main
 */
import java.util.*;
public class Main {

    
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        BookingManagement bookmanage = new BookingManagement();
        
        Boolean exit=false;

        while(!exit)
        {
            System.out.println("1) Booking");
            System.out.println("2) Cancel");
            System.out.println("3) Display Passenger");
            System.out.println("4) Exit");
            System.out.println("---------------------------");
            System.out.println("Enter your choice");
            int choice= sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookmanage.manage();
                    break;
            
                case 2:

                    break;

                case 3:
                    Display.display();
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    break;
            }

            
        }
        sc.close();
    }
}