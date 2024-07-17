package OnlineShopingApplication;
import java.util.*;

 
public class Main {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        UserUtility userutility = new UserUtility();

         userutility. userdeatils.put("admin", new Customer("admin", "admin@gamil.com","90444232","admin","admin"));
        while(!exit) {
            System.out.println(" 1 - Register \n 2 - Login \n 3 - Exit");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    userutility.register();
                    break;
                case 2:
                    userutility.login();
                    break;
                case 3:
                    exit = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

    }
}
