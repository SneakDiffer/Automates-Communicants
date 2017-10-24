import java.util.HashSet;

public class Couple extends Composant {
	private HashSet<Composant> composants;
	
	protected Couple (String name){
		super(name);
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
		c.setComposantSupp(this);
	}
	
}
