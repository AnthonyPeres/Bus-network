package modele;

import utilitaire.Position;

public class Arret {

	/* Variables */
	private int id;
	private String nom;
	private Position position;
	
	
	/* Constructeurs */
	public Arret() {
		
	}
	
	public Arret(String nom, Position position) {
		this.nom = nom;
		this.position = position;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}	
}
