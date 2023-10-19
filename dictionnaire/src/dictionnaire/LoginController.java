/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionnaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class LoginController implements Initializable {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
       @FXML
private ComboBox<String> combobox1;
       @FXML
private ComboBox<String> combobox2;
       @FXML
    private TextField mot1; @FXML
    private TextField res; @FXML
    private TextField h1;
        @FXML
    private Button traduire;@FXML
   private Parent root;
   @FXML
        private Stage stage;
    @FXML
         private Scene scene; 
    @FXML
    private TextArea textarea1;
    @FXML
    private TextArea h2;
    @FXML
    private TextArea h3;
    
private final String [] lan={"EN","FR"};
    
     public void initialize(URL url, ResourceBundle rb) {
        mot1.textProperty().addListener((observable, oldValue, newValue) -> {
             saisie_semi_auto();
        });
        
         combobox2.getItems().addAll(lan);
         combobox1.getItems().addAll(lan);
        
    }   
     
      @FXML
    private void switchbutton(ActionEvent event) {
        String aa="";
      String c1=combobox1.getSelectionModel().getSelectedItem();
      String c2=combobox2.getSelectionModel().getSelectedItem();
       combobox1.setValue(c2);
        combobox2.setValue(c1);
         mot1.setText(aa);          
        
    }
     
      @FXML
public void     saisie_semi_auto () {

  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_"+ combobox1.getValue();
        try {
                 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
        autoCompleteList.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AutoCompletionBinding<String> autoCompleteBinding;
        autoCompleteBinding = TextFields.bindAutoCompletion(mot1, autoCompleteList);



// Add a listener to handle the AutoCompletionEvent (optional)
autoCompleteBinding.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
});
    
    
    







}
@FXML
public void     golmd (ActionEvent event) {

 try {
              root = FXMLLoader.load(getClass().getResource("lmd.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();


}
@FXML
public void     goexpimp (ActionEvent event) {

 try {
              root = FXMLLoader.load(getClass().getResource("impexp.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();


}
public void     golister (ActionEvent event) {

 try {
              root = FXMLLoader.load(getClass().getResource("listermots.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();


}




     @FXML
public void     traduire (ActionEvent event) {
    
 h3.setText("");
           try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}  String selectedItem1 = combobox1.getValue();
        String selectedItem2 = combobox2.getValue();
        if (selectedItem1 != null && selectedItem2 != null && !selectedItem1.equals(selectedItem2)) {
        
        String exp = null;
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
           String test8 = "SELECT *  FROM MOT_" + combobox1.getSelectionModel().getSelectedItem() + " WHERE MOT='"+mot1.getText()+"'";
           PreparedStatement statementtest8 = con.prepareStatement(test8);
           ResultSet resulttest8 = statementtest8.executeQuery();
           
           int test11=0;
           if(resulttest8.next()){
           test11=1;
           }
           
        
        
        
           if(test11==1){
  String query0 = "SELECT EXaMPLE FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + mot1.getText() + "'";        
                        PreparedStatement command0 = con.prepareStatement(query0);

                        ResultSet reader0 = command0.executeQuery();
     while (reader0.next()) {
                 exp = reader0.getString(1);
                
            }
            
            
            String query = "SELECT * FROM MOT_" + selectedItem2 + " WHERE ID_" + selectedItem2 + " IN (SELECT ID_" + selectedItem2 + " FROM traduction WHERE ID_" + selectedItem1 + " = (SELECT ID_" + selectedItem1 + " FROM MOT_" + selectedItem1 + " WHERE  MOT = '" + mot1.getText() + "'))";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet reader = command.executeQuery();
            
            while (reader.next()) {
                
                String item = " le Type de cette mot  :'" + reader.getString(3) + "',\nTraduction:'" + reader.getString(2) + "',\nExemple:'" +reader.getString(4)  + "'\nExemple2:"+ exp + "'"; // assuming the first column is a string column
                h3.appendText("\n" + item);
               
               
                 
           }}else{
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" mot n existe pas dans la base!");
            alert1.showAndWait(); 
           }
             }
         else{
                   
                      Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" veuiller choisir 2 langue");
            alert1.showAndWait(); 
                   }
        }
        catch (SQLException ex) {
        ex.printStackTrace();
    }         
          
    

   
}
}
