package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller2 {

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_soyad;

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_meslek;
    public void verial(int id1,String ad1,String soyad1,String user,String meslek)
    
    {
    	txt_id.setText(Integer.toString(id1));
    	txt_ad.setText(ad1);
    	txt_soyad.setText(soyad1);
    	txt_username.setText(user);
    	txt_meslek.setText(meslek);
    	
    }

}
