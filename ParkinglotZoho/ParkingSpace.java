
package ParkinglotZoho;

public class ParkingSpace {
    public int floorNumber;
    public boolean isOccupied;
    public Vechical vechical;
    public int slotnumber;

    public ParkingSpace(int slotnumber,int floorNumber) {
        this.floorNumber = floorNumber;
        this.slotnumber = slotnumber;
        isOccupied = false;
        vechical = null;
    }

    public void parkVehicle(Vechical vechical) {
        this.isOccupied = true;
        this.vechical = vechical;
        System.out.println("Ticket id: " + vechical.userid);
        System.out.println("Vehicle parked at " + floorNumber + "st floor and slot number is : " + slotnumber);
    }
    
    public void removeVehicle() {
        this.isOccupied = false;
        this.vechical = null;
        
        System.out.println("Vehicle removed from " + floorNumber + "st floor and slot number is : " + slotnumber);
     //  System.out.println("to check: " + vechical.entrytime);
    }





}
