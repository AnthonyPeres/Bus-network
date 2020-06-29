package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import modele.Arret;
import modele.Bus;
import modele.Ligne;
import modele.Reseau;
import observer.Observateur;
import utilitaire.Position;


public class Simulation extends JFrame implements Observateur {	
	
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
	
	/* Variables */
	private static Reseau reseau;
	
	private static final int FENETRE_L = 1200;
	private static final int FENETRE_H = 800;
 
	/* Constructeur */
  	public Simulation() {
	    super("Simulation réseau de bus");
	    

  		/* On crée le réseau */
  		reseau = initReseau();
  		
  		/* On fait sortir les bus du dépot et on lance la fonction run pour chacun d'eux*/
  		for (Bus b: reseau.getBus()) {
  			b.sortirDepot();
  			b.run();
  		}
  		
		/* On lance l'affichage, celui-ci devrait être rafraichit en meme temps que la fonction run. */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FENETRE_L, FENETRE_H);
		this.setVisible(true);
  	}

  	/* Création du réseau. */
	private Reseau initReseau() {
		Reseau r = new Reseau();
		
		/* Les arrets */
		Arret a1, a2, a3, a4, a5, a6;
		a1 = new Arret("A", new Position(100, 20));
		a2 = new Arret("B", new Position(200, 20));
		a3 = new Arret("C", new Position(300, 100));
		a4 = new Arret("D", new Position(50, 200));
		a5 = new Arret("E", new Position(150, 200));
		a6 = new Arret("F", new Position(250, 200));
		
		/* Les lignes */
		Ligne l1 = new Ligne("Ligne 1");
		Ligne l2 = new Ligne("Ligne 2");
		Ligne l3 = new Ligne("Ligne 3");
		l1.addArret(a1);
		l1.addArret(a2);
		l1.addArret(a3);
		l1.addArret(a4);
		l2.addArret(a5);
		l2.addArret(a3);
		l2.addArret(a6);
		l3.addArret(a4);
		l3.addArret(a1);
		l3.addArret(a2);
		
		/* Les bus */
		Bus b1, b2, b3;
  		b1 = new Bus(1, this);
		b2 = new Bus(2, this);
		b3 = new Bus(3, this);
		
		/* Le réseau, on ajoute les lignes puis les bus auxquels on associe une ligne*/
		r.addLigne(l1);
		r.addLigne(l2);
		r.addLigne(l3);
		r.addBus(b1, l1);
		r.addBus(b2, l2);
		r.addBus(b3, l3);
		
		
		return r;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    
	    try {
	    	
	    	ArrayList<Object> objets;

	    	int indice = 0;
	    	
	    	for (Ligne l: reseau.getLignes()) {
	    		
	    		objets = new ArrayList<Object>();
	    		
	    		for (Arret a: l.getArrets()) {
    				objets.add(graph.insertVertex(parent, null, a.getNom(), a.getPosition().getPositionX(), (a.getPosition().getPositionY()), 40, 15));
	    			
	    			if (indice >= 1) {
	    				graph.insertEdge(parent, null, null, objets.get(indice -1), objets.get(indice));
	    			}
	    			
	    			indice++;
	    			
	    		}
	    		indice = 0;
	    		for (Bus b: reseau.getBus()) {
	    			objets.add(graph.insertVertex(parent, null, b.getNumero(), b.getPosition().getPositionX(), (b.getPosition().getPositionY()), 20, 10));
	    		}
	    	}
	    } finally {
	    	graph.getModel().endUpdate();
	    }
	    
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    graphComponent.setBounds(0, 0, FENETRE_L, FENETRE_H);
	    getContentPane().add(graphComponent);
		
	}
}