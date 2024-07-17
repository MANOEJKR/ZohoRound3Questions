package ParkinglotZoho;
import java.util.*;
public class Floor {
    public int totalslot=20;
    public int floorNumber;
    public Map<Integer,ParkingSpace> parkingspace;
    
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingspace = new HashMap<>();
        for (int i = 1; i <= totalslot; i++) {
            parkingspace.put(i, new ParkingSpace(i, floorNumber));
        }
    }
}
