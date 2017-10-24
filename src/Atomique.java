import java.util.HashSet;
import java.util.Iterator;

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
		e.setAtomique(this);
	}
	
	public void removeEtat(Etat e){
		//On supprime les transitions associées
		//Fonction de sortie
		Iterator<Output> i = this.getOutput().iterator();
		while(i.hasNext()){
			Output o = (Output) i.next();
			o.getSorties().remove(e.getSorties());
		}
		//transition externe
		//Niveau Input
		Iterator<Input> i2 = this.getInput().iterator();
		while(i2.hasNext()){
			Input ip = i2.next();
			Iterator<Externe> i3 = ip.getTransitionsExternes().iterator();
			while(i3.hasNext()){
				Externe ext = i3.next();
				if(ext.getEtatFinal() == e || ext.getEtatOrigine() == e){
					ip.removeTransitionExterne(ext);
				}
			}
		}
		//Niveau etat
		Iterator<Transition> i4 = e.getTransitions().iterator();
		while(i4.hasNext()){
			Transition t = i4.next();
			if(t.getEtatOrigine() == e){
				t.getEtatFinal().removeTransition(t);
			}
			else{
				t.getEtatOrigine().removeTransition(t);
			}
		}
		etats.remove(e);
	}
	
	public void removeTransitionInterne(Transition t){
		Iterator<Etat> i = etats.iterator();
		while(i.hasNext()){
			Etat e = i.next();
			e.removeTransition(t);
		}
	}
	
	public void removeTransitionExterne(Transition t){
		//suppression niveau etat
		Iterator<Etat> i = etats.iterator();
		while(i.hasNext()){
			Etat e = i.next();
			e.removeTransition(t);
		}
		//suppression niveau input
		Iterator<Input> i2 = this.getInput().iterator();
		while(i2.hasNext()){
			Input ip = i2.next();
			ip.removeTransitionExterne((Externe)t);
		}
	}
	
	public void removeTransitionSortie(Sortie s){
		//suppression niveau etat
		s.setEtat(null);
		//suppression niveau output
		Iterator<Output> i = this.getOutput().iterator();
		while(i.hasNext()){
			Output ip = i.next();
			ip.removeSortie(s);
		}
	}

}
