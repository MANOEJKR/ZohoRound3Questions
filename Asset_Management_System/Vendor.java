package Asset_Management_System;

public class Vendor {
    
    public String vendorname;
    public int vendorid;
    public int costforinstall=100;
    public int totalcostearned=0;

    public Vendor(String vendorname,int vendorid) {
        this.vendorid = vendorid;
        this.vendorname = vendorname;
    }

    public String getVendor() {
        return vendorname;
    }

    public int getvendorid()
    {
        return vendorid;
    }
}
