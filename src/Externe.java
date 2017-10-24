import java.util.HashSet;
import java.util.Iterator;

public class Externe extends Transition{
	private HashSet<Input> inputs;
	
	public Externe(Etat i, Etat e){
		super(i,e);
		inputs = new HashSet<Input>();
	}
	//-------------------------GET------------------------
	public HashSet<Input> getInput() {
		return inputs;
	}
		
	//-------------------------SET------------------------
	public void setInput(HashSet<Input> input) {
		this.inputs = input;
		//Une fonction de transition externe est connectée à tous les ports d'entrée de l'atomique
		Iterator<Input> it = input.iterator();
		while(it.hasNext()){
			Input i = it.next();
			i.addTransitionExterne(this);
		}
	}
	
	public void addInput (Input i){
		inputs.add(i);
		i.addTransitionExterne(this);
	}

}
