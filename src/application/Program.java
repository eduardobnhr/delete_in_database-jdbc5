package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		//resoulução para atualizar dados
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE * FROM department"
					+ "WHERE "
					+ "Id = ?");
			st.setInt(1, 3);
					
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: "+ rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
