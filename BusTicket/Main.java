package BusTicket;

import java.util.*;

public class Main {
    
    public static void main(String [] args)
    {
        Registerinfo registerinfo = new Registerinfo();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(exit == false)
        {
            System.out.println(" 1) login \n 2) Register  \n 3) Exit");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    registerinfo.login();
                    break;
                case 2:
                    registerinfo.Register();
                    break;
                case 3:
                    exit=true;
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }


        
    }
}
