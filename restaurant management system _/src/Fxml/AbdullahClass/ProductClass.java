package Fxml.AbdullahClass;

import java.io.Serializable;

public class ProductClass implements Serializable {
    String ProductName;
    float ProductPrice;

    public ProductClass(String ProductName, float ProductPrice) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
    }

    @Override
    public String toString() {
        return "ProductName=" + ProductName + ", ProductPrice=" + ProductPrice +"\n";
    }
    
    
}