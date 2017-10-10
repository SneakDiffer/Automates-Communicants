import java.util.HashSet;

public class Modele {

	private HashSet<Composant> composants;
	
	public Modele(){
		composants = new HashSet<Composant>();
	}
	//-------------------------GET------------------------
	public HashSet<Composant> getComposants() {
		return composants;
	}
	
	//-------------------------SET------------------------
	public void setComposants(HashSet<Composant> composants) {
		this.composants = composants;
	}
	
	public void addComposant(Composant c){
		composants.add(c);
	}
}
