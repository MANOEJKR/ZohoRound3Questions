package BusTicket;
import java.util.*;
public class Bus {
    
    public Customer customer;
    public double fare;
    public String bustype;
    public String feature;
    public List<Integer>Seatnumbers;
    public Bus(Customer customer , String bustype , String feature)
    {
        this.customer = customer;
        this.bustype = bustype;
        this.feature = feature;
        Seatnumbers = new ArrayList<>();
    }

    public void calcualtefare(int size)
    {
        fare = size*250;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        return super.equals(obj);
    }


}
