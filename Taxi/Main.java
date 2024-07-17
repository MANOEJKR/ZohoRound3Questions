import java.util.*;

//import javax.xml.crypto.Data;

public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        Boolean exit=false;
        int customerid=0;
        TaxiUtility taxiUtility = new TaxiUtility();
        DataBase dataBase = new DataBase();

        while(!exit)
        {
            System.out.println("1) Book \n 2)History \n 3) Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter pickuplocation");
                    char userpickupLocation = sc.next().charAt(0);
                    System.out.println("Enter droplocation ");
                    char userdroplocation  =sc.next().charAt(0);
                    System.out.println("Enter pickup time");
                    int userpickuptime = sc.nextInt();
                    taxiUtility.book(userpickupLocation,userdroplocation,userpickuptime,++customerid,dataBase);
                    break;
                case 2:
                    taxiUtility.print(dataBase);
                    break;
            
                 case 3:
                    exit=true;
                    sc.close();
                    break;
                default:
                    break;
            }
        }

    }
}
