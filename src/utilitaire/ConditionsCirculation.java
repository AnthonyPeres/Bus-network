package utilitaire;

public class ConditionsCirculation {

	private static final int TEMPS_DEPLACEMENT = 5;
	private static final int TEMPS_ARRET = 1000;
	
	public static int getTempsRoute() {
		return TEMPS_DEPLACEMENT;
	}

	public static int getTempsArret() {
		return TEMPS_ARRET;
	}

}
