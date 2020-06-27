package modele;

import context.ContextBus;
import observer.Observable;
import utilitaire.ConditionsCirculation;

public class Bus extends Observable {
	
	/* Variables */
	private int numero;
	private transient ContextBus m_contexte = new ContextBus();
	private Arret arretCourant;
	private Ligne ligne;
		
	/* Constructeur */
	public Bus(int n) {
		this.numero = n;	
	}
	
	/* Fonction de deplacement */
	public void run() {
		Runnable run = () -> {
			this.sortirDepot();
			
			while (true) {
				
				for (int i = 0; i < this.ligne.getArrets().size(); i++) {
					
					// On roule jusqu'à l'arret suivant
					this.demarrer();
					try {
						Thread.sleep(this.ligne.getTrajets().get(i) * ConditionsCirculation.getTempsRoute());
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					
					// On s'arrete à l'arret
					this.stopper();
					try {
						Thread.sleep(ConditionsCirculation.getTempsArret());
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(run).start();
	}
	
	/* Changement d'état */
	public void stopper() {
		m_contexte.stopper();
	}
	
	public void demarrer() {
		m_contexte.demarrer();
	}
	
	public void retourDepot() {
		m_contexte.retourDepot();;
	}
	
	public void sortirDepot() {
		m_contexte.sortirDepot();
	}
	
	
	/* Accesseurs - Mutateurs */
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int n) {
		this.numero = n;
	}
	
	public Arret getArret() {
		return this.arretCourant;
	}
	
	public void setArret(Arret a) {
		this.arretCourant = a;
	}

	public void setLigne(Ligne l) {
		// TODO Auto-generated method stub
		this.ligne = l;
		this.arretCourant = l.getPremierArret();
	}
	
	public Ligne getLigne() {
		return this.ligne;
	}
}
