package reseau;

import java.util.LinkedList;

public class Ligne {

	private int id;
	private String nom;
	private LinkedList<Arret> arrets;
	
	public Ligne() {
		this.arrets = new LinkedList<Arret>();
	}
	
	public Ligne(String nom) {
		this.nom = nom;
		this.arrets = new LinkedList<Arret>();
	}
	
	public Ligne(String nom, LinkedList<Arret> arrets) {
		this.nom = nom;
		this.arrets = arrets;
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
	
	public void addArret(Arret arret) {
		this.arrets.add(arret);
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public Arret getPremierArret() {
		if (!this.arrets.isEmpty()) {
			return this.arrets.getFirst();
		}
		return null;
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
	
}
