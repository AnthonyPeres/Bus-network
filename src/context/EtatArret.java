package context;

public class EtatArret implements EtatBus {

	@Override
	public void stopper(ContextBus context) {
		System.out.println("Le bus est déjà à l'arret.");
	}

	@Override
	public void demarrer(ContextBus context) {
		context.changerEtat(new EtatDeplacement());
	}

	@Override
	public void sortirDepot(ContextBus context) {
		System.out.println("Le bus est déjà hors du dépot.");
	}

	@Override
	public void retourDepot(ContextBus context) {
		context.changerEtat(new EtatDepot());
	}
	
}
