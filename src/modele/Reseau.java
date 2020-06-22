package modele;

import java.util.LinkedList;

import observer.Observateur;
import dao.*;
import daoFactory.DAOFactory;
import daoFactory.DAOFactory.SourceDonnees;

public class Reseau implements Observateur {
	
	/* Inscription du réseau dans la bdd. */
	private DAOFactory daoFactory;
	private DAOGenerique<Ligne> ligneDao;
	private DAOGenerique<Bus> busDao;
	
	/* Instance */
	private static Reseau instance = null;
	
	protected LinkedList<Ligne> lignes = new LinkedList<Ligne>();
	protected LinkedList<Bus> lesbus = new LinkedList<Bus>();
	
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
	
	public Ligne removeLigne(Ligne l) {
		lignes.remove(l);
		return ligneDao.delete(l);
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
	
	public Bus creerBus() {
		return new Bus((this.lesbus.size() + 1));
	}
	
	public Bus ajouterBusDepot(Bus b) {
		this.lesbus.add(b);
		return busDao.create(b);
	}
	
	public void ajouterBusLigne(Bus b, Ligne l) {
		if (this.lesbus.contains(b)) {
			if (this.lignes.contains(l)) {
				l.addBus(b);
			}
		}
	}
}
