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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
 import  javafx.scene.control.PasswordField;
 import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class RealloginController implements Initializable {
 @FXML
 private ImageView cc32;
  @FXML
   private Parent root;
   @FXML
        private Stage stage;
    @FXML
         private Scene scene;  
       @FXML      
    private TextField cc10; @FXML
    private PasswordField cc11;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      cc32.setVisible(true);
    }    
    @FXML
public void     confirm_login (ActionEvent event) {
     try {
         
            try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}int exp=0;
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##hr", "hr");
           String test8 = "SELECT count(*)  FROM USERTRAD WHERE nom='"+cc10.getText()+"' and password='"+cc11.getCharacters().toString()+"'";
           PreparedStatement statementtest8 = con.prepareStatement(test8);
           ResultSet resulttest8 = statementtest8.executeQuery();int i=0;
              if (resulttest8.next()) {
                  exp = resulttest8.getInt(1);
                
            }
           if(exp>0){
               
           Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText("connexion reussi");
            alert1.showAndWait(); 
            try {
              root = FXMLLoader.load(getClass().getResource("login.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
           
           
           }else{
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" nom ou mot de passe invalide!");
            alert1.showAndWait(); 
           
           }
         resulttest8.close();
         statementtest8.close();
         con.close();
     }catch (SQLException ex) {
        ex.printStackTrace();
    }         
    
    
    
    
}
    
    
}
