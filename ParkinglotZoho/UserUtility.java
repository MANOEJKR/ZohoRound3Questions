package ParkinglotZoho;

import java.util.*;
public class UserUtility {
    
    List<Userr>usereDetails;
    Queue<Vechical>queue;
    Scanner sc = new Scanner(System.in);
    public UserUtility() {
        this.usereDetails = new ArrayList<>();
        this.queue = new LinkedList<>();
    }

    public void RegisterUser() 
    {
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Address:");
        String address = sc.nextLine();
        System.out.println("Enter Phone Number:");
        String phonenumber = sc.nextLine();
        Userr user = new Userr(name, address, phonenumber);
        usereDetails.add(user);
        System.out.println(user.toString());
        System.out.println("User Registered Successfully!");
     //   sc.close();
    }

    public void RegisterCar()
    {
        System.out.println("Enter the user id");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the licence number");
        String licenceNumber = sc.nextLine();
        System.out.println("Enter the type ");
        String type = sc.nextLine();
        System.out.println("Enter the car model");
        String carModel = sc.nextLine();
        Vechical vechical = new Vechical( licenceNumber, carModel, type,userId);
        queue.add(vechical);


    }

    public void ParkCar(ParkingLott lott) 
    {
        if(queue.isEmpty())
        {
            System.out.println("No car registered yet");
            return;
        }
        Vechical vechical = queue.peek();

        for(int i=0;i<lott.floorList.size();i++)
        {
            // public Map<Integer,ParkingSpace> parkingspace;
            Map<Integer,ParkingSpace>duplicatespace;
           duplicatespace =lott.floorList.get(i).parkingspace;
            for(Map.Entry<Integer, ParkingSpace> entry : duplicatespace.entrySet())
            {
                if(entry.getValue().isOccupied==false)
                {
                    // entry.getValue().vechical = vechical;
                    // entry.getValue().vechical.entrytime =entry.getValue().vechical.generateTime();
                    // entry.getValue().isOccupied=true;
                    entry.getValue().parkVehicle(vechical);
                   queue.poll(); 
                    System.out.println("Car Parked Successfully!");
                    return;
                }
            }
        }

        System.out.println("No available slot in parking lot");

        
    }
    public void RemoveCar(ParkingLott lott,int givenuserid)  
    {
        //throws CloneNotSupportedException
        List<Vechical>duplicateReport=lott.report;
        for(int i=0;i<lott.floorList.size();i++)
        {
            // public Map<Integer,ParkingSpace> parkingspace;
            Map<Integer,ParkingSpace>duplicatespace;
           duplicatespace =lott.floorList.get(i).parkingspace;
            for(Map.Entry<Integer, ParkingSpace> entry : duplicatespace.entrySet())
            {
                if(entry.getValue().isOccupied==true && entry.getValue().vechical.userid == givenuserid)
                {
                    // entry.getValue().vechical = vechical;
                    // entry.getValue().vechical.entrytime =entry.getValue().vechical.generateTime();
                    // entry.getValue().isOccupied=true;
                     
                     Vechical vechical = entry.getValue().vechical;
                     vechical.exitTime = vechical.generateTime();
                     duplicateReport.add((Vechical)vechical );
                    System.out.println(vechical.toString());  
                     entry.getValue().removeVehicle();
                     System.out.println();
                     System.out.println("After the remove vechical ");
                    System.out.println();
                    vechical.toString() ;
                    return;
                }
            }
        }

        System.out.println("No car avaliable with that ID");
    }

    public void costCalculationn(ParkingLott lott)
    {
        System.out.println("in side cost");
        List<Vechical>duplicateReport=lott.report;

        for(Vechical value : duplicateReport)
        {
            value.calculateTotalCost();
            System.out.println(value.toString());
        }
    }


}
