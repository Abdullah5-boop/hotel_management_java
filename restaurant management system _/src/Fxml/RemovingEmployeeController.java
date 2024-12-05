package Fxml;
import Fxml.AbdullahClass.CleaningSupervisor;
import Fxml.AbdullahClass.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class RemovingEmployeeController implements Initializable {

    @FXML
    private TableColumn<CleaningSupervisor, String > Nametxt;
    @FXML
    private TableColumn<CleaningSupervisor, Integer> IDtxt;
    @FXML
    private TableColumn<CleaningSupervisor,Integer> Agetxt;
    @FXML
    private Label Output;
    @FXML
    private Label notification;
    @FXML
    private TableView<CleaningSupervisor> HandleRemoveingTable;
    ObservableList<CleaningSupervisor> elist = FXCollections.observableArrayList();
    ArrayList <CleaningSupervisor> OldData = null;
    ArrayList <CleaningSupervisor> NewData = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OldData= new ArrayList<CleaningSupervisor>();
        NewData= new ArrayList<CleaningSupervisor>();
        LoadeList();
       Nametxt.setCellValueFactory(new PropertyValueFactory<CleaningSupervisor, String>("EmployeName"));
      // IDtxt.setCellValueFactory(new PropertyValueFactory<CleaningSupervisor, Integer>(" EmployeId"));
       Agetxt.setCellValueFactory(new PropertyValueFactory<CleaningSupervisor, Integer>("Employeeage"));
        IDtxt.setCellValueFactory(new PropertyValueFactory<CleaningSupervisor, Integer>("EmployeId"));
       HandleRemoveingTable.setItems(elist);   
        
    }    

    @FXML
    private void TableViewOnclick(MouseEvent event) {
        CleaningSupervisor p1 =HandleRemoveingTable.getSelectionModel().getSelectedItem();
        
//        Stage stage = (Stage)scenePane.getScene.getWindrow();
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Removing ... ");
      alert.setContentText("Are You sure you want to remove "+p1.getEmployeName()+" ? ");
//      alert.showAndWait();
      Optional<ButtonType> result = alert.showAndWait();
      if(result.isPresent()&& result.get()==ButtonType.OK)
      {
          Output.setText(p1.toString());
          Deletebtn(p1.getEmployeId());
                    
      }
      
      
      


        
        
    }

    private void Deletebtn(int id){
        for(CleaningSupervisor a: OldData)
        {
            if(!(a.getEmployeId()==id))
            {
               NewData.add(a);
            }
        }
        WriteUpdateData();
        
    }

    @FXML
    private void Backbtn(ActionEvent event) throws IOException {
             String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    }
    
    
    CleaningSupervisor LoadeList()
    {
        elist.clear();
        String path="SupervisorEmployee.bin";
        CleaningSupervisor p1=null;
        File f= new File(path);   
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        
        
        try {
             fis= new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            while(true)
            {
                p1= (CleaningSupervisor) ois.readObject();
                elist.add(p1);
                OldData.add(p1);
                System.out.print(p1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RemovingEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RemovingEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RemovingEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(RemovingEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p1;
    }
    
    
    void WriteUpdateData()
    {
        String path= "SupervisorEmployee.bin";
        System.out.print(path);
        
            FileOutputStream fis=null;
            ObjectOutputStream ois= null;
        
        try {
            File f= new File(path);
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);
           
           }    
          
            for( CleaningSupervisor e:NewData)
            {ois.writeObject(e);}
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
        LoadeList();
        notification.setText("Remove from the list .");
        Output.setText("");
        }
    }
        
                
    
}
