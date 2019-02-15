import org.neodatis.odb.Objects;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Pais {
	private int id;
	private String nombrepais;
	
	public Pais() {
		
	}
	public Pais(int id, String name) {
		this.id = id;
		this.nombrepais = name;
	}
	
	public String getName() {
		return nombrepais;
	}
	public void setName(String name) {
		this.nombrepais = name;
	}
	public int getId() {
		return id;
	}
	
	public String toString() { 
		return this.nombrepais;
	}
	
}
