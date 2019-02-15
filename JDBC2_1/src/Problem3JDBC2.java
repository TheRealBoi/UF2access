import java.sql.ResultSetMetaData;
import java.sql.*;

public class Problem3JDBC2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData() ;
			Statement statement = conexion.createStatement();
			ResultSet resul = statement.executeQuery("SELECT * FROM depart");					
			ResultSetMetaData rsmd = resul.getMetaData();
				
			int n_colmns = 0;
	
			
			for(int i = 1; i < rsmd.getColumnCount(); i++) {
				System.out.println("Tipo de columna: " +  rsmd.getColumnType(i));
			}
			
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
