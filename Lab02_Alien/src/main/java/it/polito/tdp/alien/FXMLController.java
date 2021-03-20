/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInserisci"
    private TextField txtInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    public void setModel(AlienDictionary model) {
    	this.model=model;
    }
    
    @FXML
    void handleClear(ActionEvent event) {
    	this.txtRisultato.clear();
    	this.txtInserisci.clear();
    }

    @FXML
    void handleInserisci(ActionEvent event) {
//    	String testo= this.txtInserisci.getText();
//
//    	if(testo.length()==0) {
//    		this.txtRisultato.setText("Errore: inserire almeno una parola");
//    		return;
//    	}
//    	
//    	testo.toLowerCase();
//    	String parole[]= testo.split(" ");
//   		for(String s: parole) {
//   			for(char c: s.toCharArray()) {
//   				if(!Character.isLetter(c)) {
//   					this.txtRisultato.setText("Errore: inserire solo lettere nella parola");    
//   					this.txtInserisci.clear();
//   					return;
//    			}
//    		}
//   		}
//    	
//   		if(parole.length==1) {
//   			this.txtRisultato.setText(this.model.translateWord(parole[0]));
//   			this.txtInserisci.clear();
//   		}
//   		else if(parole.length==2) {
//   			this.model.addWord(parole[0], parole[1]);
//   			this.txtInserisci.clear();
//   		}
//   		else {
//   			this.txtRisultato.setText("Errore: inserire al massimo due parole");
//   			this.txtInserisci.clear();
//   			this.txtRisultato.clear();
//   			return;
//   		}
    	
    	
    	String prova;
    
    	prova=this.txtInserisci.getText();
    	prova.toLowerCase();
    	
    	String array[]= prova.split(" ");
    	
    	if(array.length==1) {
    		String risultato;
    		try {
    			risultato= model.translate(array[0]);
    		} catch(IllegalStateException se) {
    			this.txtRisultato.setText(se.getMessage());
    			return;
    		} catch(InvalidParameterException pe) {
    			this.txtRisultato.setText(pe.getMessage());
    			return;
    		}
    		this.txtRisultato.setText(array[0]+" --> "+risultato);
    	}
    	else if(array.length==2) {
    		try {
    		  model.add(array[0], array[1]);
    		} catch(InvalidParameterException pe) {
    			this.txtRisultato.setText(pe.getMessage());
    			return;
    		}
    	}
    	else {
    		this.txtRisultato.setText("Puoi inserire al massimo due parole!");
    		return;
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
