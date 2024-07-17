public class Taxii implements Cloneable{
    
    char currentLocation;
    static int gene=0;
     int taxiId=0;
    int customerId=0;
    char pickupLocation;
    char dropLocation;
    int pickTime;
    int dropTime;
    int Totalearning=0;
    int currentEarning=0;

    public Taxii( )
    {
        gene++;
        taxiId=gene;
        currentLocation='A';
        pickTime=0;
        dropTime=0;
        
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}
