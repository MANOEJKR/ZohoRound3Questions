package OnlineShopingApplication;

import java.util.*;
public class UserUtility {
    Scanner sc = new Scanner(System.in);
    HashMap<String,Customer>userdeatils = new HashMap<String,Customer>();
    HashMap<String,Inventary>inventarys = new HashMap<>();
    HashMap<String,Cart>CustomerCart = new HashMap<>();
    HashMap<String,List<Cart>>CustomerPurchaseHistory = new HashMap<>();

//     public Customer(String name, String email, String mobilenumber, String password,String role) {
//         this.name = name;
//         this.email = email;
//         this.mobilenumber = mobilenumber;
//         this.role = role;
//         this.password =  PasswordUtility.encrpte(password);
//         this.CreatedTime = PasswordUtility.timeGenerate();
//         this.UpdatedTime = PasswordUtility.timeGenerate();
// }

    public void register() {
        System.out.println("Enter your name, email, password, and mobile number:");
        String name = sc.nextLine();
        String email = sc.nextLine();
        String password = sc.nextLine();
        String mobilenumber = sc.nextLine();
        Customer customer = new Customer(name,email,mobilenumber,password,"customer");

        if(userdeatils.get(name) != null)
        {
            System.out.println("User already exist");
        }
        else
        {
            userdeatils.put(name,customer);
            System.out.println("User registered successfully");
        }
    
    }

    public void login() throws CloneNotSupportedException {
        System.out.println("Enter your name and password:");
        String name = sc.nextLine();
        String password = sc.nextLine();
        Customer customer = userdeatils.get(name);
        if(customer == null)
        {
            System.out.println("User does not exist");
        }
        else if(customer.password.equals(PasswordUtility.encrpte(password)))
        {
            System.out.println("User logged in successfully");
              UserActivity(customer);
        }
        else
        {
            System.out.println("Incorrect password");
        }

    }

    private void UserActivity(Customer customer) throws CloneNotSupportedException {
         if(customer.role.equals("admin"))
         {
            boolean exit = false;
            while(!exit)
            {
                System.out.println(" 1 - Change password \n 2 - Update profile \n 3 - Create Manager \n 4 -Update Manager \n 5 - Remove Manager \n 6 - Add inventory \n 7 Update inventory \n 8 - Remove inventory \n 9 - View inventory \n 10 - Exit ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:
                        changePassword(customer);
                        break;
                    case 2:
                        updateProfile(customer);
                        break;
                    case 3:
                        createManager();
                        break;
                    case 4:
                        updateManager();
                        break;
                    case 5:
                        removeManager();
                        break;
                    case 6:
                        addInventory();
                        break;
                    case 7:
                       updateInventory();
                        break;
                    case 8:
                        removeInventory();
                        break;
                    case 9:
                        viewInventory();
                        break;
                    case 10:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
         }
         else if(customer.role.equals("manager"))
         {
             boolean exit = false;

             while(!exit)
             {
                 System.out.println(" 1 - change password \n 2 - Update profile \n 3 - Add inventory \n 4 -Update inventory \n 5 - Remove inventory \n 6 - View inventory \n 7 - Exit ");
                 int choice = sc.nextInt();
                 sc.nextLine();
                 switch(choice)
                 {
                     case 1:
                         changePassword(customer);
                         break;
                     case 2:
                         updateProfile(customer);
                         break;
                     case 3:
                         addInventoryManger();
                         break;
                     case 4:
                         viewInventory();
                         break;
                     case 5:
                         exit = true;
                         break;
                     default:
                         System.out.println("Invalid choice");
                         break;
                 }
             }
         }
         else 
         {
            boolean exit = false;
            while(!exit)
            {
                System.out.println(" 1 - change password \n 2 - Update profile \n 3 - view products \n 4 - Add to cart \n 5 - Remove an item from cart \n 6- view cart \n 7 - Purchase \n 8 - Cancel order \n 9 - View purchase history \n 10 - Add money to wallet \n 11 - View money in Balance \n 12 - Redeem reward points \n 13 - Exit");
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice)
                {
                    case 1:
                        changePassword(customer);
                        break;
                    case 2:
                        updateProfile(customer);
                        break;
                    case 3:
                        viewInventory();
                        break;
                    case 4:
                        addToCart(customer);
                        break;
                    case 5:
                        removeFromCart(customer);
                        break;
                    case 6:
                        viewCart(customer);
                        break;
                    case 7:
                        purchase(customer);
                        break;
                    case 8:
                         removeFromCart(customer);
                        break;
                    case 9:
                          viewPurchaseHistory(customer);
                        break;
                    case 10:
                        addMoneyToWallet(customer);
                        break;
                    case 11:
                        viewBalance(customer);
                        break;
                    case 12:
                          redeemRewardPoints(customer);
                        break;
                    case 13:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
         }
    }

     

     

    private void redeemRewardPoints(Customer customer) {
         Cart cart  = CustomerCart.get(customer.name);
         System.out.println("Total redeem point is : " + cart.RewardPoints);
        cart.currentBalance+= cart.RewardPoints/10;
        cart.RewardPoints = Math.abs(cart.RewardPoints -cart.RewardPoints/10);
         System.out.println("Redeem points is converted to reward money successfully");
    }

    private void viewBalance(Customer customer) {
         System.out.println(CustomerCart.get(customer.name).currentBalance);
    }

    private void addMoneyToWallet(Customer customer) {
         System.out.println("Enter the amount to add");
         int amount = sc.nextInt();
         sc.nextLine();
         CustomerCart.get(customer.name).currentBalance+=amount;
         System.out.println("Added successfully");
    }

    private void viewPurchaseHistory(Customer customer) {
         List<Cart>purchasehistory = CustomerPurchaseHistory.get(customer.name);
         if(purchasehistory.size()==0)
         {
            System.out.println("Not purchased yet");
         }
         else
         {
            //int index=0;
            for(Cart cart : purchasehistory)
            {
                
                
                 cart.showCart();
                // index++;
            }

         }
    }

    private void purchase(Customer customer) throws CloneNotSupportedException {
       // HashMap<String,List<Cart>>CustomerPurchaseHistory = new HashMap<>();
         
        System.out.println("inside purchase");
        Cart cart = CustomerCart.get(customer.name);
        if(cart == null)
        {
            System.out.println("no cart found");
            return;
        }
        if(cart.totalbill> cart.currentBalance) 
        {
            System.out.println("Insufficient balance");
            return;
        }

        if(cart!=null)
        {
            int value = cart.totalbill/100;
            cart.RewardPoints = value;
            System.out.println(cart.RewardPoints);
           
            cart.currentBalance-=cart.totalbill;
             
           List<Cart>hiscart;
            if(CustomerPurchaseHistory.containsKey(customer.name) == false)
            {
                hiscart = new ArrayList<Cart>();
                 
            }
            else{
                hiscart = CustomerPurchaseHistory.get(customer.name);
            }
            
            hiscart.add((Cart)cart.clone());
            
            CustomerPurchaseHistory.put(customer.name , hiscart);
            cart.cartitems.clear();
            cart.totalbill=0;
            System.out.println("Order placed successfully");
            }
        }
         
           
    

    private void viewCart(Customer customer) {
        Cart cart = CustomerCart.get(customer.name);
        cart.showCart();
    }

    private void removeFromCart(Customer customer) {
        System.out.println("Enter the product name to remove from cart");
        String productname = sc.nextLine();
        Cart cart = CustomerCart.get(customer.name);
        if(cart==null)
        {
            System.out.println("Cart is empty");
            return;
        }
        else
        {
          //  List<Inventary>cartitems= cart.cartitems;
            for(int i=0;i<cart.cartitems.size();i++)
            {
                if(cart.cartitems.get(i).productname.equals(productname)){
                    Inventary inventary =  inventarys.get(productname);
                    inventary.productquantity+=cart.cartitems.get(i).productquantity;
                cart.removeItem(cart.cartitems.get(i));
                }
            }
            
            
        }
         
    }



    private void addToCart(Customer customer) {

        System.out.println("Enter the product name");
        String productname = sc.nextLine();
        System.out.println("Enter the quantiy of the product");
        int quantity = sc.nextInt();
        sc.nextLine();
        Inventary inventary = inventarys.get(productname);
        if(inventary != null)
        {
            if(inventary.productquantity < quantity)
            {
                System.out.println("Not enough quantity");
            }
            else
            {
                inventary.productquantity-=quantity;
                Cart cart = CustomerCart.get(customer.name);
                if(cart == null)
                {
                    cart = new Cart();
                    Inventary forcustomerinventary = new Inventary(productname,inventary.productprice*quantity,quantity);
                    cart.addItem(forcustomerinventary);
                    CustomerCart.put(customer.name,cart);
                }
                else{
                    Inventary forcustomerinventary = new Inventary(productname,inventary.productprice*quantity,quantity);
                    cart.addItem(forcustomerinventary);
                }
            }
        }
        else{
            System.out.println("Item out of stock");
        }
        
    }


    private void addInventoryManger() {
        System.out.println("Enter product name, price, quantity, description");
        String productname = sc.nextLine();
        int price = sc.nextInt();
        sc.nextLine();
        int quantity = sc.nextInt();
        sc.nextLine();
        String description = sc.nextLine();
        Inventary inventary = new Inventary(productname,price,quantity,description,"manager");
        inventarys.put(productname,inventary);
        System.out.println("Item added successfully");
    }

    private void viewInventory() {
    
        for(Map.Entry<String,Inventary> it: inventarys.entrySet())
        {
            System.out.println(it.getValue());
        }
    }

    private void removeInventory() {
         System.out.println("Enter product name");
         String productname = sc.nextLine();
         Inventary inventary = inventarys.get(productname);
         if(inventary != null)
         {
             inventarys.remove(productname);
             System.out.println("Item removed successfully");
         }
         else
         {
             System.out.println("Item does not exist");
         }
    }

    private void updateInventory() {
        
        System.out.println("Enter the product name ,product price, quantity");
        String productname  =sc.nextLine();
        int price = sc.nextInt();
        sc.nextLine();
        int quantity = sc.nextInt();
        sc.nextLine();
        Inventary inventary = inventarys.get(productname);
        if(inventary==null)
        {
            System.out.println("Item does not exist");
        }
        else
        {
            inventary.productprice = price;
            inventary.productquantity = quantity;
            inventary.modifiedby="admin";
            inventary.modifiedtime = PasswordUtility.timeGenerate();
            System.out.println("Updated inventory successfully");
        }
    }

    private void addInventory() {
        
        System.out.println("Enter product name, product price, product quantity, description:");
        String productname = sc.nextLine();
        int productprice = sc.nextInt();
        sc.nextLine();
        int productquantity = sc.nextInt();
        sc.nextLine();
        String description =sc.nextLine();
        
        Inventary inventary = new Inventary(productname,productprice,productquantity,description,"admin");
        if(inventarys.get(productname)!=null)
        {
            System.out.println("Item already exits");
        }
        else
        {
            inventarys.put(productname, inventary);
            System.out.println("Added inventory successfully");
        }
    }

    private void removeManager() {
        System.out.println("Enter manager name:");
        String name = sc.nextLine();
        Customer customer = userdeatils.get(name);
        if(customer!= null)
        {
            userdeatils.remove(name);
            System.out.println("Manager removed successfully");
        }
        else
        {
            System.out.println("Manager does not exist");
        }
    }

    private void updateManager() {
        System.out.println("Enter manager name, email, password, and mobile number:");
        String name = sc.nextLine();
        String email = sc.nextLine();
        String password = sc.nextLine();
        String mobilenumber = sc.nextLine();
        
        Customer customer = userdeatils.get(name);
        if(customer != null)
        {
            customer.name =name;
            customer.email =email;
            customer.password = PasswordUtility.encrpte(password);
            customer.mobilenumber = mobilenumber;
            customer.UpdatedTime = PasswordUtility.timeGenerate();
            System.out.println("Manager updated successfully");
        }
        else
        {
            System.out.println("Manager does not exist");
        }
        
         
    }

    private void createManager() {
        System.out.println("Enter manager name, email, password, and mobile number:");
        String name = sc.nextLine();
        String email = sc.nextLine();
        String password = sc.nextLine();
        String mobilenumber = sc.nextLine();
        Customer customer = new Customer(name,email,mobilenumber,password,"manager");
        userdeatils.put(name,customer);
        System.out.println("Manager created successfully");
    }

    private void updateProfile(Customer customer) {
         System.out.println("Enter new name:");
         String name = sc.nextLine();
         customer.name = name;
         System.out.println("Enter new email:");
         String email = sc.nextLine();
         customer.email = email;
         System.out.println("Enter new mobile number:");
         String mobilenumber = sc.nextLine();
         customer.mobilenumber = mobilenumber;
         customer.UpdatedTime = PasswordUtility.timeGenerate();
         System.out.println("Profile updated successfully");
    }

    private void changePassword(Customer customer) 
    {
        System.out.println("Enter new password:");
        String password = sc.nextLine();
        customer.password =  PasswordUtility.encrpte(password);
        customer.UpdatedTime = PasswordUtility.timeGenerate();
        System.out.println("Password changed successfully");
    }
        

}
