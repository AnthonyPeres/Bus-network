package observer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Observable {

	private List<Observateur> m_observateurs;
	
	public Observable() {
		m_observateurs = new LinkedList<Observateur>();
	}
	
	public void notifierObservateurs() {
		Iterator<Observateur> it = m_observateurs.iterator();
		
		// On notifie tous les observateurs.
		while(it.hasNext()) {
			Observateur obs = it.next();
			obs.notifier();
		}
	}
	
	void ajouterObservateur(Observateur observateur) {
		m_observateurs.add(observateur);
	}
	
	void supprimerObservateur(Observateur observateur) {
		m_observateurs.remove(observateur);
	}
	
}
