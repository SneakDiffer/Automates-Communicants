import java.util.HashSet;

public class Externe extends Transition{
	private HashSet<Input> inputs;
	
	public Externe(Etat i, Etat e){
		super(i,e);
		inputs = new HashSet<Input>();
	}
	//-------------------------SET------------------------
	public void setInput(HashSet<Input> input) {
		this.inputs = input;
	}
	
	//-------------------------GET------------------------
	public HashSet<Input> getInput() {
		return inputs;
	}
	
	public void addInput (Input i){
		inputs.add(i);
		i.addTransitionExterne(this);
	}

}
