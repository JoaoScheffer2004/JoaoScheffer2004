package connection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

public class connectionFactory {

		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdcv:mysql://localhost:3306/rodoviaria";
		private static final String USER = "root";
		private static final String PASS = "";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro em iniciar a conexão: ",e);
		}
	}
	
	public static void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} 
		catch (SQLException e) {
			throw new RuntimeException("Erro ao encerrar a conexão: ", e);
			}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		try {
			if(stmt != null) {
				stmt.close();
			}
		}
		catch (SQLException e) {
			throw new RuntimeException("Erro ao encerrar a conexão: ", e);
			}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
			try {
				if(rs != null) {
				rs.close();
			}
	} 
			catch (SQLException e) {
			throw new RuntimeException("Erro ao encerrar a conexão: ", e);
			}
	}
	
}

