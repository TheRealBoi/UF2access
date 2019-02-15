
import org.neodatis.odb.Objects;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class EjemploNeodatis {    
	public static void main(String[] args) {
		
		
		
		Pais p1 = new Pais(1, "Alemania");
		Pais p3 = new Pais(3, "España");
		
		// Crear los jugadores
		Jugadores jE1 = new Jugadores("Marina", "futbol", "Madrid", 14, p3);  
		Jugadores jE2 = new Jugadores("Santiago", "paddle", "Madrid", 15, p3);
		Jugadores jE3 = new Jugadores("Luigi", "natacion", "Guadalajara", 15, p1);
		Jugadores jE4 = new Jugadores("Elissa", "tenis", "Madrid", 14, p1);	
		
		 
		// Abrir BD
		ODB odb = ODBFactory.open("EQUIPOS.DB");  
		// Almacenamos Jugadores
		odb.store(jE1);   
		odb.store(jE2);
		odb.store(jE3);
		odb.store(jE4);
		
		
		
		odb.close(); 
		// Cerrar BD     
		}
	}
	
