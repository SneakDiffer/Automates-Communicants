import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader IN = null;
		try{
			IN=new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e){
			System.err.println("Erreur " +e);
			System.exit(1);
		}
		String menu;
		String ligne;
		
	/*	System.out.println("Creation du modèle le nom ?");
		ligne = IN.readLine();
		Modele modele = new Modele(ligne); */
		Modele modele = new Modele("bla");
		Composant c;
		//System.out.println();
		do
		{
			System.out.println("1 Ajouter un composant atomique ");
			System.out.println("2 Supprimer un composant atomique");
			System.out.println("3 Lister les composants atomiques ");
			System.out.println("4 Ajouter un port à un composant atomique ");
			System.out.println("5 Supprimer un port d'un composant atomique ");
			System.out.println("6 Lister les ports d'un composant atomique ");
			System.out.println("7 Ajouter un etat à un composant atomique ");
			System.out.println("8 Supprimer un etat d'un composant atomique ");
			System.out.println("9 Lister les états d'un composant atomique ");
			System.out.println("10 Ajouter la transition de sortie à un état d'un composant ");
			System.out.println("11 Ajouter une fonction de transition interne à un composant ");
			System.out.println("12 Supprimer de/des transition(s) d'un composant ");
			System.out.println("13 Afficher toutes les transitions d'un composant ");
			System.out.println("69 Quitter ");
			menu = IN.readLine();
			switch(Integer.parseInt(menu)){
				case 1:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					modele.addComposant(new Atomique(ligne));
					break;
				case 2:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) { modele.removeComposant(c); }
					break;
				case 3:
					modele.printComposant();
					break;
				case 4:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ){
						System.out.println("Nom du port/1 si input 0 si output");
						ligne = IN.readLine();
						String[] parts = ligne.split("/");
						if(Integer.parseInt(parts[1]) == 1){
							c.addPort(new Input(parts[0]));
						}else{
							c.addPort(new Output(parts[0]));
						}
					}
					break;
				case 5:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ){
						System.out.println("Le nom du port ? ");
						ligne = IN.readLine();
						Port i = c.getInputOutput(ligne);
						if(c != null ){ c.removePort(i); }
					}
					break;
				case 6:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) { c.printInputOutput(); }
					break;
				case 7:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						System.out.println("L'Id de l'état ?/Le ta de l'état ?");
						ligne = IN.readLine();
						String[] parts = ligne.split("/");
						if(parts.length == 2){
							((Atomique)c).addEtat(new Etat(Float.parseFloat(parts[1]), Integer.parseInt(parts[0])));
						}
					}
					break;
				case 8:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						System.out.println("L'ID de l'état ? ");
						ligne = IN.readLine();
						Etat e = ((Atomique) c).getEtat(Integer.parseInt(ligne));
						if(e != null){
							((Atomique)c).removeEtat(e);
						}
					}
					break;
				case 9:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						((Atomique)c).printEtats();
					}
					break;
				// ------------------------- HEU MAIS PUTAIN C'EST NUL COMME TRUC ????? ET LA SUPPRESSION ???----------------
				case 10:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						System.out.println("L'ID de l'état ? ");
						ligne = IN.readLine();
						Etat e = ((Atomique) c).getEtat(Integer.parseInt(ligne));
						if(e != null){
							e.setSortie(new Sortie(e));
						}
					}
					break;
				case 11:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						System.out.println("L'ID de l'état initial? ");
						ligne = IN.readLine();
						Etat i = ((Atomique) c).getEtat(Integer.parseInt(ligne));
						if(i != null){
							System.out.println("L'ID de l'état final? ");
							ligne = IN.readLine();
							Etat f = ((Atomique) c).getEtat(Integer.parseInt(ligne));
							if(f != null){
								i.addTransition(new Interne(i,f));
							}
						}
					}
					break;
				case 12:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						//Affichage de toutes les transitions interne et externe
						Iterator<Etat> ie = ((Atomique) c).getEtats().iterator();
						while(ie.hasNext()){
							Etat e = ie.next();
							Iterator<Transition> it = e.getTransitions().iterator();
							while(it.hasNext()){
								Transition t = it.next();
								if(t instanceof Interne){
									System.out.println("Interne, etat initial :" +t.getEtatOrigine().getID() + " etat final " + t.getEtatFinal().getID());
									System.out.println("Supprimer cette transition ? 1 oui 0 non ");
									ligne = IN.readLine();
									if(Integer.parseInt(ligne) == 1){
										((Atomique)c).removeTransitionInterne(t);
										break;
									}
								}else{
									System.out.println("Externe, etat initial : " +t.getEtatOrigine().getID() + " etat final " + t.getEtatFinal().getID());
									System.out.println("Supprimer cette transition ? 1 oui 0 non ");
									ligne = IN.readLine();
									if(Integer.parseInt(ligne) == 1){
										((Atomique)c).removeTransitionExterne(t);
										break;
									}
								}
								
							}
						}
					}
					break;
				case 13:
					System.out.println("Le nom du composant ? ");
					ligne = IN.readLine();
					c = modele.getComposant(ligne);
					if(c != null ) {
						//Affichage de toutes les transitions interne et externe
						Iterator<Etat> ie = ((Atomique) c).getEtats().iterator();
						while(ie.hasNext()){
							Etat e = ie.next();
							System.out.println("Etat : "+e.getID());
							Iterator<Transition> it = e.getTransitions().iterator();
							while(it.hasNext()){
								Transition t = it.next();
								if(t instanceof Interne){
									System.out.println("Interne, etat initial :" +t.getEtatOrigine().getID() + " etat final " + t.getEtatFinal().getID());
								}else{
									System.out.println("Externe, etat initial : " +t.getEtatOrigine().getID() + " etat final " + t.getEtatFinal().getID());
								}
							}
						}
					}
					break;
				case 14:
					
					break;
				case 15:
					break;
				default:
						break;
			}
		}while(Integer.parseInt(menu) != 69);
		
	}
}
