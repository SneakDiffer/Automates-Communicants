
public abstract class Port {
	private String name;
	private Object value;
	private Composant composant;
	private FonctionCouplage connecteur;
	
	protected Port(String name){
		this.name = name;
		value = null;
		composant = null;
		connecteur = null;
	}
	//-------------------------GET------------------------
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}	

	public Composant getComposant() {
		return composant;
	}
	
	public FonctionCouplage getConnecteur() {
		return connecteur;
	}
	//-------------------------SET------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public void setComposant(Composant composant) {
		this.composant = composant;
	}

	public void setConnecteur(FonctionCouplage connecteur) {
		this.connecteur = connecteur;
	}
	
}
