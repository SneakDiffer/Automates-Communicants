import java.util.HashSet;
import java.util.Iterator;


public class Couple extends Composant {
	private HashSet<Composant> composants;
	private HashSet<FonctionCouplage> connecteur;

	protected Couple (String name){
		super(name);
		composants = new HashSet<Composant>();
		setConnecteur(new HashSet<FonctionCouplage>());
	}
	//------------------------PRINT-----------------------
	public void printAllComposant(){
		Iterator<Composant> i = composants.iterator();
		while(i.hasNext()){
			Composant c = i.next();
			System.out.println(c.getName());
		}
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
	
	//On sait que pc1 appartient à c1 et inversement
	//On donne en premier le composant emetteur et en second le composant recepteur
	public void couplage(Composant c1,Port pc1,Composant c2,Port pc2){
		//Les ports sont ils disponibles ? 
		if(pc1.getConnecteur() == null && pc2.getConnecteur() == null){
			//Connecteur de même niveau
			if(c1.getComposantSupp() == c2.getComposantSupp()){
				//Connection OUT/IN
				if((pc1 instanceof Output) && (pc2 instanceof Input)){
					FonctionCouplage f = new FonctionCouplage(pc1, pc2, this);
					pc1.setConnecteur(f);
					pc2.setConnecteur(f);
					c1.setComposantSupp(this);
					c2.setComposantSupp(this);
					composants.add(c1);
					composants.add(c2);
				}
			}
			if((c1 == this) && (c2.getComposantSupp() == this)){
				//Connection IN/IN
				if((pc1 instanceof Input) && (pc2 instanceof Input)){
					FonctionCouplage f = new FonctionCouplage(pc1, pc2, this);
					pc1.setConnecteur(f);
					pc2.setConnecteur(f);
					c2.setComposantSupp(this);
					composants.add(c2);
				}
			}
			if((c1.getComposantSupp() == this) && (c2 == this)){
				//Connection OUT/OUT
				if((pc1 instanceof Output) && (pc2 instanceof Output)){
					FonctionCouplage f = new FonctionCouplage(pc1, pc2, this);
					pc1.setConnecteur(f);
					pc2.setConnecteur(f);
					c1.setComposantSupp(this);
					composants.add(c1);
				}
			}
		}
	}
	
	public void removeComposant(Composant c){
		composants.remove(c);
		//Suppression de toutes les fonctions de couplage utilisant ce composant
		Iterator<FonctionCouplage> i = connecteur.iterator();
		while(i.hasNext()){
			FonctionCouplage f = i.next();
			if(f.getEmetteur().getComposant() == c || f.getRecepteur().getComposant() == c ){
				connecteur.remove(c);
				f.getEmetteur().setConnecteur(null);
				f.getRecepteur().setConnecteur(null);
			}
		}
	}
	
	public void removeConnecteur(FonctionCouplage f){
		connecteur.remove(f);
	}
	
	public int hashCode(){
		return this.getName().hashCode();
	}
	
	public boolean equals(Object obj){
		return this.getName().equals(((Couple) obj).getName());
	}
}
