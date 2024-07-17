package BusTicket;
import java.util.*;
public class Registerinfo {
    Scanner sc = new Scanner(System.in);
    // public int customerId;
    // static int customeridgenerate=0;
    // public String name;
    // public char Gender;
    // public int number;
    List<Customer>customerinformation = new ArrayList<>();
    List<Bus>Businformations = new ArrayList<>();
    public void Register()
    {
        String name;
        char Gender;
        long number;
        System.out.println("Enter name , gender, Phone number");
        name = sc.next();
        Gender =sc.next().charAt(0);
        number= sc.nextLong();
        sc.nextLine();

        if(customerinformation.size()==0)
        {
            customerinformation.add(new Customer(name, Gender, number));
        }
        else{

            for(Customer c : customerinformation)
            {
                if(c.number == number)
                {
                    System.out.println("Customer already registered");
                    return;
                }
            }
            
            customerinformation.add(new Customer(name, Gender, number));

        }
        System.out.println("Registered successfully");
        
    }

    public void login()
    {
        System.out.println("Enter name and phone number");
        String name = sc.nextLine();
        long number = sc.nextLong();
        sc.nextLine();

        for(Customer c : customerinformation)
        {
            if(c.name.equals(name) && c.number==number)
            {
                System.out.println("Logined successfully");
                Busticket(c);
                return;
            }
        }

        System.out.println("User not registered");
    }

    public void Busticket(Customer c) 
    {
        boolean exit=false;

        while(exit==false)
        {
            System.out.println(" 1) Book \n 2) Cancel \n 3) Summary \n 4) exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    Booking(c);
                    break;
                case 2:
                    Cancel(c);
                    break;
                case 3:
                    Summary(c);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }

    private void Summary(Customer c) {
         
    // public Customer customer;
    // public double fare;
    // public String bustype;
    // public String feature;
    // public List<Integer>Seatnumbers;
        if(Businformations.size()==0)
        {
            System.out.println("You have not booked yet");
        }

        for(Bus b : Businformations)
        {
            if(b.customer.equals(c))
            {
                System.out.println("Summary of booking ");
                System.out.println("---------------------------");
                System.out.println("Bus type :" + b.bustype);
                System.out.println("Bus AC or Non-AC :" + b.feature);
                System.out.println("List of seat numbers: ");
                for(Integer i : b.Seatnumbers)
                System.out.print(i +" ");
                System.out.println();
                System.out.println("Total amount :" + b.fare);
                System.out.println("-----------------------------");
                return;
            }
        }
        System.out.println("You have not booked yet");

    }

    private void Cancel(Customer c) {
        if(Businformations.size()==0)
        {
            System.out.println("You have not booked yet");
            return;
        }
        for(Bus b: Businformations)
        {
            if(b.customer.equals(c))
            {
                System.out.println("yours booked seats");
                bookedSeats(b);
                System.out.println();
                System.out.println("Enter number of seats to be canceled");
                int seatscancels = sc.nextInt();
                sc.nextLine();
                while(seatscancels!=0)
                {
                    int number= sc.nextInt();
                    sc.nextLine();
                    b.Seatnumbers.remove(b.Seatnumbers.indexOf(number));
                    seatscancels--;
                }
                b.calcualtefare(b.Seatnumbers.size());
                System.out.println("Seat Canceled successfully");
                return;

            }
            System.out.println("you have not booked yet");
        }
    }

    private void bookedSeats(Bus b) {
        
        List<Integer>seat = b.Seatnumbers;
        for(Integer i: seat)
        {
            System.out.print(i + " ");
        }
    }

    public void Booking(Customer c)
    {
        // public Customer customer;
        // public double fare;
        // public String bustype;
        // public String feature;
        // public List<Integer>Seatnumbers;
        
        System.out.println("Enter the bustype(Sleeper or General) and AC or non-AC");
        String bustype = sc.nextLine();
        String feature = sc.nextLine();
        Bus bus = new Bus(c, bustype, feature);
        bus.customer=c;
        System.out.println("Enter number of seat you want");
        int seatWant =sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the seat numbers");
        AvaiableNumber();
        while(seatWant!=0)
        {
            int seaat = sc.nextInt();
            sc.nextLine();
            bus.Seatnumbers.add(seaat);
            seatWant--;
        }
        bus.calcualtefare(bus.Seatnumbers.size());
        Businformations.add(bus);
        System.out.println("Booked succuessfully");
        
    }

    public void AvaiableNumber()
    {
        int []visited = new int [12];
        if(Businformations.size()==0)
        {
            for(int i=0;i<12;i++)
            {
                if(visited[i]==0)
                System.out.print(i+1 +" ");
            }
            System.out.println();
            return;
        }
        for(Bus b : Businformations)
        {
            List<Integer>seat = b.Seatnumbers;
            for(Integer number: seat)
            visited[number-1]=1;
        }

        for(int i=0;i<12;i++)
            {
                if(visited[i]==0)
                System.out.println(i+1);
            }
    }
}
