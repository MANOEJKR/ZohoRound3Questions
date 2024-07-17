package BankApplication;

import java.util.*;

public class CustomerUtility {
    
    Map<String,Account>CustomerInformation = new HashMap<>();
    Map<String,List<Transaction>>TransactionHistory = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    // public String AccountNumber;
    // public String Name;
    // public String Password;
    // public double Balance;

    // public Account(String AccountNumber,String Name,String Password)
    // {
    //     this.AccountNumber= AccountNumber;
    //     this.Name = Name;
    //     this.Password = PasswordUtility.Encrpte(Password);
    //     Balance=1000;
    // }
    public void CreatingAccount()
    {
        System.out.println("Enter accountnumber , password, name");
        String Accountnumber = sc.nextLine();
        String password = sc.nextLine();
        String name = sc.nextLine();
        
        for(Map.Entry<String,Account> it : CustomerInformation.entrySet())
        {
            if(it.getKey().equals(Accountnumber))
            {
                System.out.println("Account Already created");
                return;
            }
        }
        CustomerInformation.put(Accountnumber,new Account(Accountnumber, name, password));
        List<Transaction>transactions = new ArrayList<>();

        transactions.add(new Transaction("Opening",1000 ));
        TransactionHistory.put(Accountnumber,transactions);
        System.out.println("Account created successfully");

    }

    public void Deposite(double money)
    {
        System.out.println("Enter accountnumber, password");
        String Accountnumber = sc.nextLine();
        String password = sc.nextLine();

       if (!CustomerInformation.containsKey(Accountnumber)){
       System.out.println("Account not created");
       return;
       }

       Account account = CustomerInformation.get(Accountnumber);

       if(CheckValidUser(Accountnumber,password))
       {
            account.Balance +=money;
            Transfermethod("Deposite",money,Accountnumber);
       }
       else
       System.out.println("Invalid password");

       System.out.println("Deposited Successfully");
       
    }

    public void Withdraw(double money)
    {
        System.out.println("Enter accountnumber, password");
        String Accountnumber = sc.nextLine();
        String password = sc.nextLine();

       if (!CustomerInformation.containsKey(Accountnumber)){
       System.out.println("Account not created");
       return;
       }

       Account account = CustomerInformation.get(Accountnumber);

       if(CheckValidUser(Accountnumber,password))
       {
            if(account.Balance-money>=500)
            account.Balance -=money;
            else
            {
                System.out.println("Not enough Balance to withdraw");
                return;
            }
            Transfermethod("Withdraw",money,Accountnumber);
       }
       else
       System.out.println("Invalid password");

       System.out.println("Withdraw Successfully");
    }

    public void TransferAmount(double money)
    {
        System.out.println("Enter fromaccountnumber, password");
        String Accountnumber = sc.nextLine();
        String password = sc.nextLine();

        if (!CustomerInformation.containsKey(Accountnumber)){
            System.out.println("From Account not created");
            return;
        }
        
         

        Account account = CustomerInformation.get(Accountnumber);

        if(CheckValidUser(Accountnumber,password))
       {
             System.out.println("Enter the to account number ");
             String toAccount = sc.nextLine();
             if(!CustomerInformation.containsKey(toAccount)){
             System.out.println("To account is not created");
             return;
             }

             if(account.Balance-money>=500)
                 account.Balance -=money;
            else
            {
                System.out.println("Not enough Balance to Transfer amount");
                return;
            }

             Transfermethodfortoandfrom(toAccount,Accountnumber,"Transfer",money);
       }
       else
       System.out.println("Invalid password");

       System.out.println("Withdraw Successfully");

    }

    private void Transfermethodfortoandfrom(String toAccount, String accountnumber, String type, double money) {
         
        List<Transaction>transactionsfrom = TransactionHistory.get(accountnumber);
        transactionsfrom.add(new Transaction(type, toAccount,money));
        

    }

    private void Transfermethod(String type, double money, String accountnumber) {
         
        List<Transaction>transactions = TransactionHistory.get(accountnumber);

        transactions.add(new Transaction(type, money));

    }

    private boolean CheckValidUser(String accountnumber, String Password) {
         
        if(PasswordUtility.Encrpte(Password).equals(CustomerInformation.get(accountnumber).Password))
        return true;

        return false;
    }

    public void ViewHistory(String Accountnumber) {
        
       if (!CustomerInformation.containsKey(Accountnumber)){
       System.out.println("Account not created");
       return;
       }
       System.out.println("Enter the password");
       String password = sc.nextLine();
 

       if(CheckValidUser(Accountnumber,password))
       {
             List<Transaction>transactions = TransactionHistory.get(Accountnumber);

             for(Transaction value: transactions)
             {
                System.out.println(value);
             }
       }
       else
       System.out.println("Invalid password");
        
    }

     



    


}
