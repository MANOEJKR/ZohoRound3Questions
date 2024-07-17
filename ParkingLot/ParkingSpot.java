package ParkingLot;
import java.util.*;
public class ParkingSpot {
    
    List<Parkinglot>car;
    List<Parkinglot>medium;
    List<Parkinglot>large;
  //  List<Parkinglot>truck;

    public ParkingSpot()
    {
        car = new ArrayList<>();
        medium = new ArrayList<>();
        large = new ArrayList<>();

        for(int i=0;i<1;i++)
        {
            car.add(new Parkinglot());
            medium.add(new Parkinglot());
            large.add(new Parkinglot());
        }
    }


    public boolean checkingSpot(String type ,Vechical vechical )
    {
        
        
        if(type.equals("car"))
        {
             
            for(int i=0;i<car.size();i++)
            {
                if(car.get(i).isoccupied==false)
                {
                    car.get(i).isoccupied = true;
                    car.get(i).vechical = vechical;
                    return true;
                    
                }
            }
           
                
        }
        else if(type.equals("medium"))
        {
            
            for(int i=0;i<medium.size();i++)
            {
                if(medium.get(i).isoccupied ==false)
                {
                    medium.get(i).isoccupied = true;
                    medium.get(i).vechical = vechical;
                     return true;
                }
            }
        }
        else{
            
            for(int i=0;i<large.size();i++)
            {
                if(large.get(i).isoccupied==false)
                {
                    large.get(i).isoccupied = true;
                    large.get(i).vechical = vechical;
                    return true;
                }
            }
        }
         
        return false;
    }

    public int removeAndPrice(String plate , String type)
    {
        int duration =-1;
        if(type.equals("car"))
        {
             
            for(int i=0;i<car.size();i++)
            {
               
                if(car.get(i).vechical!=null  &&car.get(i).vechical.vechicalNumberPlate.equals(plate))
                {
                     duration = car.get(i).vechical.time;

                    car.get(i).removeVechical();
                     
                }
            }
        }
        else if(type.equals("medium"))
        {
            for(int i=0;i<medium.size();i++)
            {
                if(medium.get(i).vechical!=null && medium.get(i).vechical.vechicalNumberPlate.equals(plate))
                {
                     duration = medium.get(i).vechical.time;

                    medium.get(i).removeVechical();
                     
                }
            }
        }
        else{
            for(int i=0;i<large.size();i++)
            {
                if(large.get(i).vechical!=null && large.get(i).vechical.vechicalNumberPlate.equals( plate))
                {
                     duration = large.get(i).vechical.time;

                    large.get(i).removeVechical();
                     
                }
            }
        }

         return duration;
    }

}
