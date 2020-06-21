package reseau;

import java.util.LinkedList;
import java.util.List;

public class Ligne {

	private int id;
	private String nom;
	private List<Arret> arrets;
	
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

	public List<Arret> getArrets() {
		return arrets;
	}

	public void setArrets(List<Arret> arrets) {
		this.arrets = arrets;
	}
	
	public void addArret(Arret arret) {
		this.arrets.add(arret);
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
