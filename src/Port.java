import java.util.HashSet;

public abstract class Port {
	private String name;
	private Object value;
	private HashSet<FonctionCouplage> fonctionsCouplage;
	private Composant composant;
	
	protected Port(String name){
		this.name = name;
		value = null;
		fonctionsCouplage = new HashSet<FonctionCouplage>();
		composant = null;
	}
	//-------------------------GET------------------------
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}	
	
	public HashSet<FonctionCouplage> getFonctionsCouplage() {
		return fonctionsCouplage;
	}

	public Composant getComposant() {
		return composant;
	}
	//-------------------------SET------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public void setFonctionsCouplage(HashSet<FonctionCouplage> fonctionsCouplage) {
		this.fonctionsCouplage = fonctionsCouplage;
	}

	public void setComposant(Composant composant) {
		this.composant = composant;
	}
	
	public void addFonctionCouplage(FonctionCouplage fc){
		fonctionsCouplage.add(fc);
	}
}
