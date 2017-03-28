package polito.tdp.libretto.model;
import java.util.ArrayList;
import java.util.List;

import polito.tdp.libretto.db.EsameDAO;

// cambio solamente l'implementazione del model, se ho fatto bene le cose non dovrei avere problemi
// mi piacerebbe separare i vari livelli

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
	
	public boolean addEsame (Esame e) {
		EsameDAO dao = new EsameDAO() ;
		return dao.create(e) ;
	}
	
	/**
	 * ricerca se esiste un esame con il codice specificato
	 * se esiste lo resituisce, altrimenti restituisce null.
	 * @param codice
	 * @return l'esame trovato, oppure null se non trovato
	 */
	
	public Esame trovaEsame(String codice){

		EsameDAO dao = new EsameDAO() ;
		
		Esame e = dao.find(codice) ;
		
		return e ; 
		
	}
	
}