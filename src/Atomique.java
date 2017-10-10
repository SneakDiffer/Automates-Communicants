import java.util.HashSet;

public class Atomique extends Composant {
	private HashSet<Etat> etats;
	
	protected Atomique (String name){
		super(name);
		etats = new HashSet<Etat>();
	}

	//-------------------------GET------------------------
	public HashSet<Etat> getEtats() {
		return etats;
	}
	
	//-------------------------SET------------------------
	public void setEtats(HashSet<Etat> etats) {
		this.etats = etats;
	}
	
	public void addEtat(Etat e){
		etats.add(e);
	}

}
