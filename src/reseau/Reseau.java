package reseau;

import java.util.LinkedList;

import dao.DAOFactory.SourceDonnees;
import dao.*;

public class Reseau implements Observateur {
	
	/* Inscription du réseau dans la bdd. */
	private DAOFactory daoFactory;
	private DAOGenerique<Ligne> ligneDao;
	private DAOGenerique<Bus> busDao;
	
	/* Instance */
	private static Reseau instance = null;
	
	protected LinkedList<Ligne> lignes = new LinkedList<Ligne>();
	
	public Reseau() {
		this.daoFactory = new DAOFactory(SourceDonnees.Json);
		this.ligneDao = daoFactory.getLigneDAO();
		this.busDao = daoFactory.getBusDAO();
	}
	
	public static synchronized Reseau getInstance() {
		if (instance == null) {
			instance = new Reseau();
		}
		return instance;
	}
	
	public void notifier() {
		System.out.println("Le réseau a été notifié");
	}
	
	public Ligne addLigne(Ligne l) {
		lignes.add(l);
		return ligneDao.create(l);
	}
	
	public LinkedList<Ligne> getLignes() {
		if (ligneDao.findAll() == null) {
			return null;
		}
		return ligneDao.findAll();
	}
	
	public LinkedList<Bus> getBus() {
		if (busDao.findAll() == null) {
			return null;
		}
		return busDao.findAll();
	}
	
	
	
	
}
