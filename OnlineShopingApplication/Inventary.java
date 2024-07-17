package OnlineShopingApplication;

public class Inventary implements Cloneable {

        public static int generateid=0;
        public int productid;
        public String productname;
        public int productprice;
        public int productquantity;
        public String description;
        public String createdBy;
        public String modifiedby;
        public String createdtime;
        public String modifiedtime;

        public Inventary(String productname ,int productprice ,int productquantity , String description , String createdBy)
        {
            this.productid = generateid++;
            this.productname = productname;
            this.productprice = productprice;
            this.productquantity = productquantity;
            this.description = description;
            this.createdBy = createdBy;
           // this.modifiedby = createdBy;
            this.createdtime = PasswordUtility.timeGenerate();
           // this.modifiedtime = PasswordUtility.timeGenerate();

        }
        public Inventary(String productname ,int productprice ,int productquantity )
        {
          //  this.productid = generateid++;
            this.productname = productname;
            this.productprice = productprice;
            this.productquantity = productquantity;
          
           // this.modifiedby = createdBy;
         //   this.createdtime = PasswordUtility.timeGenerate();
           // this.modifiedtime = PasswordUtility.timeGenerate();

        }

        @Override
        public String toString() {
        
                
        return "Inventary{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", productquantity=" + productquantity +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedby='" + modifiedby + '\'' +
                ", createdtime='" + createdtime + '\'' +
                ", modifiedtime='" + modifiedtime + '\'' ;

        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
        }
}
