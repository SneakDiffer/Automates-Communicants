import java.util.HashSet;

public class Output extends Port{
	private HashSet<Sortie> sorties;
	
	public Output (String name){
		super(name);
		sorties = new HashSet<Sortie>();
	}

	//-------------------------GET------------------------
	public HashSet<Sortie> getSorties() {
		return sorties;
	}
	
	//-------------------------SET------------------------
	public void setSorties(HashSet<Sortie> sorties) {
		this.sorties = sorties;
	}

	public void addSortie(Sortie s){
		sorties.add(s);
	}
	
	public void removeSortie(Sortie s){
		sorties.remove(s);
	}
	
	public int hashCode(){
		return this.getName().hashCode();
	}
	
	public boolean equals(Object obj){
		return this.getName().equals(((Output) obj).getName());
	}
}
