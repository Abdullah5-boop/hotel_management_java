/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.CleaningSupervisor;
import Fxml.AbdullahClass.SchedulePosting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SchedulePostingController implements Initializable {

    @FXML
    private TextField Mtime;
    @FXML
    private ComboBox<Integer> Memply;
    @FXML
    private TextField Ntime;
    @FXML
    private ComboBox<Integer> Nemply;
    ObservableList <Integer> sposting =FXCollections.observableArrayList();
    @FXML
    private DatePicker ScheduleDatePicker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        Memply.setItems(sposting);
        Nemply.setItems(sposting);
        // TODO
        
    }    

    @FXML
    private void Baclbtn(ActionEvent event) throws IOException {
             String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void Confimbtn(ActionEvent event) {
       LocalDate d= ScheduleDatePicker.getValue();
        
       SchedulePosting p1= new SchedulePosting();
       p1.setMid(Memply.getValue());
       p1.setNid(Nemply.getValue());
       p1.setMtime(Float.parseFloat(Mtime.getText()));
       p1.setNtime(Float.parseFloat(Ntime.getText()));
       p1.setDate(d);
       publishSchedule(p1);       
       
               
//        p1.getMtime(Float.parseFloat(Mtime.getText()));
//         p1.getMtime(Float.parseFloat(Ntime.getText()));
         
    }
    void publishSchedule(SchedulePosting p1)
    {
        File f= new File("PublishSchedule.txt");
        try {        
            FileWriter fw= new FileWriter(f);
            if(f.exists())
            {
                fw.append(p1.toString());                
            }
            else{
            fw.write(p1.toString());
            }
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(SchedulePostingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void loadData()
    {
        File f= new File("SupervisorEmployee.bin");
          CleaningSupervisor p=null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            while(true)
            {
               p= (CleaningSupervisor) ois.readObject();
               sposting.add(p.getEmployeId());
//               Arraylists.add(p);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
