package Asset_Management_System;

public class Software {
    
    public String softwarename;
    public String expiredate;
   public Vendor softwarevendor;
   public double costforsoftware;

   public Software(String softwarename, String expiredate, double costforsoftware, Vendor softwarevendor)  {
        this.softwarename = softwarename;
        this.expiredate = expiredate;
        this.costforsoftware = costforsoftware;
        this.softwarevendor = softwarevendor;
   }

    public String getSoftwarename() {
        return softwarename;
    }
    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }
    public String getExpiredate() {
        return expiredate;
    }
    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }
    public double getCostforsoftware() {
        return costforsoftware;
    }
    public void setCostforsoftware(double costforsoftware) {
        this.costforsoftware = costforsoftware;
    }
    public Vendor getSoftwarevendor() {
        return softwarevendor;
    }


}
