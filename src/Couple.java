import java.util.HashSet;

public class Couple extends Composant {
	private HashSet<Composant> composants;
	protected Couple (){
		
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
