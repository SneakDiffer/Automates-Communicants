
public class FonctionCouplage {
	private Port emetteur;
	private Port recepteur;
	
	public FonctionCouplage(){
		
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
