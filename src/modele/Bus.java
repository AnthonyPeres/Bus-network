package modele;

import context.ContextBus;
import context.ControlesBus;
import context.EtatBus;
import events.IEventsControleBus;
import observer.Observable;


public class Bus extends Observable {
	
	/* Variables */
	private int numero;

	private IEventsControleBus m_controlesBus;
	private ContextBus m_contexte;

	/* Constructeur */
	public Bus(int n) {
		this.numero = n;	
		
		m_controlesBus = new ControlesBus();
		m_contexte = new ContextBus(m_controlesBus);
	}
	
	
	public IEventsControleBus controles() {
		return m_controlesBus;
	}
	
	
	public void stopper() {
		m_contexte.stopper();
		System.out.println("Arret du bus.");
	}
	
	public void demarrer() {
		m_contexte.demarrer();
		System.out.println("Demarrage du bus.");
	}
	
	public void retourDepot() {
		m_contexte.retourDepot();;
		System.out.println("Retour au depot.");
	}
	
	public void sortirDepot() {
		m_contexte.sortirDepot();
		System.out.println("Sortie du dépot.");
	}
	
	
	/* Accesseurs - Mutateurs */
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int n) {
		this.numero = n;
	}

	
}
