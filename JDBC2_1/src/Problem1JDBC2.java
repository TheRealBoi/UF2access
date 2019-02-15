import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Problem1JDBC2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;			
			resul = dbmd.getColumns(null, null, "depart", null);
			while (resul.next()) {
				
				System.out.printf("%s - "
				+ "Nombre: %s" + "\t" 
				+ "Tipo: %s" + "\t" 
				+ "Size: %s" + "\t" 
				+ "Puede ser null: %s %n", 
						resul.getString(1), 
						resul.getString("COLUMN_NAME"), 
						resul.getString("DATA_TYPE"), 
						resul.getString("COLUMN_SIZE"),
						resul.getString("iS_NULLABLE"));
			}
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}