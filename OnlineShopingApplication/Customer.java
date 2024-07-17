package OnlineShopingApplication;

public class Customer {
    public String name;
    public String email;
    public String mobilenumber;
    public String password;
    public String CreatedTime;
    public String UpdatedTime;
    public String role;

    public Customer(String name, String email, String mobilenumber, String password,String role) {
        this.name = name;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.role = role;
        this.password =  PasswordUtility.encrpte(password);
        this.CreatedTime = PasswordUtility.timeGenerate();
        this.UpdatedTime = PasswordUtility.timeGenerate();
    
}

   
    @Override
    public String toString() {

        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", password='" +  password + '\'' +
                ", CreatedTime='" + CreatedTime + '\'' +
                ", UpdatedTime='" + UpdatedTime + '\'' +
                ", role='" + role + '\'' +
                '}';
                
    }
}
