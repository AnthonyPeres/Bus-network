package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import context.ContextBus;
import observer.Observable;
import observer.Observateur;
import utilitaire.ConditionsCirculation;
import utilitaire.Position;

public class Bus implements Observable {
	
	/* Variables */
	private int numero;
	private transient ContextBus m_contexte = new ContextBus();
	private Arret arretCourant;
	private Ligne ligne;
	private Position position;
	private List<Observateur> m_observateurs;
		
	/* Constructeur */
	public Bus(int n, Observateur observateur) {
		this.numero = n;
		this.m_observateurs = new ArrayList<Observateur>();
		this.ajouterObservateur(observateur);
	}
	
	/* Fonction de deplacement */
	public void run() {
		Runnable run = () -> {
			int[] index = {0};
			System.out.println(this);
			
			while (true) {
				this.ligne.getArrets().forEach((arret) -> {
					arret.getPosition();
					if(!arret.equals(this.ligne.getTerminus())) {
						double tempsDeTrajetReel = 0;
						
						Arret arretSuivant = this.ligne.getArretSuivant(arret);
						
						// Calcul de la distance entre les deux points (vecteurs)
						double x1 = arret.getPosition().getPositionX();
						double x2 = arretSuivant.getPosition().getPositionX();
						double y1 = arret.getPosition().getPositionY();
						double y2 = arretSuivant.getPosition().getPositionY();
						double x = x2 - x1;
						double y = y2 - y1;
						double distance = Math.sqrt((x * x) + (y * y));
						
						int tempsDeTrajet = this.ligne.getTrajets().get(index[0]) * ConditionsCirculation.getTempsRoute();
						
						this.position = arret.getPosition();
						
						// On démarre le bus
						this.demarrer();
						
						while(tempsDeTrajetReel < tempsDeTrajet) {
							try {
								double increment = distance/tempsDeTrajet;
								
								if(arretSuivant.getPosition().getPositionX() > arret.getPosition().getPositionX()) {
									this.position.setX(this.position.getPositionX() + increment);
								}
								else {
									this.position.setX(this.position.getPositionX() - increment);
								}
								
								if(arretSuivant.getPosition().getPositionY() > arret.getPosition().getPositionY()) {
									this.position.setY(this.position.getPositionY() + increment);
								}
								else {
									this.position.setY(this.position.getPositionY() - increment);
								}
								
								this.notifierObservateurs();
								Thread.sleep(1000);
								tempsDeTrajetReel += increment;
							} catch(InterruptedException e) {
								e.printStackTrace();
							}
							
						}
						
						// On s'arrete à l'arret
						this.stopper();
						try {
							Thread.sleep(ConditionsCirculation.getTempsArret());
						} catch(InterruptedException e){
							e.printStackTrace();
						}
						
						index[0]++;
					}
					
				});
			}
		};
		new Thread(run).start();
	}

	@Override
	public String toString() {
		return "Bus [numero=" + numero + ", arretCourant=" + arretCourant + ", ligne=" + ligne + ", position="
				+ position + ", m_observateurs=" + m_observateurs + "]";
	}

	public Position getPosition() {
		return position;
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

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		Iterator<Observateur> it = m_observateurs.iterator();
		
		// On notifie tous les observateurs.
		while(it.hasNext()) {
			Observateur obs = it.next();
			obs.update();
		}
	}

	@Override
	public void ajouterObservateur(Observateur observateur) {
		// TODO Auto-generated method stub
		m_observateurs.add(observateur);
		
	}

	@Override
	public void supprimerObservateur(Observateur observateur) {
		// TODO Auto-generated method stub
		m_observateurs.remove(observateur);
		
	}
}
