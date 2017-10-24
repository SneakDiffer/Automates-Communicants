import java.util.HashSet;

public class Etat {
	private float ta;
	private int ID;
	private HashSet<Transition> transitions;
	private Sortie sortie;
	private Atomique atomique;
	
	public Etat(float ta, int ID){
		this.ta = ta;
		this.ID = ID;
		this.sortie = null;
		transitions = new HashSet<Transition>();
		this.atomique = null;
	}
	
	//-------------------------GET------------------------
	public float getTa() {
		return ta;
	}
	
	public int getID() {
		return ID;
	}
	
	public HashSet<Transition> getTransitions() {
		return transitions;
	}
	
	public Sortie getSorties() {
		return sortie;
	}
	
	public Atomique getAtomique() {
		return atomique;
	}
	//-------------------------SET------------------------
	public void setTa(float ta) {
		this.ta = ta;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setTransitions(HashSet<Transition> transitions) {
		this.transitions = transitions;
	}

	public void setSorties(Sortie sortie) {
		this.sortie = sortie;
		sortie.setEtat(this);
		//Une fonction de sortie est connectée à tous les ports de sortie de l'atomique
		sortie.setOutput(atomique.getOutput());
	}
	
	public void addTransition(Transition t){
		transitions.add(t);
		if(this == t.getEtatOrigine()){
			HashSet<Transition> transitionFinal = t.getEtatFinal().getTransitions();
			transitionFinal.add(t);
			t.getEtatFinal().setTransitions(transitionFinal);
			
		}else{
			HashSet<Transition> transitionOrigine = t.getEtatOrigine().getTransitions();
			transitionOrigine.add(t);
			t.getEtatFinal().setTransitions(transitionOrigine);
		}
		//Une fonction de transition externe est connectée à tous les ports d'entrée de l'atomique
		if(t instanceof Externe){
			if(this == t.getEtatOrigine()){
				//Les inputs de l'atomique sont connectés à l'état d'origine de la transition
				((Externe) t).setInput(atomique.getInput());
				
			}else{
				//Les inputs de l'atomique sont connectés à l'état d'origine de la transition
				((Externe) t).setInput(t.getEtatOrigine().atomique.getInput());
			}
		}
	}

	public void setAtomique(Atomique atomique) {
		this.atomique = atomique;
	}
	
	public void removeTransition(Transition t){
		transitions.remove(t);
	}
}
