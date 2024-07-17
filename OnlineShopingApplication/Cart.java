package OnlineShopingApplication;
import java.util.*;
public class Cart implements Cloneable{

    public int totalbill;
    public int currentBalance;
    List<Inventary>cartitems;
    public int RewardPoints;
    public Cart() {
        this.currentBalance = 10000;
        this.cartitems = new ArrayList<>();
    }

    public void addItem(Inventary inventary) {
        this.cartitems.add(inventary);
        this.totalbill += inventary.productprice;
        System.out.println("added successfully");
    }

    public void removeItem(Inventary inventary) {
        this.cartitems.remove(inventary);
        this.totalbill -= inventary.productprice;
        System.out.println("Removed Successfully");
    }
    public void showCart() {

        for (Inventary inventary : this.cartitems) {
            System.out.println(inventary);
        }
        if(cartitems.size()==0) System.out.println("No items in cart");
        System.out.println("Total bill: " + this.totalbill);
        System.out.println("Current balance: " + this.currentBalance);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        Cart clonedCart = (Cart) super.clone();
        // Perform deep copy of cartitems
        clonedCart.cartitems = new ArrayList<>(this.cartitems.size());
        for (Inventary item : this.cartitems) {
            clonedCart.cartitems.add((Inventary) item.clone());
        }
        return clonedCart;

        


    }
    

}
