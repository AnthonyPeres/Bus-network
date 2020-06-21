package reseau;

public class Bus extends Observable {

	private EtatBus etatBus;
	
	public Bus() {
		
	}
	
	public void setState(EtatBus newEtat) {
		this.etatBus = newEtat;
	}
	
	public void action() {
		etatBus.action(this);
	}
	
	
	// Observer : Fonction a changer : voir cour
	
	private boolean m_detecteVariation;
	
	public void run() {
		while(true) {
			if (m_detecteVariation) {
				notifierObservateurs();
			}
		}
	}
	
}
