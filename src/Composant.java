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
			//Chaque input est relié à l'ensemble des fonctions de transitions externe
			if(this instanceof Atomique){
				Iterator<Etat> i = ((Atomique) this).getEtats().iterator();
				while(i.hasNext()){
					Etat e = i.next();
					if(e.getTransitions().size() != 0){
						Iterator<Transition> it2 = e.getTransitions().iterator();
						while(it2.hasNext()){
							Transition t = it2.next();
							if(t instanceof Externe){
								((Input) p).addTransitionExterne((Externe) t);
							}
						}
					}
				}
			}
		}else{
			outputs.add((Output)p);
			//Chaque output est relié à l'ensemble des fonctions de sortie
			if(this instanceof Atomique){
				Output ot = (Output)p;
				Atomique a = (Atomique)this;
				Iterator<Etat> i = a.getEtats().iterator();
				while(i.hasNext()){
					Etat e = i.next();
					if(e.getSorties() != null){
						ot.addSortie(e.getSorties());
					}
				}
			}
		}
		p.setComposant(this);
	}
	
	public void removePort(Port p){
		if(p instanceof Output){
			outputs.remove(p);
			//Suppresion des fonctions de sortie associées à ce port
			Iterator<Sortie> i = ((Output) p).getSorties().iterator();
			while(i.hasNext()){
				Sortie s = i.next();
				HashSet<Output> so = s.getOutput();
				so.remove(p);
				s.setOutput(so);
			}
		}else{
			inputs.remove(p);
			//Suppresion des fonctions de transitions externe associées
			Iterator<Externe> i = ((Input) p).getTransitionsExternes().iterator();
			while(i.hasNext()){
				Externe ext = i.next();
				HashSet<Input> exti = ext.getInput();
				exti.remove(p);
				ext.setInput(exti);
			}
		}
	}
}
