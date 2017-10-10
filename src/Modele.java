import java.util.HashSet;

public class Modele {
	private HashSet<Composant> composants;
	
	public Modele(){
		
	}
	//-------------------------GET------------------------
	public HashSet<Composant> getComposants() {
		return composants;
	}
	
	//-------------------------SET------------------------
	public void setComposants(HashSet<Composant> composants) {
		this.composants = composants;
	}
	

	
}
