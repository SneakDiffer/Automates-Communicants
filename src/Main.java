import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modele m = new Modele();
		Atomique a1 = new Atomique ("a1");
		m.addComposant(a1);
		Output o1 = new Output ("o1");
		Output o2 = new Output ("o2");
		Input i1 = new Input ("i1");
		Input i2 = new Input ("i2");
		Etat e1 = new Etat(1,1);
		Etat e2 = new Etat(2,2);
		Sortie s1 = new Sortie(e1);
		Externe ext1 = new Externe(e1, e2);
		
		a1.addPort(o1);
		a1.addPort(i1);
		a1.addEtat(e1);
		a1.addEtat(e2);
		e1.setSorties(s1);
		a1.addPort(o2);
		
		e1.addTransition(ext1);
		a1.addPort(i2);
		
		//System.out.println();
		System.out.println(ext1.getInput().size());
		System.out.println(a1.getInput().size());
		a1.removePort(i1);
		System.out.println(ext1.getInput().size());
		System.out.println(a1.getInput().size());
	}
}
