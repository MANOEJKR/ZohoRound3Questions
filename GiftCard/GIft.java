package GiftCard;


import java.util.*;
 

public class GIft {

    public int cardnumber;
    public int pin;
    public int amount;
    public boolean blocked=false;
    List<String>Transaction;

    public GIft(int cardnumber,int pin)
    {
        this.cardnumber = cardnumber;
        this.pin  = pin;
        Transaction = new ArrayList<String>();

    }

    public void addAmount(int money)
    {
        amount+=money;
    }

    public void getmoneyfromgiftcard(int money)
    {
        if(money>amount)
        {
            System.out.println("Not enough money on the gift card");
        }
        else{
            amount-=money;
            System.out.println("Money withdrawn successfully");
        }
    }
    public void block()
    {
        blocked=true;
    }
    public void addhistory(String s)
    {
        Transaction.add(s);
    }

    public String toString()
    {
        
        return "Gift card number: " + cardnumber + ", Pin: " + pin + ", Amount: " + amount + ", Blocked: " + blocked;
    }

    
    
}
