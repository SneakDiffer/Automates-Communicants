
public abstract class Transition {
	private Etat etatInitial;
	private Etat etatFinal;
	
	protected Transition(Etat i, Etat f){
		etatInitial = i;
		etatFinal = f;
		etatInitial.addTransition(this);
		etatFinal.addTransition(this);
	}
	
	//-------------------------GET------------------------
	public Etat getEtatOrigine() {
		return etatInitial;
	}
	
	public Etat getEtatFinal() {
		return etatFinal;
	}
	
	//-------------------------SET------------------------
	public void setEtatOrigine(Etat etatOrigine) {
		this.etatInitial = etatOrigine;
	}
	
	public void setEtatFinal(Etat etatFinal) {
		this.etatFinal = etatFinal;
	}
	
	
}
