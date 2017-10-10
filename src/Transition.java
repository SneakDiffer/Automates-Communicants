
public abstract class Transition {
	private Etat etatInitial;
	private Etat etatFinal;
	
	//-------------------------SET------------------------
	public void setEtatOrigine(Etat etatOrigine) {
		this.etatInitial = etatOrigine;
	}
	
	public void setEtatFinal(Etat etatFinal) {
		this.etatFinal = etatFinal;
	}
	
	//-------------------------GET------------------------
	public Etat getEtatOrigine() {
		return etatInitial;
	}
	
	public Etat getEtatFinal() {
		return etatFinal;
	}
	
}
