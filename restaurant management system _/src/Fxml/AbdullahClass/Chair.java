package Fxml.AbdullahClass;
public class Chair extends Equipment {
    int Amount;
    int TotalPrice;
    int id=001;
    String productName ="Chair";
    protected int Price=50;

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getProductName() {
        return productName;
    }
    

    

    public Chair(int Amount) {
        this.Amount = Amount;
        TotalPrice=this.Amount*Price;
    }
        public Chair() {}

    @Override
    public String toString() {
        return "Chair : " + "Amount=" + Amount + ", Price=" + Price + ", TotalPrice=" + TotalPrice + ", id=" + id ;
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
