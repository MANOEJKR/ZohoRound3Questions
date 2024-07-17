package GiftCard;
import java.util.*;
public class Main {

    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        boolean exit= false;

        while(!exit)
        {
            System.out.println(" 1 - Register\n 2 - Login\n 3 - Purchase\n 4 - Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    utility.register();
                    break;

                case 2:
                     utility.login();
                     break;
                
                case 3:
                    utility.Purchase();
                    break;

                case 4:
                    exit=true;
                    break;
            
                default:
                    break;
            }
        }
    }
    
}
