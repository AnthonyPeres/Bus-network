package modele;

import java.util.LinkedList;

public class Ligne {

	/* Variables */
	private int id;
	private String nom;
	private LinkedList<Arret> arrets;
	private LinkedList<Integer> trajets;
	
	/* Constructeur */
	public Ligne(String nom) {
		this.id = Reseau.getInstance().getNbLigne() + 1;
		this.nom = nom;
		this.arrets = new LinkedList<Arret>();
		this.trajets = new LinkedList<Integer>();
	}

	
	/* Fonctions */
	public void addArret(Arret arret) {
		this.arrets.add(arret);
		this.trajets.add(100);
	}
	
	public Arret getPremierArret() {
		if (!this.arrets.isEmpty()) {
			return this.arrets.getFirst();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Ligne [id=" + id + ", nom=" + nom + ", arrets=" + arrets + ", trajets=" + trajets + "]";
	}


	public Arret getArretSuivant(Arret precedant) {
		if (!precedant.getNom().contentEquals(getTerminus().getNom())) {
			for (int i = 0; i < this.arrets.size(); i++) {
				if (this.arrets.get(i).getNom().contentEquals(precedant.getNom())) {
					return this.arrets.get(i+1);
				}
			}
		} 
		return null;
	}
	
	public Arret getTerminus() {
		if (!this.arrets.isEmpty()) {
			return this.arrets.getLast();
		}
		return null;
	}
	
	
	/* Accesseurs - Mutateurs */
	public int getID() {
		return this.id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LinkedList<Arret> getArrets() {
		return arrets;
	}

	
	public void setArrets(LinkedList<Arret> arrets) {
		this.arrets = arrets;
	}
	
	public LinkedList<Integer> getTrajets() {
		return this.trajets;
	}
	
	public void setTrajets(LinkedList<Integer> trajets) {
		this.trajets = trajets;
	}
}
