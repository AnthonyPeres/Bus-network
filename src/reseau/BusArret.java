package reseau;

public class BusArret implements EtatBus {

	public BusArret() {
		
	}
	
	@Override
	public void action(Bus context) {
		// TODO Auto-generated method stub
		System.out.println("Le bus est à l'arret");
	}

}
