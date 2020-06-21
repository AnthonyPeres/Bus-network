package reseau;

public class Reseau implements Observateur {

	public void notifier() {
		System.out.println("Le réseau a été notifié");
	}
	
}
