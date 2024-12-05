
package Fxml;
import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.ProductClass;
import Fxml.AbdullahClass.Supplier;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SupplierDashbordController extends Supplier implements Initializable {

    @FXML
    private Label SuplliernameTxt;
    @FXML
    private Label SupllieageTxt;
    @FXML
    private Label SupllieSalaryeTxt;
    @FXML
    private Label SupllieduepaymentTxt1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDataSuppler();
    }    

 @FXML
    private void HandleSeeOrder(ActionEvent event) throws IOException {
        String path="ShowOrder.fxml";
       Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
    
    }
    @FXML
    private void HandleSeeAvailability(ActionEvent event) throws IOException {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("SeeAvailablity.fxml"));
         Parent root=loader.load();
         Stage stage= new Stage();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void HandleCostOfZEquimplent(ActionEvent event) throws IOException {
        String path="CostOf Product.fxml";
       Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HandleDelivaryMan(ActionEvent event) throws IOException {
        if(!validation())
        {
            System.out.println("Done from dash bord");
            String path="Dalivary1.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
        
        }
        else
        {
        System.out.println("Done from dash bord not working ");
            String path="Dalivary2.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
        }
    }

    @FXML
    private void HandleDuePayment(ActionEvent event) throws IOException {
        String path = "DuePayment.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HandleWithdrowMoney(ActionEvent event) throws IOException {
           String path = "Withmoney.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Withdrow Money");
        window.setScene(scene);
        window.show();    
        
    }

    @FXML
    private void HandleSendReportToTheMD(ActionEvent event) throws IOException {
            String path = "SendToMd.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Send to the MD...");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HandlePostOrder(ActionEvent event) throws IOException {
        String path="AddProduct.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
        
    }
    
    boolean validation()
    {
        File f= new File("Storenotification.bin");
        try {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            boolean x= dis.readBoolean();
            return x;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SupplierDashbordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SupplierDashbordController.class.getName()).log(Level.SEVERE, null, ex);
        }        
      return false;
    }

    @FXML
    private void Handleadddelivaryman(ActionEvent event) throws IOException {
           String path="AddDelivaryMan.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void HandleupdateEmploye(ActionEvent event) throws IOException {
               String path="Addsupplier.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Add product");
        window.setScene(scene);
        window.show();
        
    }
    
    
    
 void loadDataSuppler()
            {
    {
        File f= new File("Supplierinfo.bin");
    
         FileInputStream fis= null;
         ObjectInputStream ois= null;
         Supplier p=null;
         Object obj;
         if(f.exists())
         {
           try {
               fis= new FileInputStream(f);
               ois= new ObjectInputStream(fis);
       
               
               p= (Supplier)ois.readObject();
               SuplliernameTxt.setText(p.getSupplierName());
               SupllieageTxt.setText(Integer.toString(p.getBalance()));
               SupllieSalaryeTxt.setText(Integer.toString(p.getSalary()));
               SupllieduepaymentTxt1.setText(Integer.toString(p.getDuePayment()));
               
               
           } catch (FileNotFoundException ex) {
               
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
                
               // System.out.print("done");
                
               if(ois==null)
               {
                   try {
                       ois.close();
                   } catch (IOException ex) {
                       Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
           
         }
         else{
             
         }
         
    }
    }
    
    
}
