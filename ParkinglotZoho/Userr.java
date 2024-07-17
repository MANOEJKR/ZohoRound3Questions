package ParkinglotZoho;

public class Userr {
    
    public static int generateid=0;
    public int userid;
    public String name;
    public String address;
    public String phonenumber;

    public Userr(String name, String address, String phonenumber) {
        userid = ++generateid;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

}
