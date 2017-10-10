import java.util.HashSet;

public class Sortie {
	private Etat etat;
	private HashSet<Output> outputs;
	
	public Sortie(){
		
	}
	
	//-------------------------SET------------------------
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public HashSet<Output> getOutput() {
		return outputs;
	}
	//-------------------------GET------------------------
	public Etat getEtat() {
		return etat;
	}

	public void setOutput(HashSet<Output> output) {
		this.outputs = output;
	}
	
}
