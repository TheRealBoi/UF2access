import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class BuscaJugador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String jugadorNombre = null;
		
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				ODB odb = ODBFactory.open("EQUIPOS.DB");
				
				System.out.println("Introduce el nombre de tu jugador/a.");
				try {
					jugadorNombre = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ICriterion criterio = Where.equal("nombre", jugadorNombre);
				IQuery query = new CriteriaQuery(Jugadores.class, criterio);
				
				
				Objects<Jugadores> objects = odb.getObjects(query);    
				
				for(Jugadores jug : objects) {
					System.out.printf("%s: %s, %s, %d, %s %n", jug.getNombre(), jug.getDeporte(), jug.getCiudad(), jug.getEdad(), jug.getPais());

				}
				odb.close();
	}

}
