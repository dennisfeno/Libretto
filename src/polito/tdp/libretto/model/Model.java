package polito.tdp.libretto.model;
import java.util.ArrayList;
import java.util.List;

//model è la classe principale che gestisce i dati dell'esame
// il modello deve permettere di inserire all'interfaccia utente quello di cui avrò bisogno
// andiamo avanti sempre in maniera incrementale
// cerchiamo di usare poco le variabili semplici

public class Model {

	private List<Esame> esami ;
	
	public Model() { //lasciare l'oggetto in uno stato coerente
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiungere un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia già
	 * @param e
	 * @return true se l'ha inserito, false se esisteva già e non l'ho potuto inserire
	 */
	
	public boolean addEsame(Esame e){ //io non ti espongo la lista, ti faccio fare solo quello che voglio io
		/*
		 * leggendo la documentazione
		 * Returns true if this list contains the specified element. 
		 * More formally, returns true if and only if this list contains at least one element e 
		 * such that (o==null ? e==null : o.equals(e)).
		 */
		if ( !esami.contains(e)){
			esami.add(e) ;
			return true;
		}
		else {
			//o ritorno un boolean o lancio un'eccezione
			return false ;
		}
	}
	/**
	 * ricerca se esiste un esame con il codice specificato
	 * se esiste lo resituisce, altrimenti restituisce null.
	 * @param codice
	 * @return l'esame trovato, oppure null se non trovato
	 */
	
	public Esame trovaEsame(String codice){
		//indexOf e contains fanno ricerche
		
		//this.esami.indexOf(codice) non posso farlo perché si aspetta un oggetto della lista
		
		int pos = this.esami.indexOf( new Esame(codice,null,null)) ; // uso indexOf che sicuramente sarà meglio di quello che scrivo io
		
		if (pos == -1)
			return null ;
		else
			return esami.get(pos) ;
	}
	
}