import java.util.HashSet;

public class Atomique extends Composant {
	private HashSet<Etat> etats;
	
	protected Atomique (){
		
	}

	//-------------------------GET------------------------
	public HashSet<Etat> getEtats() {
		return etats;
	}
	
	//-------------------------SET------------------------
	public void setEtats(HashSet<Etat> etats) {
		this.etats = etats;
	}
	


}
