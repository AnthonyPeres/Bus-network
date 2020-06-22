package daoFactory;

import dao.ArretDAOJson;
import dao.BusDAOJson;
import dao.DAOGenerique;
import dao.LigneDAOJson;
import modele.Arret;
import modele.Bus;
import modele.Ligne;

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
	
	public DAOGenerique<Bus> getBusDAO() {
		return BusDAOJson.getInstance();
	}
	
}
