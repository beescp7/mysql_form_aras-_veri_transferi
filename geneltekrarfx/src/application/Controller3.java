package application;
import com.IsteMysql.*;

import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller3 {

    @FXML
    private TextField txt_user;

    @FXML
    private TextField txt_pass;

    @FXML
    private Button btn_giris;
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
     Stage appStage;
     Parent root;
    @FXML
    void event_giris(ActionEvent event) {
    	baglanti=VeritabaniUtil.Baglan();
    	sql="select * from kullanýcý where k_username=? and k_meslek=?";
    	 try {
    	 sorguIfadesi=baglanti.prepareStatement(sql);
    	 sorguIfadesi.setString(1, txt_user.getText().trim());
    	 sorguIfadesi.setString(2, txt_pass.getText().trim());
    	 ResultSet getirilen=sorguIfadesi.executeQuery();

    	 if(!getirilen.next()) {
    	 System.out.println("yanlýs");
    	 }
    	 else {
    	 
    		
    			try {
    	    		 FXMLLoader loader= new FXMLLoader(getClass().getResource("Sahne1.fxml"));
    	    		AnchorPane pane2= (AnchorPane) loader.load();
    	    		
    	    		Scene scene2=new Scene(pane2);
    	    		
    	    		Stage stage2=new Stage();
    	    		stage2.setScene(scene2);
    	    		stage2.show();
    	    		} catch (IOException e) { e.printStackTrace(); } 

        		

    	 }
    	} catch (Exception e) {  }
    }

}