import java.util.*;
public class BookingManagement {
    Scanner sc = new Scanner(System.in);
    public int totalBirth=0;
    public int lower=1;
    public int middle=1;
    public int upper=1;
    public int totalRAC =1;
    public int totalWaiting=1;

    public static List<Passenger>confirmberthList = new ArrayList<>();
    public static List<Passenger>RACberthList = new ArrayList<>();
    public static List<Passenger>WaitingList = new ArrayList<>();
    
   static Passenger passenger;
    public void manage()
    {
        String name,birthpreference;
        int age;
         System.out.println("Enter name");
         name = sc.nextLine();
         System.out.println("Enter age");
         age = sc.nextInt();
         sc.nextLine();
         System.out.println("Enter birth preference");
         birthpreference = sc.nextLine();
           passenger = new Passenger(name, age, birthpreference);

         if(totalBirth!=0)
         {
            if(birthpreference.equalsIgnoreCase("lower"))
            {
                if(lower!=0){
                    lower--;
                    totalBirth--;
                    Booking.book(1);
                }
                else
                    SuggestBerth(passenger);
                
            }
            else if(birthpreference.equalsIgnoreCase("middle"))
            {
                if(middle!=0){
                    middle--;
                    totalBirth--;
                    Booking.book(1);
                }
                else
                    SuggestBerth(passenger);
            }
            else{

                if(upper!=0){
                    upper--;
                    totalBirth--;
                    Booking.book(1);
                }
                else
                SuggestBerth(passenger);
            }
         }
         else if(totalRAC!=0)
         {
            System.out.println("Confirmed birth is not available ");
            System.out.println("Will to book in RAC Birth(YES/NO)");
            Boolean option = sc.nextBoolean();
            if(option)
            {
                totalRAC--;
                Booking.book(2);
            }
            else{
                System.out.println("Thank you for interest");
            }
         }
         else if(totalWaiting!=0)
         {
            System.out.println("Confirmed birth  and RAC Birth is not available ");
            System.out.println("Will to book in Waiting Birth(true/false)");
            Boolean option = sc.nextBoolean();
            if(option)
            {
                totalWaiting--;
                Booking.book(3);
            }
            else{
                System.out.println("Thank you for interest");
            }
         }
         else
         System.out.println("No ticket Available");

    }

    public void SuggestBerth(Passenger passenger)
    {
        if(lower!=0)
            System.out.println("1) Lower");
        
        if(middle!=0)
        System.out.println("1) Middle");

        if(upper!=0)
        System.out.println("1) upper");

        System.out.println(" 0)Not interest");
        int choice =sc.nextInt();
        sc.nextLine();

        if(choice!=0)
        Booking.book(choice);
        else
        System.out.println("Try next time");
    }
}
