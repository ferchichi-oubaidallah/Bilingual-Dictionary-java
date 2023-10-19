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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Ahla baba ija mamma
 */
public class LmdController implements Initializable {
 @FXML
    private Pane container;
 @FXML
    private Pane contr1;
 @FXML
    private Pane contajout;
 
  @FXML
    private TextArea aa2;
 @FXML
    private Label l1;
         @FXML
    private TextField l4;@FXML
    private TextField q2;
    @FXML
    private TextField l5;
     @FXML
    private TextArea l8;
     @FXML
    private TextArea l9;
     @FXML
    private TextArea l10;
     @FXML
    private TextArea l11;
     @FXML
    private Button l12;@FXML
    private Button chercher;
      @FXML
    private ComboBox<String> s5;
    @FXML
    private ComboBox<String> l2;
    @FXML
    private ComboBox<String> l3;
    @FXML
    private ComboBox<String> l6;
    @FXML
    private ComboBox<String> l7;
    @FXML
    private Label q1;
    @FXML
    
    private Label a1;
    @FXML
    private Label a2;@FXML
    private Label a3;@FXML
    private Label a4;@FXML
    private Label a5;
    @FXML
    private Label s1;@FXML
    private TextField s2;; @FXML
    private Button s3;
    
    @FXML
     private Label m1;@FXML
    private Label m2;@FXML
    private Label m3;@FXML
    private Label m4;@FXML
    private Label m5;@FXML
    private Label m6;
    @FXML
    private ComboBox<String> m7;@FXML
    private ComboBox<String> m9;
     @FXML
    private TextField m8;
      @FXML
    private TextArea m10; @FXML
    private TextArea m11;
     @FXML
    private Button m12; @FXML
    private Button exi;
    @FXML
    private Button hsup;
     private final String [] lan={"EN","FR"};
        private final String [] type={"Nom","Verbe"};
    @FXML
   private Parent root;
   @FXML
        private Stage stage;
    @FXML
         private Scene scene; 
    /**
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         q2.textProperty().addListener((observable, oldValue, newValue) -> {
             saisie_semi_auto();
        });
          s2.textProperty().addListener((observable, oldValue, newValue) -> {
             saisie_semi_auto_supp();
        });
m1.setVisible(false);m2.setVisible(false);m3.setVisible(false);m4.setVisible(false);m5.setVisible(false);m6.setVisible(false);m7.setVisible(false);m8.setVisible(false);m9.setVisible(false);m10.setVisible(false);m11.setVisible(false);m12.setVisible(false);        // TODOl2.setVisible(false);
l3.setVisible(false);l1.setVisible(false);q1.setVisible(false);q2.setVisible(false);
l2.setVisible(false);
l4.setVisible(false);chercher.setVisible(false);
l5.setVisible(false);hsup.setVisible(false);
l6.setVisible(false);
l7.setVisible(false);exi.setVisible(false);
l8.setVisible(false);aa2.setVisible(false);
l9.setVisible(false);
l10.setVisible(false);
l11.setVisible(false);
l12.setVisible(false);
a1.setVisible(false);a2.setVisible(false);a3.setVisible(false);a4.setVisible(false);a5.setVisible(false);
  s5.setVisible(false);
    s1.setVisible(false);s2.setVisible(false);s3.setVisible(false);
    s5.getItems().addAll(lan); m7.getItems().addAll(lan);l2.getItems().addAll(lan);l3.getItems().addAll(lan);
         l6.getItems().addAll(type);    l7.getItems().addAll(type);  m9.getItems().addAll(type);     

    }    
  @FXML
public void     miseajour (ActionEvent event) {
    m1.setVisible(true);m2.setVisible(true);m3.setVisible(true);m4.setVisible(true);m5.setVisible(true);m6.setVisible(true);m7.setVisible(true);m8.setVisible(true);m9.setVisible(true);m10.setVisible(true);m11.setVisible(true);m12.setVisible(true);
    l1.setVisible(false);  aa2.setVisible(false);
l2.setVisible(false);q1.setVisible(true);q2.setVisible(true);
l3.setVisible(false);hsup.setVisible(false);
l4.setVisible(false);
l5.setVisible(false);chercher.setVisible(true);
l6.setVisible(false);
l7.setVisible(false);exi.setVisible(false);
l8.setVisible(false);
l9.setVisible(false);
l10.setVisible(false);
l11.setVisible(false);
l12.setVisible(false);
a1.setVisible(false);a2.setVisible(false);a3.setVisible(false);a4.setVisible(false);a5.setVisible(false);
  s5.setVisible(false);
    s1.setVisible(false);s2.setVisible(false);s3.setVisible(false);

               
}

  @FXML
public void     saisie_semi_auto () {

  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_"+ m7.getValue();
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
        autoCompleteBinding = TextFields.bindAutoCompletion(q2, autoCompleteList);



// Add a listener to handle the AutoCompletionEvent (optional)
autoCompleteBinding.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
}); 

}




@FXML
public void     saisie_semi_auto_supp () {

  ObservableList<String> autoCompleteList = FXCollections.observableArrayList();

        // Retrieve data from the database
        String query = "SELECT MOT FROM MOT_"+ s5.getValue();
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
        autoCompleteBinding = TextFields.bindAutoCompletion(s2, autoCompleteList);



// Add a listener to handle the AutoCompletionEvent (optional)
autoCompleteBinding.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
        // Handle the AutoCompletionEvent
    }
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
    public void     supprimer (ActionEvent event) {
        m1.setVisible(false);m2.setVisible(false);m3.setVisible(false);m4.setVisible(false);m5.setVisible(false);m6.setVisible(false);m7.setVisible(false);m8.setVisible(false);m9.setVisible(false);m10.setVisible(false);m11.setVisible(false);m12.setVisible(false);
        s1.setVisible(true);s2.setVisible(true);s3.setVisible(true);
        s5.setVisible(true);
      l1.setVisible(false);hsup.setVisible(true);
l2.setVisible(false);
l3.setVisible(false);q1.setVisible(false);q2.setVisible(false);
l4.setVisible(false);
l5.setVisible(false);
l6.setVisible(false);chercher.setVisible(false);
l7.setVisible(false);aa2.setVisible(true);
l8.setVisible(false);
l9.setVisible(false);
l10.setVisible(false);exi.setVisible(false);
l11.setVisible(false);
l12.setVisible(false);
a1.setVisible(false);a2.setVisible(false);a3.setVisible(false);a4.setVisible(false);a5.setVisible(false);

}     @FXML
    public void     ajout (ActionEvent event) {
                  m1.setVisible(false);m2.setVisible(false);m3.setVisible(false);m4.setVisible(false);m5.setVisible(false);m6.setVisible(false);m7.setVisible(false);m8.setVisible(false);m9.setVisible(false);m10.setVisible(false);m11.setVisible(false);m12.setVisible(false);    
l1.setVisible(true);
l2.setVisible(true);aa2.setVisible(false);
l3.setVisible(true);
l4.setVisible(true);chercher.setVisible(false);
l5.setVisible(true);hsup.setVisible(false);
l6.setVisible(true);
l7.setVisible(true);q1.setVisible(false);q2.setVisible(false);
l8.setVisible(true);
l9.setVisible(true);
l10.setVisible(true);exi.setVisible(false);
l11.setVisible(true);
l12.setVisible(true);
a1.setVisible(true);a2.setVisible(true);a3.setVisible(true);a4.setVisible(true);a5.setVisible(true);
  s1.setVisible(false);s2.setVisible(false);s3.setVisible(false);
  s5.setVisible(false);
}
     @FXML
    public void     ajoutmotexistant (ActionEvent event) {
                  m1.setVisible(false);m2.setVisible(false);m3.setVisible(false);m4.setVisible(false);m5.setVisible(false);m6.setVisible(false);m7.setVisible(false);m8.setVisible(false);m9.setVisible(false);m10.setVisible(false);m11.setVisible(false);m12.setVisible(false);    
l1.setVisible(true);
l2.setVisible(true);
l3.setVisible(true);
l4.setVisible(true);chercher.setVisible(false);
l5.setVisible(true);
l6.setVisible(true);
l7.setVisible(true);q1.setVisible(false);q2.setVisible(false);
l8.setVisible(true);
l9.setVisible(true);
l10.setVisible(true);
l11.setVisible(true);
l12.setVisible(false);exi.setVisible(true);
a1.setVisible(true);a2.setVisible(true);a3.setVisible(true);a4.setVisible(true);a5.setVisible(true);
  s1.setVisible(false);s2.setVisible(false);s3.setVisible(false);
  s5.setVisible(false);
}
      @FXML
       public void tradexi(ActionEvent event ){
       int maxID;
       if(l4.getText().matches("[a-zA-Z]+") &&  (l2.getSelectionModel().getSelectedItem() !=l3.getSelectionModel().getSelectedItem() )  ){

        try {
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        con.setAutoCommit(true);
        String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        }
        result.close();
        statement.close();
        
        String query1 = "SELECT ID_" + l2.getSelectionModel().getSelectedItem() + " AS ID FROM MOT_"+ l2.getSelectionModel().getSelectedItem()+ " WHERE MOT='"+ l4.getText() + "'";
        PreparedStatement statement1 = con.prepareStatement(query1);
        ResultSet result1 = statement1.executeQuery();
            int actualID = 0;
        if (result1.next()) {
            actualID = result1.getInt("ID");
            
        }
        result1.close();
        statement1.close();
        
        
         String querycheck = "SELECT count(*)  FROM MOT_" + l3.getSelectionModel().getSelectedItem() + " WHERE MOT='"+l5.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
     if(check==0){
         
     
         
    String queryL3 = "INSERT INTO MOT_" + l3.getSelectionModel().getSelectedItem() + " (ID_" + l3.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, l5.getText());
    stmtL3.setString(3, l7.getSelectionModel().getSelectedItem());
    stmtL3.setString(4, l9.getText());
    stmtL3.setString(5, l11.getText());
    stmtL3.executeUpdate();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + l2.getSelectionModel().getSelectedItem() + ",ID_" + l3.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, actualID); 
    stmtL.setInt(2, newID);
  
    stmtL.executeUpdate();
    stmtL.close();
    
    
    con.close();

        
        
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
          alert1.setTitle("CONFIRMATION");
            alert1.setHeaderText(" Ajout avec sccees!");
            alert1.showAndWait();
        
      }else {  Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
          alert2 .setTitle("Warning");
            alert2 .setHeaderText(" Mot Existant!");
            alert2 .showAndWait();
     }  
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
   
        
         }else {
          
           Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
          alert2 .setTitle("Warning");
            alert2 .setHeaderText(" choisir different langue ou une mot invalide!");
            alert2 .showAndWait();
         
         
         
     }
     
     
     
     
       
       
       }
    
    @FXML
       public void ajouterTraduction(ActionEvent event ) {int maxID ;
       
       String text1 = l4.getText();
          String text2 = l5.getText();
       
          if (text1.matches("[a-zA-Z]+") && text2.matches("[a-zA-Z]+") ) {
        try {
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        con.setAutoCommit(true);
        String query = "SELECT MAX(ID_FR) AS MaxID FROM (SELECT ID_FR FROM MOT_FR UNION SELECT ID_EN FROM MOT_EN)";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
            int newID = 0;
        if (result.next()) {
            maxID = result.getInt("MaxID");
            newID = maxID + 1;
        }
        result.close();
        statement.close();
        Boolean test1=true;
        Boolean test2=true;
       
        String querycheck = "SELECT count(*)  FROM MOT_" + l2.getSelectionModel().getSelectedItem() + " WHERE MOT='"+l4.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
        if(check==0){
    String queryL2 = "INSERT INTO MOT_" + l2.getSelectionModel().getSelectedItem() + " (ID_" + l2.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL2 = con.prepareStatement(queryL2);
    stmtL2.setInt(1, newID);
    stmtL2.setString(2, l4.getText());
    stmtL2.setString(3, l6.getSelectionModel().getSelectedItem());
    stmtL2.setString(4, l8.getText());
    stmtL2.setString(5, l10.getText());
    stmtL2.executeUpdate();
    stmtL2.close();
    
         
    String queryL3 = "INSERT INTO MOT_" + l3.getSelectionModel().getSelectedItem() + " (ID_" + l3.getSelectionModel().getSelectedItem() + ", Mot,type,example,example2) VALUES (?,?,?,?,?)";
    PreparedStatement stmtL3 = con.prepareStatement(queryL3);
    stmtL3.setInt(1, newID);
    stmtL3.setString(2, l5.getText());
    stmtL3.setString(3, l7.getSelectionModel().getSelectedItem());
    stmtL3.setString(4, l9.getText());
    stmtL3.setString(5, l11.getText());
    stmtL3.executeUpdate();
    stmtL3.close();
    
         
    String queryL = "INSERT INTO TRADUCTION  (ID_" + l2.getSelectionModel().getSelectedItem() + ",ID_" + l3.getSelectionModel().getSelectedItem() + ") VALUES (?,?)";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.setInt(1, newID); 
    stmtL.setInt(2, newID);
  
    stmtL.executeUpdate();
    stmtL.close();
    
    
    con.close();
Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" Ajout avec succees!");
            alert1.showAndWait();
        
        }else{
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" mot deja existant!");
            alert1.showAndWait();
        
        
        
        }
        
        
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
          }else{
          
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION:");
            alert.setHeaderText(" veuiller saisir un mot correcte!");
            alert.showAndWait();
          
          
          }
        
        
     
     
     
     
     
     }
         @FXML
    public void supprimertraduction(ActionEvent event ) {
    
     String text1 = s2.getText();
    if (text1.matches("[a-zA-Z]+")  ) {
     try {
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        con.setAutoCommit(true);
    String querycheck = "SELECT count(*)  FROM MOT_" + s5.getSelectionModel().getSelectedItem() + " WHERE MOT='"+s2.getText()+"'";
           PreparedStatement statementcheck = con.prepareStatement(querycheck);
           ResultSet resultcheck = statementcheck.executeQuery();
           int check = 0;
          if (resultcheck.next()) {
     check = resultcheck.getInt(1);
              }
          resultcheck.close();
          statementcheck.close();
          
        if(check!=0){
            String ch=s5.getSelectionModel().getSelectedItem();
             String ch1;
            if(ch.equals("EN")){ch1="FR";}else{ch1="EN";}
            String ff="id_"+s5.getSelectionModel().getSelectedItem();
            
            String queryL3 = "select * from mot_"+s5.getSelectionModel().getSelectedItem()+ " where mot='"+s2.getText()+"'";
            PreparedStatement statementcheck3 = con.prepareStatement(queryL3);
            ResultSet resultcheck3 = statementcheck3.executeQuery();
            resultcheck3.next();
            
            String queryL2 = "delete from traduction where ID_"+ s5.getSelectionModel().getSelectedItem()+"='"+resultcheck3.getInt(1)+"'";
            PreparedStatement stmtL2 = con.prepareStatement(queryL2);
            stmtL2.execute();
             
            
   
            
                  
     String queryL6 = "delete from mot_"+ ch1 + " where ID_"+ch1+"='"+resultcheck3.getInt(1)+"'";
    PreparedStatement stmtL6 = con.prepareStatement(queryL6);
    stmtL6.execute();
             statementcheck3.close();
         resultcheck3.close();
            
     String queryL = "delete from mot_"+ s5.getSelectionModel().getSelectedItem() + " where mot='"+s2.getText()+"'";
    PreparedStatement stmtL = con.prepareStatement(queryL);
    stmtL.execute();
    
    
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION:");
            alert.setHeaderText(" mot supprimer!");
            alert.showAndWait();
     }else{
        
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION:");
            alert.setHeaderText(" mot n existe pas!");
            alert.showAndWait();
        
        }}catch (SQLException ex) {
        ex.printStackTrace();
    }
         
    
    }else{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION:");
            alert.setHeaderText(" veuiller saisir un mot correcte!");
            alert.showAndWait();
          
        
    }}
      @FXML
     public void updatetrad(ActionEvent event ) {
     
      String text = m8.getText();

     if(text.matches("[a-zA-Z]+")){
         
          try {
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
        con.setAutoCommit(true);
        String query = "UPDATE  MOT_"+m7.getSelectionModel().getSelectedItem()+" set MOT='"+ m8.getText()+"',TYPE='"+m9.getSelectionModel().getSelectedItem()+"',EXEMPLE='"+m10.getText()+"',EXEMPLE2='"+m11.getText()+"' Where MOT='"+q2.getText()+"'";                                                                                                         
        PreparedStatement statement = con.prepareStatement(query);
        int  result = statement.executeUpdate();
        if (result>0)
          {
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION:");
            alert1.setHeaderText(" mise a jou avec succes!");
            alert1.showAndWait(); 
              
          }
          }
          
          
         catch (SQLException ex) {
        ex.printStackTrace();
    }
         
         
         
         
     }else {
                  Alert alert = new Alert(Alert.AlertType.WARNING);

         alert.setTitle("Warning");
            alert.setHeaderText(" Mot invalide!");
            alert.showAndWait();
         
     }
     
     
     }
     @FXML
     public void motafficher(ActionEvent event ) {
     
     String mot=q2.getText();
     if(mot.matches("[a-zA-Z]+") ){
     try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
                 String test = "SELECT count(*)  FROM MOT_" + m7.getSelectionModel().getSelectedItem() + " WHERE MOT='"+q2.getText()+"'";
           PreparedStatement statementtest = con.prepareStatement(test);
           ResultSet resulttest = statementtest.executeQuery();
           
           int test1=0;
           if(resulttest.next()){
           test1=1;
           }
           if(test1!=0){
                 String afficher = "SELECT *  FROM MOT_" + m7.getSelectionModel().getSelectedItem() + " WHERE MOT='"+q2.getText()+"'";
           PreparedStatement statementtest2 = con.prepareStatement(afficher);
           ResultSet resulttest2 = statementtest2.executeQuery();
           while (resulttest2.next()) {
                 
                 m8.setText(resulttest2.getString(2));
                 m9.setValue(resulttest2.getString(3));
                 m10.setText(resulttest2.getString(4));
                 m11.setText(resulttest2.getString(5));
                 
                 
                
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
@FXML
     public void rech(ActionEvent event ) {
     String wa="";
     String mot=s2.getText();
     if(mot.matches("[a-zA-Z]+") ){
     try {
         try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
    System.out.println("Oracle JDBC driver not found.");
    e.printStackTrace();
}
         String first = s5.getValue();
        String second="";
         if(first.equals("FR"))
            second = "EN";
        else 
            second = "FR";
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "c##ab", "mypassword");
                 String test = "SELECT count(*)  FROM MOT_" + s5.getSelectionModel().getSelectedItem() + " WHERE MOT='"+s2.getText()+"'";
           PreparedStatement statementtest = con.prepareStatement(test);
           ResultSet resulttest = statementtest.executeQuery();
           
           int test1=0;
           if(resulttest.next()){
           test1=1;
           }
           if(test1!=0){
                 String afficher = "SELECT *  FROM MOT_" + s5.getSelectionModel().getSelectedItem() + " WHERE MOT='"+s2.getText()+"'";
           PreparedStatement statementtest2 = con.prepareStatement(afficher);
           ResultSet resulttest2 = statementtest2.executeQuery();
           while (resulttest2.next()) {
                 String query = "SELECT * FROM MOT_" + second + " WHERE ID_" + second + " IN (SELECT ID_" + second + " FROM traduction WHERE ID_" + first + " = (SELECT ID_" + first + " FROM MOT_" + first + " WHERE  MOT = '" + resulttest2.getString(2) + "'))";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet reader = command.executeQuery();
               if((reader.next())){
               
                
                 
                wa=wa+"le mot est :" +resulttest2.getString(2)+"le type ;"+resulttest2.getString(3)+"premier exemple:"+resulttest2.getString(4)+"deuxieme exemple:"+resulttest2.getString(5)
                        +"\n"+"la traduction est : "+reader.getString(2)+"le type est : "+reader.getString(3)+"exemple 1 : "+reader.getString(4)+"exemple 2 : "+reader.getString(5);
               }
            }    
           aa2.appendText("\n" + wa); 
           
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
