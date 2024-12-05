
package Fxml.AbdullahClass;
public class PlateSet extends Equipment {
           int Amount;
   protected int Price=60;
   String productName ="PlateSet";

    public PlateSet() {
       //hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getProductName() {
        return productName;
    }
    int TotalPrice;
int id=004;
    public PlateSet(int Amount) {
        this.Amount = Amount;
        TotalPrice= this.Amount*Price;
    }

    public int getAmount() {
        return Amount;
    }

    public int getPrice() {
        return Price;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlateSet : " + "Amount=" + Amount + ", Price=" + Price + ", TotalPrice=" + TotalPrice + ", id=" + id ;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    
}
