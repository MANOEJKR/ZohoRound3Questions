package ParkingLot;
import java.util.*;
import java.time.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingSpot Dharmapuri = new ParkingSpot();

        boolean loop = true;
        int count=1;
        while(count<=6)
        {
                System.out.println("Enter the vechical type");
                String type = sc.nextLine();

                 
                System.out.println("Enter number plate of the vechical");
                String plate = sc.nextLine();
                LocalTime currentTime =  LocalTime.now();
                Vechical vechical = new Vechical(plate , type, currentTime.getHour());
                if(Dharmapuri.checkingSpot(type , vechical))
                System.out.println("Parked vechical successfully");
                else
                System.out.println("NO available space");
               

                 
                System.out.println("To get the price of the parking");
                System.out.println("--------------------------------------");
                System.out.println("Enter the vechical type");
               type = sc.nextLine();
                System.out.println("Enter number plate of the vechical");
                 plate = sc.nextLine();
                 
                    int value=Dharmapuri.removeAndPrice(plate , type);
               
              
                if(value!=-1){
                    int nowtime = currentTime.getHour();
                System.out.println("Cost for parking is " + Math.abs(nowtime - value ));

                }
                else
                System.out.println("You have not parked the vechical");
               
                
                count++;

                
                
        }
    }
}
