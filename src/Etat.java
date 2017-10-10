import java.util.HashSet;

public class Etat {
	private float ta;
	private int ID;
	private HashSet<Transition> transitions;
	private Sortie sortie;
	
	public Etat(float ta, int ID){
		this.ta = ta;
		this.ID = ID;
		this.sortie = null;
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
	}

	public void addTransition(Transition t){
		transitions.add(t);
	}
}
