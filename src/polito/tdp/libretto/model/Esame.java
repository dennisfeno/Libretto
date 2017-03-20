package polito.tdp.libretto.model;
import java.time.LocalDate;

/*
 * Oggetto semplice che contiene i dati relativi ad un singolo esame.
 * POJO - plain old java object
 * 
 * dati privati (proprietà) **
 * costruttore
 * metodi get/set 
 * metodi di servizio equals, toString, hashCode, [compareTo]
 * lo facciamo diventare un oggetto che sa visualizzare e comparare i propri dati
 * 
 * equals si usa per confrontare l'uguaglianza
 * compare tu per dire se è maggiore o minore
 *  ** qua devo mettere la testa, il resto lo genera eclipse
 */

public class Esame {

	private String codice ;
	private String titolo ;
	private String docente ; // di cosa ho bisogno ? una classe docente mi può far comodo ? 
	// private Docente docente ; 
	// mi farebbe piacere gestire l'elenco dei docenti. per oggi ci accontentiamo della prima

	private Boolean superato ;
	private int voto ;
	private LocalDate dataSuperamento ; //non usare Date da java.util perché "fa cagare"
	
	//quali informazioni sono necessarie per costruire un nuovo corso?

	/**
	 * Nuovo esame, non ancora superato
	 * @param codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente nome e cognome del docente titolare
	 */
	
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato = false ; // non me lo faccio passare dal chiamante
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public Boolean getSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	public void setSuperato(Boolean superato) {
		this.superato = superato;
	}

	/**
	 * restituisce il voto solo se l'esame è superato, altrimenti eccezione
	 * @return the voto
	 */
	public int getVoto() {
		if( this.superato )
			return voto;
		else {
			throw new IllegalStateException("Esame "+this.codice+" non superato.");
		}
	}

	/**
	 * @param voto the voto to set
	 * 
	 */
	private void setVoto(int voto) { // posso chiamarli solo io 
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if( this.superato )
			return dataSuperamento;
		else {
			throw new IllegalStateException("Esame "+this.codice+" non superato.");
		}
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) { // per mantenere una coerenza nel programma
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	
//devo definire equals per dire cosa rende uguali o diversi due elementi. L'equals predefinito confronta solamente l'indirizzo di memoria
// dico quali siano le proprietà dell'oggetto
// due esami sono uguali se hanno lo stesso: codice, o meglio, li considero uguali

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	/**
	 * se l'esame non è ancora superato, lo considera superato con voto e data inseriti
	 * altrimenti se è già superato genera un'eccezione
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		
		if ( ! this.superato ) { //non ancora superato: OK
			this.superato = true ;
			this.voto = voto ;
			this.dataSuperamento = data ; 
		} else {
			throw new IllegalStateException("Esame "+this.codice+" già superato."); 
			//c'è qualcosa che non va, ho chiamato un metodo il cui stato non rendeva valido il senso della sua chiamata
		}	
		
	}
	
}
