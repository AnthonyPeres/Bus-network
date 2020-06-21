package dao;

import dao.DAOGenerique;
import reseau.*;


public class DAOFactory {

	// 2 formats de bdd possible : MySQL ou Json
	public enum SourceDonnees {
		Json
	}
	
	/* Les variables */
	
	private SourceDonnees _sourceDonnees;
	private DAOJsonFactory _daoJsonFactory = new DAOJsonFactory();
	
	/* Le constructeur */
	
	public DAOFactory(SourceDonnees sd) {
		this._sourceDonnees = sd;
	}
		
	/* Accesseurs */
	
	public SourceDonnees getSourceDonnees() {
		return this._sourceDonnees;
	}
	
	/* Mutateurs */
	
	public void setSourceDonnees(SourceDonnees sd) {
		this._sourceDonnees = sd;
	}
	
	/* Les fonctions */
	
	public DAOGenerique<Ligne> getLigneDAO() {
		switch(this._sourceDonnees) {
			case Json :
				return this._daoJsonFactory.getLigneDAO();
		
		}
		return null;
	}
	
	public DAOGenerique<Arret> getArretDAO() {
		switch(this._sourceDonnees) {
			case Json :
				return this._daoJsonFactory.getArretDAO();
		
		}
		return null;
	}
	
	public DAOGenerique<Bus> getBusDAO() {
		switch(this._sourceDonnees) {
			case Json :
				return this._daoJsonFactory.getBusDAO();
		
		}
		return null;
	}
	
}
