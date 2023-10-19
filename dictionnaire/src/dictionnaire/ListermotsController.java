/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionnaire;

import java.io.File;
import java.io.FileWriter;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class ListermotsController implements Initializable {
    private final String [] lan={"EN","FR"};
 @FXML
    private TextArea a13;@FXML
    private TextArea last;
    @FXML
    private ComboBox<String> a3;
    @FXML
    private ComboBox<String> a7;
   @FXML
     private Label a2;@FXML
    private Label a4;@FXML
    private Label a6;@FXML
    private Label a8;@FXML
    private Label a10;@FXML
    private Label a12;
    @FXML
    private TextField a5;@FXML
    private TextField a9;@FXML
    private TextField a11;
    @FXML
    private Button a1; 
    @FXML
    private Button a14;
    @FXML
    private Button a15;
    @FXML
   private Parent root;
   @FXML
        private Stage stage;
    @FXML
         private Scene scene; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        last.setVisible(false);
      a15.setVisible(false);a3.getItems().addAll(lan);
        a5.textProperty().addListener((observable, oldValue, newValue) -> {
             saisie_semi_auto();
             
        });
    } 
    public void     mainn (ActionEvent event) {

 try {
              root = FXMLLoader.load(getClass().getResource("login.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.show();


}
    
    
     @FXML
    public void     afficher2 (ActionEvent event) {
   
a1.setVisible(false);
last.setVisible(true);

a4.setVisible(false);
a5.setVisible(false);
a6.setVisible(false);
a7.setVisible(false);
a8.setVisible(false);
a9.setVisible(false);
a10.setVisible(false);
a11.setVisible(false);
a12.setVisible(false);
a13.setVisible(false);
a14.setVisible(false);      
a15.setVisible(true);
}    @FXML
      public void     afficher (ActionEvent event) {
   
a1.setVisible(true);
last.setVisible(false);
a4.setVisible(true);
a5.setVisible(true);
a6.setVisible(true);
a7.setVisible(true);
a8.setVisible(true);
a9.setVisible(true);
a10.setVisible(true);
a11.setVisible(true);
a12.setVisible(true);
a13.setVisible(true);
a14.setVisible(true);      
a15.setVisible(false);
}
      @FXML
public void     saisie_semi_auto () {

  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_"+ a3.getValue();
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
        autoCompleteBinding = TextFields.bindAutoCompletion(a5, autoCompleteList);



// Add a listener to handle the AutoCompletionEvent (optional)
autoCompleteBinding.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
}); 

}
       @FXML
      public void    tous_les_mots (ActionEvent event) {
      String path="";
      FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      path=selectedFile.getAbsolutePath();
    }
      try{ 
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        String first = a3.getValue();
        String second="";
        if(first.equals("FR"))
            second = "EN";
        else 
            second = "FR";
         String query111 = "SELECT * FROM MOT_" + first ;        
             PreparedStatement command111 = con.prepareStatement(query111);
             ResultSet reader111 = command111.executeQuery();
            String exp="";
            while(reader111.next()){
              String waa=  reader111.getString(2);
          
            String query11 = "SELECT EXAMPLE FROM MOT_" + first + " WHERE  MOT = '" +waa + "'";        
             PreparedStatement command11 = con.prepareStatement(query11);
             ResultSet reader11 = command11.executeQuery();
          while (reader11.next()) {
                 exp = reader11.getString(1); 
            }
           String query22 = "SELECT * FROM MOT_" + second + " WHERE ID_" + second + " IN (SELECT ID_" + second + " FROM traduction WHERE ID_" + first + " = (SELECT ID_" + first + " FROM MOT_" + first + " WHERE  MOT = '" + waa + "'))";
           PreparedStatement command22 = con.prepareStatement(query22);
           ResultSet reader22 = command22.executeQuery();
              try{
                    FileWriter f=new FileWriter(path,true);
                    String ah="le Mot selecter :"+waa+"\n";
                    f.write(ah);
                    int j=1;
                    String area="";
            while (reader22.next()) {
                area=area+"le Mot selecter :"+waa+"\n"+" -  traduction "+j+" Type :'" + reader22.getString(3) +"',Traduction("+second+"):'" + reader22.getString(2)+ "',Exemple:'" +reader22.getString(4)  + "',Exemple2:'"+ exp + "'.\n";
                
                //" Type :'" + reader22.getString(3) +
                //+ "',Exemple:'" +reader22.getString(4)  + "',Exemple2:'"+ exp
                String aha= "traduction "+j+" Type :'" + reader22.getString(3) +"',Traduction("+second+"):'" + reader22.getString(2)+ "',Exemple:'" +reader22.getString(4)  + "',Exemple2:'"+ exp + "'.\n";
                f.write(aha);j++;
                }f.close();
                 // assuming the first column is a string column
                  last.appendText("\n" + area);
                }catch(IOException e){ System.out.print(e.getCause());}
         
      }
      }catch (SQLException e) {
        e.printStackTrace();
    } 
          
          
          
          
          
          
      }
       @FXML
      public void    listermot (ActionEvent event) {
      String path="";
      FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      path=selectedFile.getAbsolutePath();
    }
      try{ 
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        String first = a3.getValue();
        String second="";
        if(first.equals("FR"))
            second = "EN";
        else 
            second = "FR";
            String exp="";
           if (first != null && second != null && !first.equals(second)) {
            String query11 = "SELECT EXAMPLE FROM MOT_" + first + " WHERE  MOT = '" + a5.getText() + "'";        
             PreparedStatement command11 = con.prepareStatement(query11);
             ResultSet reader11 = command11.executeQuery();
          while (reader11.next()) {
                 exp = reader11.getString(1); 
            }
           String query22 = "SELECT * FROM MOT_" + second + " WHERE ID_" + second + " IN (SELECT ID_" + second + " FROM traduction WHERE ID_" + first + " = (SELECT ID_" + first + " FROM MOT_" + first + " WHERE  MOT = '" + a5.getText() + "'))";
           PreparedStatement command22 = con.prepareStatement(query22);
           ResultSet reader22 = command22.executeQuery();
              try{
                    FileWriter f=new FileWriter(path);
                    String ah="le Mot selecter :"+a5.getText()+"\n";
                    f.write(ah);
            while (reader22.next()) {
                //" Type :'" + reader22.getString(3) +
                //+ "',Exemple:'" +reader22.getString(4)  + "',Exemple2:'"+ exp
                String aha= " Type :'" + reader22.getString(3) +"',Traduction("+second+"):'" + reader22.getString(2)+ "',Exemple:'" +reader22.getString(4)  + "',Exemple2:'"+ exp + "'.\n";
                f.write(aha);
                }f.close();
                 // assuming the first column is a string column
                
                }catch(IOException e){ System.out.print(e.getCause());}
         
      }
      }catch (SQLException e) {
        e.printStackTrace();
    }  }
      
       @FXML
     public void motafficher(ActionEvent event ) {
     String first = a3.getValue();
        String second="";
        if(first.equals("FR"))
            second = "EN";
        else 
            second = "FR";
        String exp="";
          
     String mot=a5.getText();
     if(mot.matches("[a-zA-Z]+") ){
     try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
                 String test = "SELECT count(*)  FROM MOT_" + a3.getSelectionModel().getSelectedItem() + " WHERE MOT='"+a5.getText()+"'";
           PreparedStatement statementtest = con.prepareStatement(test);
           ResultSet resulttest = statementtest.executeQuery();
           
           int test1=0;
           if(resulttest.next()){
           test1=1;
           }
           if(test1!=0){
                 String afficher = "SELECT *  FROM MOT_" + a3.getSelectionModel().getSelectedItem() + " WHERE MOT='"+a5.getText()+"'";
           PreparedStatement statementtest2 = con.prepareStatement(afficher);
           ResultSet resulttest2 = statementtest2.executeQuery();
           int i=1;
           while (resulttest2.next()) {
                 
             
                 a7.setValue(resulttest2.getString(3));
                 a9.setText(resulttest2.getString(4));
                 a11.setText(resulttest2.getString(5));
                 
                 
                
            }    
           String query = "SELECT * FROM MOT_" + second + " WHERE ID_" + second + " IN (SELECT ID_" + second + " FROM traduction WHERE ID_" + first + " = (SELECT ID_" + first + " FROM MOT_" + first + " WHERE  MOT = '" + a5.getText() + "'))";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet reader = command.executeQuery();
             while (reader.next()) {
             String item="traduction"+i+" : "+ reader.getString(2);
             a13.appendText("\n" + item);i++;
             }
           }else{
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" mot n existe pas dans la base!");
            alert1.showAndWait(); 
           }
 
     }catch (SQLException ex) {
        ex.printStackTrace();
    }     

     }else{

     Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" mot invalide!");
            alert1.showAndWait(); 
     }
     }
      
      }
