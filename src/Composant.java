import java.util.HashSet;

public abstract class Composant {
	private HashSet<Input> inputs;
	private HashSet<Output> outputs;
	private String name;
	private Couple composantSupp; //Composant N+1  
	
	protected Composant (String name){
		inputs = new HashSet<Input>();
		outputs = new HashSet<Output>();
		this.name = name;
		composantSupp = null;
	}
	
	//-------------------------GET------------------------
	public HashSet<Input> getInput() {
			return inputs;
	}
		
	public HashSet<Output> getOutput() {
			return outputs;
	}

	public String getName() {
			return name;
	}
		
	public Couple getComposantSupp() {
		return composantSupp;
	}

	//-------------------------SET------------------------
	public void setInput(HashSet<Input> input) {
		this.inputs = input;
	}

	public void setOutput(HashSet<Output> output) {
		this.outputs = output;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setComposantSupp(Couple composantSupp) {
		this.composantSupp = composantSupp;
	}
	
	public void addPort(Port p){
		if (p instanceof Input){
			inputs.add((Input)p);
		}else{
			outputs.add((Output)p);
		}
		p.setComposant(this);
	}

}
