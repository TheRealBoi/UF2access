import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBCD_problemas_1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo", "austria", "austria");
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * from emple WHERE dept_no = 10";
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()) {
				System.out.printf("%s, %s, %d, %n", 
						result.getString("apellido"),
						result.getString("oficio"),
						result.getInt("salario"));
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
