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
	
	public void removeTransitionExterne(Externe t){
		transitionsExternes.remove(t);
	}
	
	public int hashCode(){
		return this.getName().hashCode();
	}
	
	public boolean equals(Object obj){
		return this.getName().equals(((Input) obj).getName());
	}
	
}
