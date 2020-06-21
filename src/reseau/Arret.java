package reseau;

public class Arret {

	private int id;
	private String nom;
	private String position;
	
	public Arret() {
		
	}
	
	public Arret(String nom, String position) {
		this.nom = nom;
		this.position = position;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
