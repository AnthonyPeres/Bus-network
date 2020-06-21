package dao;

import reseau.*;

public class DAOJsonFactory {
	
	/* Constructeur */
	
	public DAOJsonFactory() {}

	/* Accesseurs */
	
	public DAOGenerique<Ligne> getLigneDAO() {
		return LigneDAOJson.getInstance();
	}
	
	public DAOGenerique<Arret> getArretDAO() {
		return ArretDAOJson.getInstance();
	}
	
}
