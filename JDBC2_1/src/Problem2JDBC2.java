import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

public class Problem2JDBC2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria", "austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resulDept = null, resulEmple = null;			
			resulDept = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			resulEmple = dbmd.getExportedKeys("ejemplo", null, "depart");
			while (resulDept.next() ) {
				
				System.out.printf("Nombre: %s" + "\t" 
				+ "Foreign Key: %s", 
						resulDept.getString("COLUMN_NAME"),
						resulEmple.getString("FKCOLUMN_NAME")
						); 
						
			}
			conexion.close();
		} catch (ClassNotFoundException cn) {cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
	}
}