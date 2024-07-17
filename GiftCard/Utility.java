package GiftCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import java.util.Scanner;

//import javax.imageio.ImageIO;

public class Utility {

    HashMap<Integer,Customer>customerinfo = new HashMap<>();
    HashMap<Integer,List<GIft>>giftlist = new HashMap<>();
    Scanner sc= new Scanner(System.in);
    public void register() {
        
        customerinfo.put(11,new Customer(11,110110,"Kumar",10000,encrysted("manoj")));
    }

    private String encrysted(String string) {
         String en="";

         for(int i=0;i<string.length();i++)
         {
            if(string.charAt(i)=='Z')
            {
                en+='A';
            }
            else if(string.charAt(i)=='z')
            {
                en+='a';
            }
            else if(string.charAt(i)=='0')
            {
                en+='1';
            }
            else
            {
                char c =string.charAt(i);
                en+=c++;
            }
         }
         return en;

    }

    public void login() {
        System.out.println("Enter the customer id and password");
        int id = sc.nextInt();
        sc.nextLine();
        String password = sc.nextLine();

        if(customerinfo.containsKey(id))
        {
            Customer customer  = customerinfo.get(id);
            if(customer.password.equals(encrysted(password)))
            {
                System.out.println("logged in");
                showmenu(customer);
            }
        }
        else
        {
            System.out.println("customer not found");
        }
         
    }

    private void showmenu(Customer customer) {
         boolean exit=false;

         while(!exit)
         {
            System.out.println(" 1 - Create a new Gift Card\n 2 - Top- up the existing card\n 3 - Show Gift card transaction history\n 4 - block the card\n 5 - exit");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                        Creategift(customer);
                        break;
                case 2:
                        topUp(customer);
                        break;
                case 3:
                        showgiftcard(customer);
                        break;
                case 4:
                        Blockexitingcard(customer);
                        break;
                case 5:
                        exit=true;
                        break;
                        
            }
         }
    }

    private void Creategift(Customer customer) {
        
        List<GIft>customergift = giftlist.get(customer.customerid);
        
        if(customergift==null){
        customergift = new ArrayList<>();
        giftlist.put(customer.customerid,customergift);
        }

        System.out.println("Enter amount to create a gift card");
        int moneytogift = sc.nextInt();
        
        customer.getMoney(moneytogift);

        GIft gift = new GIft(generatenumber(5),generatenumber(4));
        gift.addAmount(moneytogift);
        String history = "Created a gift card from " + customer.customerid +" and money add = "+moneytogift + " with generated number "+gift.cardnumber+" and pin number "+gift.pin;
        System.out.println(history);
        gift.addhistory(history);
        customergift.add(gift);

    }

    private int generatenumber(int j) {
        int upto=9,start=1;
        for(int i=1;i<j;i++) {
            upto*=10;
            start*=10;
        }
        int number = (int) (Math.random()*upto)+start;
        return number;
    }

    private void topUp(Customer customer) {
        List<GIft>customergift = giftlist.get(customer.customerid);

        System.out.println("Enter the card number and pin");
        int cardno = sc.nextInt();
        int pinno = sc.nextInt();
        
        for(GIft gift : customergift)
        {
            if(gift.cardnumber ==cardno && gift.pin == pinno )
            {
                System.out.println("Enter amount to top up");
                int moneytogift = sc.nextInt();
                
                customer.getMoney(moneytogift);
                gift.addAmount(moneytogift);
                System.out.println("top up successfully");
               String history = "Top uped from " + customer.customerid +" to gift card and money add is  "+moneytogift;
                gift.addhistory(history);
            }
        }
       
        
    }

    private void showgiftcard(Customer customer) {
         
         
        for(GIft list : giftlist.get(customer.customerid))
        {
            System.out.println(list);
        }
    }

    private void Blockexitingcard(Customer customer) {
        System.out.println("Enter the card number to block");
        int cardno = sc.nextInt();
        for(HashMap.Entry<Integer,List<GIft>> giftlist1 : giftlist.entrySet() )
        {
            List<GIft> giftlistinner  = giftlist1.getValue();
            for(GIft gift : giftlistinner)
            {
                if(gift.cardnumber == cardno)
                {
                    gift.block();
                    customer.balance+=gift.amount;
                    System.out.println("Card blocked successfully");
                    break;
                }
            }
            break;
        }

    }

    public void Purchase() {
        System.out.println("your bill amount: ");
        int bill = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your card number");
        int cardno = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the PIN:");
        int pinno = sc.nextInt();

        for(HashMap.Entry<Integer,List<GIft>>giftlist1 : giftlist.entrySet() )
        {
            List<GIft> giftlistinner  = giftlist1.getValue();
            for(GIft gift : giftlistinner)
            {
                if(gift.cardnumber == cardno && gift.pin == pinno && gift.blocked==false) {
                    gift.getmoneyfromgiftcard(bill);
                    String history = "Money as used by this much amount -> "+bill;
                    gift.addhistory(history);
                    System.out.println("Available Balance: " + gift.amount);
                    System.out.println("Purchase successful");
                    break;
                }
            }
            break;
        }
        
    }

}
