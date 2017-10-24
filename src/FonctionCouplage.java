
public class FonctionCouplage {
	private Port emetteur;
	private Port recepteur;
	private Couple couple;
	
	public FonctionCouplage(Port e, Port r,Couple c){
		emetteur = e;
		recepteur = r;
		setCouple(c);
	}
	
	//-------------------------GET------------------------
	public Port getEmetteur() {
		return emetteur;
	}

	public Port getRecepteur() {
		return recepteur;
	}
	
	public Couple getCouple() {
		return couple;
	}
	//-------------------------SET------------------------
	public void setEmetteur(Port emetteur) {
		this.emetteur = emetteur;
	}
	
	public void setRecepteur(Port recepteur) {
		this.recepteur = recepteur;
	}

	public void setCouple(Couple couple) {
		this.couple = couple;
	}
	
}
