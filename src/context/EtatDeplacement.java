package context;

import modele.*;


public class EtatDeplacement implements EtatBus {

	@Override
	public void stopper(ContextBus context) {
		// TODO Auto-generated method stub
		context.changerEtat(new EtatArret());
	}

	@Override
	public void demarrer(ContextBus context) {
		// TODO Auto-generated method stub
		
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
