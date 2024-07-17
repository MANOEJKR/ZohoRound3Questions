 

import java.util.*;

public class TaxiUtility {
    

    public void book(char userpickupLocation,char userdroplocation , int userpickuptime , int customerid , DataBase dataBase) throws CloneNotSupportedException
    {
        List<Taxii>taxi2 = dataBase.taxi;
        List<Taxii>TotalHistory2 = dataBase.TotalHistory;
         Taxii TaxiFind  = null;
        int dis=Integer.MAX_VALUE;
         for(Taxii t : taxi2)
         {
            if(t.dropTime <= userpickuptime && Math.abs(t.currentLocation - userpickupLocation)<=dis)
            {
                if(dis==Math.abs(t.currentLocation - userpickupLocation ) )
                {
                   // System.out.println("number "+ TaxiFind.taxiId); 

                    if(t.Totalearning< TaxiFind.Totalearning )
                    {
                     //   System.out.println("number earning is less "+ TaxiFind.taxiId); 
                        TaxiFind = t;
                    }
                }
                else{
                     
                TaxiFind = t;
                dis  = Math.abs(t.currentLocation - userpickupLocation);
                }
            }
         }
          
         if(TaxiFind==null)
         {
            customerid--;
            System.out.println("There is no taxi available right now try again later");
            return;
         }

         //updating the taxi
         TaxiFind.customerId = customerid;
         TaxiFind.currentLocation = userdroplocation;
         TaxiFind.pickupLocation = userpickupLocation;
         TaxiFind.dropLocation = userdroplocation;
         TaxiFind.pickTime = userpickuptime;
         TaxiFind.dropTime+=userpickuptime + Math.abs(userpickupLocation-userdroplocation);
         TaxiFind.currentEarning = Math.abs(userpickupLocation-userdroplocation) * (200);
         TaxiFind.Totalearning +=TaxiFind.currentEarning;
         TotalHistory2.add((Taxii)TaxiFind.clone());
         System.out.println("Booked successfully");
         System.out.println(TaxiFind.currentEarning +" is the charge");

    }

    public void print(DataBase dataBase)
    {
        List<Taxii>TotalHistory2 = dataBase.TotalHistory;
      //  int count  =  dataBase.taxi.size();
        // char currentLocation;
        // static int taxiId=0;
        //  int customerId=0;
        //  char pickupLocation;
        //  char dropLocation;
        //  int pickTime;
        //  int dropTime;
        //  int Totalearning=0;
        //  int currentEarning=0;
       // int start=1;
        
            Boolean visited = false;
        for(Taxii value : TotalHistory2)
        {
             
                if(!visited)
                {
                System.out.println("Taxi id || customerid || pickuplocation || droplocation || picktime || droptime || currentTripEarning || TotalEarning");
                    visited = true;
                }
                System.out.println(value.taxiId +"  " + value.customerId + "  " + value.pickupLocation + "  " +value.dropLocation+"  "+ value.pickTime +"  " + value.dropTime + "  " + value.currentEarning + "  " +  value.Totalearning);
            
             
        }
         

    }
    
}
