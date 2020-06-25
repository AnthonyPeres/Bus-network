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
	
	/* Variables */
	protected LinkedList<Ligne> lignes = new LinkedList<Ligne>();
	protected LinkedList<Bus> lesbus = new LinkedList<Bus>();
	
	/* Constructeur */
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
	
	/* Observer */
	public void notifier() {
		System.out.println("Le réseau a été notifié");
	}
	
	/* Fonctions */
	public Ligne addLigne(Ligne l) {
		lignes.add(l);
		return ligneDao.create(l);
	}
	
	public void removeLigne(Ligne l) {
		lignes.remove(l);
		ligneDao.delete(l);
	}
	
	public LinkedList<Ligne> getLignes() {
		if (ligneDao.findAll() == null) {
			return null;
		}
		return ligneDao.findAll();
	}
	

	
	public Bus addBus(Bus b) {
		this.lesbus.add(b);
		return busDao.create(b);
	}

	public String getBusLigne(Ligne l, Arret a) {
		for (Bus b: lesbus) {
			if (b.getArret() != null) {
				if (b.getArret().getNom().contentEquals(a.getNom())) {
					return "Bus" + String.valueOf(b.getNumero());
				}
			}	
		}
		return null;
	}

	public LinkedList<Bus> getBus() {
		return this.lesbus;
	}
	
	
	public void placer(Bus b1, Ligne l1) {
		b1.setArret(l1.getPremierArret());
	}

	public int getNbLigne() {
		return this.lignes.size();
	}
	
	public int getNbArrets() {
		int nbArrets = 0;
		
		for (Ligne l: this.lignes) {
			nbArrets += l.getArrets().size();
		}
		
		return nbArrets;
	}
	
	
}
