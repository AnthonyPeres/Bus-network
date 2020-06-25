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
import utilitaire.Position;


public class Simulation extends JFrame {	
	
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
	
	/* Variables */
	private static Reseau reseau;
	
	private static final int MENU_H = 50;
	private static final int FENETRE_L = 1200;
	private static final int FENETRE_H = 800;
 
	/* Constructeur */
  	public Simulation(Reseau reseau) {
	    super("Simulation réseau de bus");
	    
	    /* La partie menu */
	    JPanel menu = new JPanel();
	    menu.setBackground(SystemColor.inactiveCaption);
	    menu.setBounds(0, 0, FENETRE_L, MENU_H);
	    getContentPane().add(menu);
	    menu.setLayout(null);
	    
	    /* Bouton activer simulation */
	    JButton boutonRunOrStop = new JButton("Lancer la simulation");
	    boutonRunOrStop.setBounds(500, 15, 200, 20);
	    boutonRunOrStop.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		// Lancer ou arreter simulation
	    	}
	    });
	    
	    menu.add(boutonRunOrStop);
	    
	    /* La partie simulation */
	    mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    
	    try {
	    	
	    	ArrayList<Object> objets;

	    	int indice = 0;
	    	
	    	for (Ligne l: reseau.getLignes()) {
	    		
	    		objets = new ArrayList<Object>();
	    		
	    		for (Arret a: l.getArrets()) {
	    			
    				// On place l'arret
	    			objets.add(graph.insertVertex(parent, null, a.getNom(), a.getPosition().getPositionX(), (MENU_H + a.getPosition().getPositionY()), 40, 15));
	    			
	    			
	    			// Si il y en a des déjà placé, on le relie
	    			if (indice >= 1) {
	    				
	    				graph.insertEdge(parent, null, reseau.getBusLigne(l, a), objets.get(indice -1), objets.get(indice));
	    			}
	    			
	    			indice++;
	    			
	    		}
	    		indice = 0;
	    	}
	    } finally {
	    	graph.getModel().endUpdate();
	    }
	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    graphComponent.setBounds(0, MENU_H, FENETRE_L, (FENETRE_H - MENU_H));
	    getContentPane().add(graphComponent);
  	}
  	
  	
  	
  	/* Main */
  	public static void main(String[] args) {

  		/* On crée le réseau */
  		reseau = initReseau();
  				
  		for (Ligne l: reseau.getLignes()) {
  			for (Bus b: reseau.getBus()) {
  				b.sortirDepot();
  			}
  		}
  		
  		for (Ligne l: reseau.getLignes()) {
  			for (Bus b: reseau.getBus()) {
  				b.run(l);
  			}
  		}
  		
		/* La simulation */
		Simulation simulation = new Simulation(reseau);
		simulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simulation.setSize(FENETRE_L, FENETRE_H);
		simulation.setVisible(true);
	    
	}


  	/* Création du réseau. */
	private static Reseau initReseau() {
		Reseau r = new Reseau();
		
		/* Les bus */
  		Bus b1, b2, b3;
  		b1 = new Bus(1);
		b2 = new Bus(2);
		b3 = new Bus(3);
		
		/* Les arrets */
		Arret a1, a2, a3, a4, a5, a6;
		a1 = new Arret("A", new Position(100, 20));
		a2 = new Arret("B", new Position(200, 20));
		a3 = new Arret("C", new Position(300, 100));
		a4 = new Arret("D", new Position(50, 200));
		a5 = new Arret("E", new Position(150, 200));
		a6 = new Arret("F", new Position(250, 200));
		
		/* Les lignes */
		Ligne l1, l2;
		l1 = new Ligne("Ligne 1");
		l2 = new Ligne("Ligne 2");
		l1.addArret(a1);
		l1.addArret(a2);
		l1.addArret(a3);
		l1.addArret(a4);
		l2.addArret(a5);
		l2.addArret(a3);
		l2.addArret(a6);
		r.addBus(b1);
		r.addBus(b2);
		r.addBus(b3);
		
		/* Le réseau */
		r.addLigne(l1);
		r.addLigne(l2);
		
		return r;
	}
}