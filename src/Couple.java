import java.util.HashSet;

public class Couple extends Composant {
	private HashSet<Composant> composants;
	private HashSet<FonctionCouplage> connecteur;
	
	protected Couple (String name){
		super(name);
		composants = new HashSet<Composant>();
		setConnecteur(new HashSet<FonctionCouplage>());
	}
	
	//-------------------------GET------------------------
	public HashSet<Composant> getComposants() {
		return composants;
	}
	
	public HashSet<FonctionCouplage> getConnecteur() {
		return connecteur;
	}
	
	//-------------------------SET------------------------
	public void setComposants(HashSet<Composant> composants) {
		this.composants = composants;
	}
	
	public void addComposant(Composant c){
		composants.add(c);
		c.setComposantSupp(this);
	}

	public void setConnecteur(HashSet<FonctionCouplage> connecteur) {
		this.connecteur = connecteur;
	}
	
}
