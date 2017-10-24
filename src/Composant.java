import java.util.HashSet;
import java.util.Iterator;

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
	//-------------------------PRINT------------------------
	
	public void printInputOutput(){
		Iterator<Input> i = inputs.iterator();
		while(i.hasNext()){
			Input ip = i.next();
			System.out.println(ip.getName());
		}
		
		Iterator<Output> i2 = outputs.iterator();
		while(i2.hasNext()){
			Output ip = i2.next();
			System.out.println(ip.getName());
		}
	}

	//-------------------------GET------------------------
	public HashSet<Input> getInputs() {
			return inputs;
	}
		
	public HashSet<Output> getOutputs() {
			return outputs;
	}

	public String getName() {
			return name;
	}
		
	public Couple getComposantSupp() {
		return composantSupp;
	}
	
	public Port getInputOutput(String name){
		Iterator<Input> i = inputs.iterator();
		while(i.hasNext()){
			Input ip = i.next();
			if(ip.equals(new Input(name))) {
				return ip;
			}
		}
		
		Iterator<Output> i2 = outputs.iterator();
		while(i2.hasNext()){
			Output op = i2.next();
			if(op.equals(new Output(name))) {
				return op;
			}
		}
		return null;
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
	
	public void removePort(Port p){
		if(p instanceof Output){
			outputs.remove(p);
		}else{
			inputs.remove(p);
		}
	}
}
