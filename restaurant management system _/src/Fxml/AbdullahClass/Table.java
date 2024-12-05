/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml.AbdullahClass;

/**
 *
 * @author USER
 */
public class Table extends Equipment {
       int Amount;

    public String getProductName() {
        return productName;
    }
    protected int Price=60;
    int TotalPrice;
       String productName ="Table";
    int id=005;
    public Table(int Amount) {
        this.Amount = Amount;
        TotalPrice = this.Amount*Price;
    }

    public Table() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Table : " + "Amount=" + Amount + ", Price=" + Price + ", TotalPrice=" + TotalPrice + ", Tableid=" + id;
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

    public void setPrice(int Price) {
        this.Price = Price;
    }


    
    
}
