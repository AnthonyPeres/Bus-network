package observer;

public interface Observable {
	
	public void notifierObservateurs();
	
	void ajouterObservateur(Observateur observateur);
	
	void supprimerObservateur(Observateur observateur);
	
}
