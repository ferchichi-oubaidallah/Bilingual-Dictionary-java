/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dictionnaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class ImpexpController implements Initializable {
    
    @FXML
    private TextArea last;
 @FXML
private ComboBox<String> c1;
 @FXML
   private Parent root;
   @FXML
        private Stage stage;
    @FXML
         private Scene scene; 
     @FXML
    private ComboBox<String> c2;
     @FXML

       private final String [] lan={"EN","FR"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.getItems().addAll(lan);
        c2.getItems().addAll(lan);
    }    
    
    
     @FXML
public void importing (ActionEvent event) {
String chemin="";
trad[] tab=null;


String selectedItem1 = c1.getValue();
        String selectedItem2 = c2.getValue();
        if (selectedItem1 != null && selectedItem2 != null && !selectedItem1.equals(selectedItem2)) {
// getting data from file
    try {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      chemin=selectedFile.getAbsolutePath();
    }
   try (ObjectInputStream fs = new ObjectInputStream(new FileInputStream(chemin))) {
                 tab = (trad [])fs.readObject();
             }
    } catch(Exception e){
System.out.print(e.getCause());
    }
// inserting data into data base
if(tab!=null){
try{
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##hr", "hr");
        for(int i=0;i<tab.length;i++){
              String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;int maxID ;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        }   result.close();
        String querycheck = "SELECT count(*)  FROM MOT_" + c1.getSelectionModel().getSelectedItem() + " WHERE MOT='"+tab[i].getMot_L1()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
           if (resultcheck.next()) {
           check = resultcheck.getInt(1);
              }
           resultcheck.close();
           statementcheck.close();
           String querycheck1 = "SELECT count(*)  FROM MOT_" + c2.getSelectionModel().getSelectedItem() + " WHERE MOT='"+tab[i].getMot_L1()+"'";
           PreparedStatement statementcheck1 = con.prepareStatement(querycheck1);
           ResultSet resultcheck1 = statementcheck1.executeQuery();
           int check1 = 0;
          if (resultcheck1.next()) {
          check1 = resultcheck1.getInt(1);
              }
          resultcheck1.close();
          statementcheck1.close();

    String queryL2 = "INSERT INTO MOT_" + c1.getSelectionModel().getSelectedItem() + " (ID_" + c1.getSelectionModel().getSelectedItem() + ", Mot,type,EXEMPLE,EXEMPLE2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL2 = con.prepareStatement(queryL2);
    stmtL2.setInt(1, newID);
    stmtL2.setString(2, tab[i].getMot_L2());
    stmtL2.setString(3, tab[i].getType());
    stmtL2.setString(4, tab[i].getExpl1());
    stmtL2.setString(5, tab[i].getExpl2());
    stmtL2.execute();
    stmtL2.close();
    
         
    String queryL3 = "INSERT INTO MOT_" + c2.getSelectionModel().getSelectedItem() + " (ID_" + c2.getSelectionModel().getSelectedItem() + ", Mot,type,EXEMPLE,EXEMPLE2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, tab[i].getMot_L1());
    stmtL3.setString(3, tab[i].getType());
    stmtL3.setString(4, tab[i].getExpl2());
    stmtL3.setString(5, tab[i].getExpl1());
    stmtL3.execute();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + c1.getSelectionModel().getSelectedItem() + ",ID_" + c2.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, newID); 
    stmtL.setInt(2, newID);
  
    stmtL.execute();
    stmtL.close();
    
       
   
       
        }
        con.close();      
}catch(SQLException ex) {
        ex.printStackTrace();}

}else{
Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
          alert2 .setTitle("Warning");
            alert2 .setHeaderText(" pas de mot dans ce fichier!");
            alert2 .showAndWait();


}
        }else{
        
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" veuiller choisir 2 langue");
            alert1.showAndWait(); 
        
        }
    
}
         
  @FXML
public void export (ActionEvent event) {
String affichage="";  String path="";    
    int i=0,z=0;
    trad [] tab=null;
    String mot2="";
    String selectedItem1 = c1.getValue();
        String selectedItem2 = c2.getValue();
        if (selectedItem1 != null && selectedItem2 != null && !selectedItem1.equals(selectedItem2)) {
     try {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
      path=selectedFile.getAbsolutePath();
    }
   
    } catch(Exception e){
System.out.print(e.getCause());
    }
    
    
 try {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");       
        String query = "SELECT * FROM MOT_"+ c1.getValue();
        PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            
            
            String query2 = "Select count(*) from MOT_"+ c1.getValue();
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            ResultSet rs2 = stmt2.executeQuery();
             if (rs2.next()) {
        // Get the value of the "MOT" column from the current row
         i = rs2.getInt(1);
                     }
         tab=new trad[i];
    while(res.next()){
        trad nvtrad=new trad();
        String que = "SELECT MOT FROM MOT_" + c2.getValue() + " WHERE ID_" + c2.getValue() + " IN (SELECT ID_" + c2.getValue() + " FROM traduction WHERE ID_" 
        + c1.getValue() + " in (SELECT ID_" + c1.getValue() + " FROM MOT_" + c1.getValue() + " WHERE  MOT = '" + res.getString(2) + "'))"; 
        PreparedStatement stm = conn.prepareStatement(que);
        ResultSet queres = stm.executeQuery();
            
        if(queres.next())
        {mot2=queres.getString("MOT");;}
        nvtrad.setMot_L2(mot2);
                nvtrad.setExpl1(res.getString(4));
                nvtrad.setExpl2(res.getString(5));
                nvtrad.setMot_L1(res.getString(2));
                nvtrad.setType(res.getString(3));
        affichage=affichage+"le mot est : "+res.getString(2)+"  le traduction est : "+mot2+"  le type est : "+res.getString(3)+" exemple1 : "+res.getString(4)+" exemple2 : "+res.getString(5)+"\n";
         tab[z]=nvtrad;
                z++;
  
    }     last.appendText("\n" + affichage);    res.close();
            stmt.close();
            conn.close();
 }catch (SQLException e) {
            e.printStackTrace();
        }
 try{
 
 ObjectOutputStream file=new ObjectOutputStream(new FileOutputStream(path));
        file.writeObject(tab);
        file.close();
 
  Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" tous les mot et  bien exportee!");
            alert1.showAndWait(); 
        
        
 }catch(Exception e){
        
        System.out.print(e.getCause());
    }
        
         Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" veuiller choisir 2 langue");
            alert1.showAndWait(); 
        
        }        




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
         private void listagemot(ActionEvent event) {

             
             
         }
    }  
    
  

