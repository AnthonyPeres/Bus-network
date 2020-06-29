package modele;

import utilitaire.Position;

public class Arret {

	/* Variables */
	private int id;
	private String nom;
	private Position position;
	
	
	/* Constructeurs */
	public Arret(String nom, Position position) {
		this.id = Reseau.getInstance().getNbArrets() + 1;
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

	@Override
	public String toString() {
		return "Arret [id=" + id + ", nom=" + nom + ", position=" + position + "]";
	}


	public void setPosition(Position position) {
		this.position = position;
	}	
}
