package BankApplication;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        CustomerUtility customerUtility = new CustomerUtility();
        boolean exit=false;

        while(!exit)
        {
            System.out.println(" 1 - Create Account \n 2 - Deposite \n 3 - Withdraw \n 4 - Transfer \n 5 - View History of Account \n 6 - Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                        customerUtility.CreatingAccount();
                         break;
                case 2:
                        System.out.println("Enter the money to deposite");
                        double money = sc.nextDouble();
                        sc.nextLine();
                        customerUtility.Deposite(money);
                        break;
                case 3:
                        System.out.println("Enter the money to withdraw");
                        double money2 = sc.nextDouble();
                        sc.nextLine();
                        customerUtility.Deposite(money2);
                         break;
                case 4:
                        System.out.println("Enter the money to transfer");
                        double money3 = sc.nextDouble();
                        sc.nextLine();
                        customerUtility.TransferAmount(money3);
                        break;
                case 5:
                        System.out.println("Enter Account number to view the history");
                        String number = sc.nextLine();
                        customerUtility.ViewHistory(number);
                        break;
                case 6:
                        exit=true;
                        sc.close();
                        break;

            
                default:
                System.out.println("Invalid input number");
                    break;
            }
        }
        
    }
}
