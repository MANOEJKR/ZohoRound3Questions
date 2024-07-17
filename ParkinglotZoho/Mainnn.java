package ParkinglotZoho;
import java.util.*;
public class Mainnn {
    
    // register the user 
    public static void main(String[] args)   {
        Scanner sc =new Scanner(System.in);
        UserUtility userUtility = new UserUtility();
        ParkingLott parkingLott = new ParkingLott("Dharmapuri", 5);
        userUtility.RegisterUser();
        userUtility.RegisterCar();
        userUtility.RegisterUser();
        userUtility.RegisterCar();

        userUtility.ParkCar(parkingLott);
        userUtility.ParkCar(parkingLott);
        System.out.println("enter ticket id");
        int givenuserid = sc.nextInt();
        sc.nextLine();
        userUtility.RemoveCar(parkingLott, givenuserid);
        userUtility.costCalculationn(parkingLott);
        System.out.println("enter ticket id");
        int givenuserid2= sc.nextInt();
        sc.nextLine();
        userUtility.RemoveCar(parkingLott, givenuserid2);
        userUtility.costCalculationn(parkingLott);
        sc.close();



    }

}
