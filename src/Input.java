import java.util.HashSet;

public class Input extends Port {
	private HashSet<Externe> transitionsExternes;
	
	public Input(String name){
		super(name);
		transitionsExternes = new HashSet<Externe>();
	}

	//-------------------------GET------------------------
	public HashSet<Externe> getTransitionsExternes() {
		return transitionsExternes;
	}

	//-------------------------SET------------------------
	public void setTransitionsExternes(HashSet<Externe> transitionsExternes) {
		this.transitionsExternes = transitionsExternes;
	}
	
	public void addTransitionExterne(Externe t){
		transitionsExternes.add(t);
	}
}
