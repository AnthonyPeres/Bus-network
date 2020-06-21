package reseau;

import java.util.LinkedList;
import javax.swing.JFrame;


import dao.*;
import dao.DAOFactory.SourceDonnees;

public class Main {

	private static Reseau reseau;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		reseau = new Reseau();
		
		Ligne l1 = new Ligne("Ligne 1");
		Ligne l2 = new Ligne("Ligne 2");
		
		Arret a1 = new Arret("A", "");
		Arret a2 = new Arret("B", "");
		Arret a3 = new Arret("C", "");
		Arret a4 = new Arret("D", "");
		Arret a5 = new Arret("E", "");
		Arret a6 = new Arret("F", "");
		
		
		l1.addArret(a1);
		l1.addArret(a2);
		l1.addArret(a3);
		l1.addArret(a4);
		
		l2.addArret(a5);
		l2.addArret(a3);
		l2.addArret(a6);
		
		reseau.addLigne(l1);
		reseau.addLigne(l2);
		
		InterfaceGraphique frame = new InterfaceGraphique(reseau);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1200, 800);
	    frame.setVisible(true);
		 
	}

}
