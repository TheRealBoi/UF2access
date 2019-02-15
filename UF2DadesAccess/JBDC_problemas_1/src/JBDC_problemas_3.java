import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDC_problemas_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String local;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria", "austria");
			System.out.println("Localidad que buscas: ");
			local = br.readLine();
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT dnombre, GROUP_CONCAT(apellido) AS apellidos FROM depart LEFT JOIN emple USING(dept_no) WHERE loc = '" + local + "' GROUP BY dnombre;";
			//System.out.println(sql);
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()) {
				System.out.printf("%s, %s, %n", 
						result.getString("dnombre"),
						result.getString("apellidos"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
