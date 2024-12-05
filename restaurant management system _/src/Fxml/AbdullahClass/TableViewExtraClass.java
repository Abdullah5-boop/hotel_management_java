package Fxml.AbdullahClass;
public class TableViewExtraClass {
    int ProductPrice;
    int TotalProductPrice;
    int amount;
    String productNames;
    float UsergivenMoney;

    public TableViewExtraClass(int a, int b, String x, float c,int amount) {
       
        //To change body of generated methods, choose Tools | Templates.
        ProductPrice = a;
        TotalProductPrice = b;
        this.amount = amount;
       productNames = x;
        UsergivenMoney = c;
    }

 

    public int getProductPrice() {
        return ProductPrice;
    }

    public int getTotalProductPrice() {
        return TotalProductPrice;
    }

    public int getAmount() {
        return amount;
    }

    public String getProductNames() {
        return productNames;
    }

    public float getUsergivenMoney() {
        return UsergivenMoney;
    }

    @Override
    public String toString() {
        return "TableViewExtraClass{" + "ProductPrice=" + ProductPrice + ", TotalProductPrice=" + TotalProductPrice + ", amount=" + amount + ", productNames=" + productNames + ", UsergivenMoney=" + UsergivenMoney + '}';
    }



    
    
}
