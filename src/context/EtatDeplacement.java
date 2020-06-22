package context;

public class EtatDeplacement implements EtatBus {
	
	@Override
	public void stopper(ContextBus context) {
		context.changerEtat(new EtatArret());
	}

	@Override
	public void demarrer(ContextBus context) {
		System.out.println("Le bus circule déjà.");
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
