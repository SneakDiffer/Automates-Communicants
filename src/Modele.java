import java.util.HashSet;
import java.util.Iterator;

public class Modele {
	private String name;
	private HashSet<Composant> composants;
	
	public Modele(String n){
		setName(n);
		composants = new HashSet<Composant>();
	}
	//------------------------PRINT-----------------------
	public void printComposant(){
		Iterator<Composant> i = composants.iterator();
		while(i.hasNext()){
			Composant c = i.next();
			if(c instanceof Atomique){
				System.out.println("Atomique : " + c.getName());
			}else{
				System.out.println("Couplé : " + c.getName());
			}
		}
	}
	//-------------------------GET------------------------
	public HashSet<Composant> getComposants() {
		return composants;
	}
	public String getName() {
		return name;
	}

	public Composant getComposant(String name){
		Iterator<Composant> i = composants.iterator();
		while(i.hasNext()){
			Composant c = i.next();
			if(c instanceof Atomique){
				if(c.equals(new Atomique(name))) {
					return c;
				}
			}else{
				if(c.equals(new Couple(name))) {
					return c;
				}
			}
		}
		return null;
	}
	//-------------------------SET------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setComposants(HashSet<Composant> composants) {
		this.composants = composants;
	}
	
	public void addComposant(Composant c){
		composants.add(c);
	}
	
	public void removeComposant(Composant c){
		composants.remove(c);
		//Si ce composant faisait parti d'un composant couplé, supprimer toutes les fonction de couplage du couplé utilisant ce composant
		if(c.getComposantSupp() != null){
			c.getComposantSupp().removeComposant(c);
		}
		//Si ce composant est un composant couplé, supprimer tout les composants du modèle appartenant à ce composant couplé
		if(c instanceof Couple){
			Iterator<Composant> i = composants.iterator();
			while(i.hasNext()){
				Composant ci = i.next();
				if(ci.getComposantSupp() == c){ composants.remove(ci);}
			}
		}
	}
	
}
