import java.util.HashSet;
import java.util.Iterator;

public class Atomique extends Composant {
	private HashSet<Etat> etats;
	
	protected Atomique (String name){
		super(name);
		etats = new HashSet<Etat>();
	}

	//-------------------------PRINTER------------------------
	public void printEtats(){
		Iterator<Etat> i = etats.iterator();
		while(i.hasNext()){
			Etat e = i.next();
			System.out.println(e.getID());
		}
	}
	//-------------------------GET------------------------
	public HashSet<Etat> getEtats() {
		return etats;
	}
	
	public Etat getEtat(int ID){
		Iterator<Etat> i = etats.iterator();
		while(i.hasNext()){
			Etat e = i.next();
			if(e.equals(new Etat(0,ID))) {
				return e;
			}
		}
		return null;
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
		Iterator<Output> i = this.getOutputs().iterator();
		while(i.hasNext()){
			Output o = (Output) i.next();
			o.getSorties().remove(e.getSortie());
		}
		//transition externe
		//Niveau Input
		Iterator<Input> i2 = this.getInputs().iterator();
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
		Iterator<Input> i2 = this.getInputs().iterator();
		while(i2.hasNext()){
			Input ip = i2.next();
			ip.removeTransitionExterne((Externe)t);
		}
	}
	
	public void removeTransitionSortie(Sortie s){
		//suppression niveau etat
		s.setEtat(null);
		//suppression niveau output
		Iterator<Output> i = this.getOutputs().iterator();
		while(i.hasNext()){
			Output ip = i.next();
			ip.removeSortie(s);
		}
	}

	public void addPort(Port p){
		if (p instanceof Input){
			super.addPort(p);
			//Chaque input est relié à l'ensemble des fonctions de transitions externe
			if(this instanceof Atomique){
				Iterator<Etat> i = ((Atomique) this).getEtats().iterator();
				while(i.hasNext()){
					Etat e = i.next();
					if(e.getTransitions().size() != 0){
						Iterator<Transition> it2 = e.getTransitions().iterator();
						while(it2.hasNext()){
							Transition t = it2.next();
							if(t instanceof Externe){
								((Input) p).addTransitionExterne((Externe) t);
							}
						}
					}
				}
			}
		}else{
			super.addPort(p);
			//Chaque output est relié à l'ensemble des fonctions de sortie
			if(this instanceof Atomique){
				Output ot = (Output)p;
				Atomique a = (Atomique)this;
				Iterator<Etat> i = a.getEtats().iterator();
				while(i.hasNext()){
					Etat e = i.next();
					if(e.getSortie() != null){
						ot.addSortie(e.getSortie());
					}
				}
			}
		}
		p.setComposant(this);
	}
	
	public void removePort(Port p){
		super.removePort(p);
		if(p instanceof Output){
			//Suppresion des fonctions de sortie associées à ce port
			Iterator<Sortie> i = ((Output) p).getSorties().iterator();
			while(i.hasNext()){
				Sortie s = i.next();
				HashSet<Output> so = s.getOutput();
				so.remove(p);
				s.setOutput(so);
			}
		}else{
			//Suppresion des fonctions de transitions externe associées
			Iterator<Externe> i = ((Input) p).getTransitionsExternes().iterator();
			while(i.hasNext()){
				Externe ext = i.next();
				HashSet<Input> exti = ext.getInput();
				exti.remove(p);
				ext.setInput(exti);
			}
		}		
	}

	
	public int hashCode(){
		return this.getName().hashCode();
	}
	
	public boolean equals(Object obj){
		return this.getName().equals(((Atomique) obj).getName());
	}
	
}
