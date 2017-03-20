package polito.tdp.libretto;
	
/*
 * information hiding: permette di separare le applicazioni e gestirle separatamente
 * il modello non deve contenere nulla dell'interfaccia
 * dentro il modello è come se lavorassi nel corso di programmazione ad oggetti
 * dobbiamo gestire un insieme di esami: dovrò costruire una lista di esami
 * creerò una classe contenitore e metto tutto nel modello
 */

import javafx.application.Application;
import javafx.stage.Stage;
import polito.tdp.libretto.model.Model;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//spezzol il controller per poter avere un riferimento al model con cui i metodi devono lavorare
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			//creo il modello
			
			LibrettoController controller = loader.getController(); 
			
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
