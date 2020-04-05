package it.polito.tdp.anagrammi;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;

import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnagrammi;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea taAnagrammiCorretti;

    @FXML
    private TextArea taAnagrammiErrati;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	String testo = txtAnagrammi.getText();
    	Collection<Parola> anagrammi = new HashSet<Parola>(model.findAnagrammi(testo));
    	
    	for (Parola p : anagrammi)
    		if (model.isCorrect(p))
    			taAnagrammiCorretti.appendText(p.toString() + "\n");
    		else
    			taAnagrammiErrati.appendText(p.toString() + "\n");
    }

    @FXML
    void reset(ActionEvent event) {
    	txtAnagrammi.clear();
    	taAnagrammiCorretti.clear();
    	taAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtAnagrammi != null : "fx:id=\"txtAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert taAnagrammiCorretti != null : "fx:id=\"taAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert taAnagrammiErrati != null : "fx:id=\"taAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
