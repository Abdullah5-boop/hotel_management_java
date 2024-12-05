
package Fxml.AbdullahClass;
public class GlassSet extends Equipment {
       int Amount;
    protected int Price=60;
    String productName ="GlassSet";

    public GlassSet() {
      //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    int TotalPrice;
    int id=002;

    public String getProductName() {
        return productName;
    }

    public GlassSet(int Amount) {
        this.Amount = Amount;
        TotalPrice = this.Amount*Price;
    }

    public int getAmount() {
        return Amount;
    }

    @Override
    public String toString() {
        return "GlassSet : " + "Amount=" + Amount + ", Price=" + Price + ", TotalPrice=" + TotalPrice + ", id=" + id ;
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
