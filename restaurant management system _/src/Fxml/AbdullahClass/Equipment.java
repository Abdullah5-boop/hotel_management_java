/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml.AbdullahClass;

import java.io.Serializable;

public class Equipment  implements Serializable  {
    
     int Amount;
    protected int Price=0;
    int TotalPrice;
    int id;
    String productName ="";
    protected float GetMoney ;

    public String getProductName() {
        return productName;
    }

    public void setGetMoney(float GetMoney) {
        this.GetMoney = GetMoney;
    }

    public float getGetMoney() {
        return GetMoney;
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
