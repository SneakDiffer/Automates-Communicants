import java.util.HashSet;

public abstract class Composant {
	private HashSet<Port> inputs;
	private HashSet<Port> outputs;
	private String name;
	
	//-------------------------GET------------------------
	public HashSet<Port> getInput() {
			return inputs;
	}
		
	public HashSet<Port> getOutput() {
			return outputs;
	}
	
	public void AddPort(Port p){
			if(p instanceof Input){
				this.inputs.add(p);
			}else{
				this.outputs.add(p);
			}
	}

	public String getName() {
			return name;
	}
		
	//-------------------------SET------------------------
	public void setInput(HashSet<Port> input) {
		this.inputs = input;
	}

	public void setOutput(HashSet<Port> output) {
		this.outputs = output;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	


}
