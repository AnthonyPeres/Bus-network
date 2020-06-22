package modele;

import utilitaire.Position;

public class Arret {

	private int id;
	private String nom;
	private Position position;
	
	public Arret() {
		
	}
	
	public Arret(String nom, Position position) {
		this.nom = nom;
		this.position = position;
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

	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
