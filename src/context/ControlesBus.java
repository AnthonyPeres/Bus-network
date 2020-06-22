package context;

import events.IEventsControleBus;

public class ControlesBus implements IEventsControleBus {

	@Override
	public void stopper() {
		// TODO Auto-generated method stub
		System.out.println("Le bus freine.");
	}

	@Override
	public void demarrer() {
		// TODO Auto-generated method stub
		System.out.println("Le bus redemarre.");
	}

	@Override
	public void sortirDepot() {
		// TODO Auto-generated method stub
		System.out.println("Le bus sort du dépot.");
	}

	@Override
	public void retourDepot() {
		// TODO Auto-generated method stub
		System.out.println("Le bus repart au depot.");
	}

	
	
}
