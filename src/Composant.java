import java.util.HashSet;

public abstract class Composant {
	private Modele modele;
	private HashSet<Port> input;
	private HashSet<Port> output;

	//-------------------------SET------------------------
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	public void setInput(HashSet<Port> input) {
		this.input = input;
	}

	public void setOutput(HashSet<Port> output) {
		this.output = output;
	}
	
	//-------------------------GET------------------------
	public Modele getModele() {
		return modele;
	}
	
	public HashSet<Port> getInput() {
		return input;
	}
	
	public HashSet<Port> getOutput() {
		return output;
	}
	
}
