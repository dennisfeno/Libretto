/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import polito.tdp.libretto.model.Esame;
import polito.tdp.libretto.model.Model;

public class LibrettoController {

	// Model model = new Model() ; così è sbagliato creare il modello
	// in applicazioni più complesse ciascuna vista avrà il suo controller
	// non ha senso che sia il controllore a creare il modello; ci possono essere tanti controllori
	
	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	
    	String codice = txtCodice.getText() ;
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice corso non valido.\n");
    		return;
    	}
    	
    	Esame e = model.trovaEsame(codice) ;
    	
    	if (e==null){
    		txtMessage.appendText("Codice "+ codice + " non trovato.\n");
    	}
    	else{
    		txtMessage.appendText("Codice "+ codice + " trovato.\n");
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	//recupero i dati e 
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// ne verifica la validità 
    	
    	if ( codice.length() < 5 || titolo.length() == 0 || docente.length()==0){
    		//i dati non sono validi
    		txtMessage.appendText("Dati esame insufficienti.\n");
    		return ;
    	}
    	
    	txtCodice.clear();
    	txtTitolo.clear();
    	txtDocente.clear();
    	
    	//chiedi al model di effettuare l'operazione
    	
    	Esame e = new Esame (codice, titolo, docente);
    	
    	boolean result = model.addEsame(e);
    	
    	if ( result )
    		txtMessage.appendText("Esame aggiunto correttamente.\n");
    	else
    		txtMessage.appendText("Codice esame duplicato: ESAME NON AGGIUNTO.\n");
    	
    	//aggiorna la vista con il risultato dell'operazione
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @param model the model to set
	 * nel main dico qual è il modello da utilizzare.
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
