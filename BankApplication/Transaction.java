package BankApplication;

public class Transaction {

    public String type;
    public String toAccount="";
    public double Amount;
    
    public Transaction(String type , String toAccount, double Amount)
    {
        this.type = type;
        this.toAccount = toAccount;
        this.Amount = Amount;
    }

    public Transaction(String type ,double Amount)
    {
        this.Amount=Amount;
        this.type = type;
    }

    @Override
    public String toString() {
        
        if(type == "Transfer")
        return type + " " + toAccount +"  "+ Amount;

        if(type=="Deposite")
        return type +"  +"+Amount;

        if(type=="Withdraw")
        return type+"   -"+Amount;

        return type+"  "+Amount;

        
    }

}
