import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BuscaJugadorEdad {

	public static void main(String[] args) {
		String jugadorNombre = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ODB odb = ODBFactory.open("EQUIPOS.DB");

		
		ICriterion criterio = new And()
				.add(Where.lt("edad", 20))
				.add(Where.gt("edad", 14));
		// ICriterion criterio = Where.gt("edad", 14);
		IQuery query = new CriteriaQuery(Jugadores.class, criterio);
		
		Objects<Jugadores> objects = odb.getObjects(query);
		for(Jugadores jug : objects) {
			System.out.printf("%s: %s, %s, %d, %s %n", jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(),
					jug.getPais());
		}
		odb.close();
	
	}
}
