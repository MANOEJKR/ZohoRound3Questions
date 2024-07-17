package GiftCard;

public class Customer {
    int customerid;
    int accountNo;
    String name;
    int balance;
    String password;

    public Customer(int customerid,int accountNo,String name ,int balance , String password)
    {
        this.customerid = customerid;
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }


    public int getBalance()
    {
        return balance;
    }

    public void getMoney(int money )
    {
        if(money>balance)
        {
            System.out.println("Insufficient balance");
        }
        else{
            balance -= money;
             
        }
    }


}
