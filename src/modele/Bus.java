package modele;

import context.ContextBus;
import observer.Observable;


public class Bus extends Observable {
	
	/* Variables */
	private int numero;
	private ContextBus m_contexte;
	public enum Etat { ARRET, DEPLACEMENT, DEPOT };
	public Etat etatCourant;
	
	/* Constructeur */
	public Bus(int n) {
		this.numero = n;	
		this.etatCourant = Etat.DEPOT;
		m_contexte = new ContextBus();
	}
	
	public Etat getEtat() {
		return this.etatCourant;
	}
	
	public void stopper() {
		this.etatCourant = Etat.ARRET;
		m_contexte.stopper();
	}
	
	public void demarrer() {
		this.etatCourant = Etat.DEPLACEMENT;
		m_contexte.demarrer();
	}
	
	public void retourDepot() {
		this.etatCourant = Etat.DEPOT;
		m_contexte.retourDepot();;
	}
	
	public void sortirDepot() {
		this.etatCourant = Etat.ARRET;
		m_contexte.sortirDepot();
	}
	
	
	/* Accesseurs - Mutateurs */
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int n) {
		this.numero = n;
	}

	
}
