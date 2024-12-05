/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml.AbdullahClass;


public class Bulb extends Equipment {
      int Amount;
    protected int Price=60;
    int TotalPrice;
    int id=003;

    public String getProductName() {
        return productName;
    }
    String productName ="Bulb";

    public Bulb(int Amount) {
        this.Amount = Amount;
        TotalPrice=this.Amount*Price;
    }

    public Bulb() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public float getGetMoney() {
        return GetMoney;
    }

    public void setPrice(int Price) {
        this.Price = Price;
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

    
    
    @Override
    public String toString() {
        return "Bulb : " + "Amount=" + Amount + ", Price=" + Price + ", TotalPrice=" + TotalPrice + ", id=" + id;
    }

   

 
    
}
