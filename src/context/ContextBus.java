package context;

public class ContextBus {

	private EtatBus etat = new EtatDepot();
	
	public ContextBus() {}
	
	public void changerEtat(EtatBus e) {
		this.etat = e;
	}
	
	public void stopper() {
		this.etat.stopper(this);
		System.out.println("Le bus s'arrete.");
	}
	
	public void demarrer() {
		this.etat.demarrer(this);
		System.out.println("Le bus demarre.");
	}
	
	public void sortirDepot() {
		this.etat.sortirDepot(this);
		System.out.println("Le bus sort du depot.");
	}
	
	public void retourDepot() {
		this.etat.retourDepot(this);
		System.out.println("Le bus est de retour au depot.");
	}
}
