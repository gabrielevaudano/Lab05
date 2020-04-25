package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class AnagrammaDAO {
	
	public boolean isCorrect(Parola parola) {
		String sql = "SELECT * FROM parola WHERE nome = ? ";
				
		try {
			Connection conn = ConnectDB.getConnection(); 
			
			PreparedStatement stn = conn.prepareStatement(sql); 
			stn.setString(1, parola.toString());
			ResultSet res = stn.executeQuery(); 
			
			if(res.next()) {
				conn.close();
				return true;
			}
			
			conn.close();
	
		} catch (SQLException e) {
			System.err.println("Si è verificato un errore: " + e);
		}
			
		return false;
	}
}
