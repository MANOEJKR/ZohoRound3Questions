package BusTicket;

public class Customer {
    
    public int customerId;
    static int customeridgenerate=0;
    public String name;
    public char Gender;
    public long number;

    public Customer(String name , char Gender,long number)
    {
        customeridgenerate++;
        customerId=customeridgenerate;
        this.name = name;
        this.Gender = Gender;
        this.number = number;
    }
    
}
