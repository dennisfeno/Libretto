package polito.tdp.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model m = new Model() ;
		
		System.out.println(m.addEsame(new Esame ("03FYZ","Tecniche di programmazione","Fulvio Corno"))) ;
		System.out.println(m.addEsame(new Esame ("03FYZ","Tecniche di programmazione","Fulvio Corno"))) ;
		System.out.println(m.addEsame(new Esame ("01QZP","Ambient Intelligence","Fulvio Corno"))) ;
		//ritornava false se l'esame era già stato inserito
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("ciao"));
		
		
	}

}
