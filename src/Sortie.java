import java.util.HashSet;
import java.util.Iterator;

public class Sortie {
	private Etat etat;
	private HashSet<Output> outputs;
	
	public Sortie(Etat e){
		this.etat = e;
		outputs = new HashSet<Output>();
	}
	
	//-------------------------GET------------------------

	
	public HashSet<Output> getOutput() {
		return outputs;
	}
	
	public Etat getEtat() {
		return etat;
	}
	//------------------------SET-------------------------
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public void setOutput(HashSet<Output> output) {
		this.outputs = output;
		//Une fonction de sortie est connectée à tous les ports de sortie de l'atomique
		Iterator<Output> i = output.iterator();
		while(i.hasNext()){
			Output o = i.next();
			o.addSortie(this);
		}
	}
}
