package BankApplication;

public class Account {
    public String AccountNumber;
    public String Name;
    public String Password;
    public double Balance;

    public Account(String AccountNumber,String Name,String Password)
    {
        this.AccountNumber= AccountNumber;
        this.Name = Name;
        this.Password = PasswordUtility.Encrpte(Password);
        Balance=1000;
    }

    
}
