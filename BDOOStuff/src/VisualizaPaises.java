import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;


public class VisualizaPaises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ODB odb = ODBFactory.open("EQUIPOS.DB");
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);    
		
		//recuperamos todos los objetos
		System.out.printf("%d Jugadores: %n", objects.size());
		
		for(Jugadores jug : objects) {
			System.out.printf("%s: %s, %s, %d, %s %n", jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais());

		}
		odb.close();
	}

}
