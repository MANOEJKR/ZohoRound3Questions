package ParkinglotZoho;
import java.util.*;

public class ParkingLott {
    
    public String parkingAddress;
    public int totalFloors;
    List<Floor> floorList;
    List<Vechical> report;
    
    public ParkingLott(String parkingAddress, int totalFloors) {
        this.parkingAddress = parkingAddress;
        this.totalFloors = totalFloors;
        this.report = new ArrayList<>();
        floorList = new ArrayList<>();
        for (int i = 1; i <= totalFloors; i++) {
            floorList.add(new Floor(i));
        }
    }
}
