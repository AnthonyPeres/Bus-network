package context;

import modele.Bus;

public class EtatArret implements EtatBus {

	@Override
	public void stopper(ContextBus context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demarrer(ContextBus context) {
		// TODO Auto-generated method stub
		context.changerEtat(new EtatDeplacement());
	}

	@Override
	public void sortirDepot(ContextBus context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retourDepot(ContextBus context) {
		// TODO Auto-generated method stub
		context.changerEtat(new EtatDepot());
	}

	
}
