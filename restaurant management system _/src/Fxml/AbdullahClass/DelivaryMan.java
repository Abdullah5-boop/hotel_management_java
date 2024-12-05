package Fxml.AbdullahClass;

import java.io.Serializable;

public class DelivaryMan implements Serializable  {
   String DalivaryManName,DelivaryManLoactoin;
   int DelivaryManPhn,DelivaryManPrice;
   

    public DelivaryMan(String DalivaryManName, String DelivaryManLoactoin, int DelivaryManPhn, int DelivaryManPrice) {
        this.DalivaryManName = DalivaryManName;
        this.DelivaryManLoactoin = DelivaryManLoactoin;
        this.DelivaryManPhn = DelivaryManPhn;
        this.DelivaryManPrice = DelivaryManPrice;
    }

    public String getDalivaryManName() {
        return DalivaryManName;
    }

    public String getDelivaryManLoactoin() {
        return DelivaryManLoactoin;
    }

    public int getDelivaryManPhn() {
        return DelivaryManPhn;
    }

    public int getDelivaryManPrice() {
        return DelivaryManPrice;
    }

    @Override
    public String toString() {
        return  "DalivaryManName=" + DalivaryManName + ", DelivaryManLoactoin=" + DelivaryManLoactoin + ", \n DelivaryManPhn=" + DelivaryManPhn + ", DelivaryManPrice=" + DelivaryManPrice;
    }
    
}
