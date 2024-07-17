import java.util.*;

public class DataBase {
    int taxiCount=4;
    List<Taxii>taxi;
    List<Taxii>TotalHistory;
    public DataBase()
    {
        taxi = new ArrayList<>();
        for(int i=0;i<taxiCount;i++)
           taxi.add(new Taxii());
           
       TotalHistory = new ArrayList<>();
    }
}
