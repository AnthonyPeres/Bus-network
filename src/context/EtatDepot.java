package context;

public class EtatDepot implements EtatBus {

	@Override
	public void stopper(ContextBus context) {
		System.out.println("Le bus doit être hors du dépot.");
	}

	@Override
	public void demarrer(ContextBus context) {
		System.out.println("Le bus doit être hors du dépot.");
	}

	@Override
	public void sortirDepot(ContextBus context) {
		context.changerEtat(new EtatArret());
	}

	@Override
	public void retourDepot(ContextBus context) {
		System.out.println("Le bus est déjà au dépot.");
	}

}
