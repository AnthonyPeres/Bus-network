package reseau;

public class Bus extends Observable {

	private EtatBus etatBus;
	private int numero;
	
	public Bus() {
		
	}
	
	public Bus(int n) {
		this.numero = n;
	}
	
	public void setState(EtatBus newEtat) {
		this.etatBus = newEtat;
	}
	
	public void action() {
		etatBus.action(this);
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int n) {
		this.numero = n;
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
