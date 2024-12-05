package Fxml.AbdullahClass;
import java.io.Serializable;
public class Supplier extends Employee implements Serializable
{
    int DuePayment;
    String SupplierName ;
   int salary  ; 
   int balance;

    public Supplier(int DuePayment, String SupplierName, int salary, int balance) {
        this.DuePayment = DuePayment;
        this.SupplierName = SupplierName;
        this.salary = salary;
        this.balance = balance;
    }

  
      public Supplier() {}

    public int getBalance() {
        return balance;
    }

    public int getDuePayment() {
        return DuePayment;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Supplier{" + "DuePayment=" + DuePayment + ", SupplierName=" + SupplierName + ", salary=" + salary + ", balance=" + balance + '}';
    }

    public void setDuePayment(int DuePayment) {
        this.DuePayment = DuePayment;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void getBalance(int balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
        
}
