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
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Libretto.fxml"));
			Scene scene = new Scene(root,400,400);
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
