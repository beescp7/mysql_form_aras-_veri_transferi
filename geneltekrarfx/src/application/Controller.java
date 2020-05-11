package application;
import com.IsteMysql.*;
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

	
	Connection baglanti = null;
	PreparedStatement sorguIfadesi = null;
	ResultSet getirilen = null;
	String sql;
    @FXML
    private TableView<Kullanýcý> table2;

    @FXML
    private TableColumn<Kullanýcý, String> tc_ad;

    @FXML
    private TableColumn<Kullanýcý, String> tc_soyad;

    @FXML
    private Button btn_goster;

    @FXML
    private Button btn_detay;

    @FXML
    void event_detay(ActionEvent event) {
    	try {
    		 FXMLLoader loader= new FXMLLoader(getClass().getResource("Sahne2.fxml"));
    		AnchorPane pane2= (AnchorPane) loader.load();
    		Controller2 nesne= loader.getController();
    		Scene scene2=new Scene(pane2);
    		nesne.verial(id,ad,soyad,user,meslek);
    		Stage stage2=new Stage();
    		stage2.setScene(scene2);
    		stage2.show();
    		} catch (IOException e) { e.printStackTrace(); } 


    }
    String ad;
    String soyad;
    int id;
    String user;
    String meslek;
    @FXML
    void event_goster(ActionEvent event) throws SQLException {
    	baglanti = VeritabaniUtil.Baglan();
		sql = "select *from kullanýcý";
		sorguIfadesi = baglanti.prepareStatement(sql);
		ResultSet getirilen = sorguIfadesi.executeQuery();
		ObservableList<Kullanýcý> userdata = FXCollections.observableArrayList();
		
		while (getirilen.next()) {
			   
			  id=getirilen.getInt("k_id");
			 ad = getirilen.getString("k_ad");
			 soyad = getirilen.getString("k_soyad");
			
            
            user=getirilen.getString("k_username");
            meslek=getirilen.getString("k_meslek");
          
            userdata.add(new Kullanýcý(id,ad,soyad,user,meslek));
		}
		table2.getItems().addAll(userdata);
		
    }
    @FXML
    void event_tableclick(MouseEvent event) {
    	Kullanýcý kayit = new Kullanýcý();
		kayit = (Kullanýcý) table2.getItems().get(table2.getSelectionModel().getSelectedIndex());
		id=kayit.getId();
		ad=kayit.getAd();
		
		soyad=kayit.getSoyad();
		user=kayit.getUsername();
		meslek=kayit.getMeslek();
		
		
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
		tc_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
		tc_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
	}

}