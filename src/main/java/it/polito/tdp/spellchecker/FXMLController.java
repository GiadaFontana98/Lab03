package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary model = new Dictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtCorr;

    @FXML
    private Label txtErrori;

    @FXML
    private Label txtTempo;

    @FXML
    private TextArea txtTesto;

    @FXML
    void check(ActionEvent event) {
      model.loadDictionary(cmbLanguage.getPromptText());  //serve per stamparmi il risultato, prende quello che c'è nella cmb
      txtCorr.setText(""+model.spellCheckTest(txtTesto.getText()).size());
      txtErrori.setText(""+model.spellCheckTest(txtTesto.getText()).size());
      txtTempo.setText(""+model.getTemp());
      
    
    }

    @FXML
    void clear(ActionEvent event) {

    }

    public void setModel(Dictionary model)
    {
    	this.model=model;
    }
    
    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorr != null : "fx:id=\"txtCorr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbLanguage.getItems().add("English"); 
        cmbLanguage.getItems().add("Italian"); 
    }

}


