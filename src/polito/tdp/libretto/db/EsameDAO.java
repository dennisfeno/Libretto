package polito.tdp.libretto.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polito.tdp.libretto.model.Esame;

public class EsameDAO {

	public Esame find(String codice){
		
		String sql = "SELECT codice, titolo, docente, superato, voto, data_superamento "+
					"FROM esame "+
					"WHERE codice =?" ;
		
		// se non uso la prepare execute rischio errori di sqlInjection
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root" ;
		
		Esame result = null;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;

			st.setString(1, codice) ; // manda le cose in un canale separato
			
			ResultSet res = st.executeQuery() ; 
			
			if (res.next()){ // se c'è una prima riga
				
				Esame ex = new Esame(
						res.getString("codice") ,
						res.getString("titolo") ,
						res.getString("docente") 
						) ;
				
				// TODO estrarre anche voto e data _ superamento
				
				result = ex ;
				
			} else 
				 // return null; // TODO
				result = null ; 
			
			conn.close() ;
			return result ; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public boolean create (Esame e){
		
		String sql = "INSERT INTO `libretto`.`esame` (`codice`, `titolo`, `docente`) VALUES (?, ?, ?);";
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			PreparedStatement st = conn.prepareStatement(sql) ;

			st.setString(1, e.getCodice()) ; 
			st.setString(2, e.getTitolo());
			st.setString(3, e.getDocente());
			
			
			int result = st.executeUpdate() ; 
			
			conn.close() ;
			
			if (result == 1)
				return true;
			else
				return false; 
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return false ;
	}
	

	
	
}
