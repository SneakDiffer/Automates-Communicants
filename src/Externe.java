import java.util.HashSet;

public class Externe extends Transition{
	private HashSet<Input> inputs;
	
	public Externe(){
		
	}
	//-------------------------SET------------------------
	public void setInput(HashSet<Input> input) {
		this.inputs = input;
	}
	
	//-------------------------GET------------------------
	public HashSet<Input> getInput() {
		return inputs;
	}

}
