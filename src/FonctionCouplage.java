
public class FonctionCouplage {
	private Port emetteur;
	private Port recepteur;
	
	public FonctionCouplage(Port e, Port r){
		emetteur = e;
		recepteur = r;
	}
	
	//-------------------------GET------------------------
	public Port getEmetteur() {
		return emetteur;
	}

	public Port getRecepteur() {
		return recepteur;
	}
	//-------------------------SET------------------------
	public void setEmetteur(Port emetteur) {
		this.emetteur = emetteur;
	}
	
	public void setRecepteur(Port recepteur) {
		this.recepteur = recepteur;
	}
	
}
