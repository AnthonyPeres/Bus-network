package reseau;

import dao.*;
import dao.DAOFactory.SourceDonnees;

public class Main {
	
	private final static SourceDonnees _sourceDonnees = SourceDonnees.Json;

	private static DAOFactory daoFactory;
	private static DAOGenerique<Ligne> ligneDAO;
	private static DAOGenerique<Arret> arretDAO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		daoFactory = new DAOFactory(_sourceDonnees);
		ligneDAO = daoFactory.getLigneDAO();
		arretDAO = daoFactory.getArretDAO();
		
		Ligne l1 = new Ligne("L1", null);
		ligneDAO.create(l1);
		
		
		 
	}

}
